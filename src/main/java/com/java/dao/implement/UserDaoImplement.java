package com.java.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.UserDao;
import com.java.model.Category;
import com.java.model.Project;
import com.java.model.User;

@Repository
public class UserDaoImplement extends JdbcDaoSupport implements UserDao{

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public List<User> getAllUsers() 
	{
		String sql = "SELECT * FROM [Tasks_Management].[dbo].[user];";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<User> result = new ArrayList<User>();
		
		for (Map<String, Object> row : rows) 
		{
			User user = new User();
			user.setUser_id((Integer)row.get("userid"));
			user.setUsername((String) row.get("username"));
			user.setPassword((String) row.get("password"));
			result.add(user);
		}
		return result;
	}

	@Override
	public Boolean checkUser(User user) {
		List<User> allUsers = getAllUsers();
		
		for(User u: allUsers)
		{
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Category> loadingMenu(User user) {
		String sql = " select * from [Tasks_Management].[dbo].Category where Menu_id IN (select Menu_id from [Tasks_Management].[dbo].Role_Menu where Role_id IN (select role_id from  [Tasks_Management].[dbo].Role_Author RA, [Tasks_Management].[dbo].[User] U where  username = ? and U.userid = RA.userid) group by Menu_id);";
		
		ArrayList<Category> result = new ArrayList<Category>();
		
		List<Map<String, Object>> rows  = getJdbcTemplate().queryForList(sql,new Object[]{user.getUsername()}); //
		
		for(Map<String, Object> row: rows)
		{
			Category menu = new Category();
			menu.setMenu_id((String)row.get("Menu_id"));
			menu.setMenu_name((String)row.get("Menu_name"));
			menu.setMenu_description((String)row.get("Menu_description"));
			result.add(menu);
		}
		return result;
	}

	@Override
	public Boolean checkExistUser(User user) {
        List<User> allUsers = getAllUsers();
		
		for(User u: allUsers)
		{
			if(u.getUsername().equals(user.getUsername()))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void insertUser(User user) 
	{
		String sql = "INSERT INTO [Tasks_Management].[dbo].[user] " +
				"(username,password) VALUES (?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				user.getUsername(), user.getPassword()
		});
		
	}

	@Override
	public int getIdByUsername(String username) {
		String sql = "Select userid from [Tasks_Management].[dbo].[User] where username = ? ";
		
		int result = 0;
        List<Map<String, Object>> rows  = getJdbcTemplate().queryForList(sql,new Object[]{username});
		
		for(Map<String, Object> row: rows)
		{
			result = (Integer)row.get("userid");
		}
		
		return result;
	}

	@Override
	public User getbyId(int id) {
		String sql = "SELECT * FROM [Tasks_Management].[dbo].[User] WHERE userid = ?";
		User us= (User)getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				User us = new User();
				us.setUser_id(rs.getInt("userid"));
				us.setUsername(rs.getString("username"));
				us.setPassword((rs.getString("password")));
				return us;
			}
		});
		return us;
	}

}
