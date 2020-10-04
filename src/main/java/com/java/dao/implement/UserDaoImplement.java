package com.java.dao.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.UserDao;
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
	public Boolean checUser(User user) {
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

}
