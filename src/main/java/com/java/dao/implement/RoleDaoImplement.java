package com.java.dao.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.RoleDao;
import com.java.model.Role;

@Repository
public class RoleDaoImplement extends JdbcDaoSupport implements RoleDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public List<Role> getAllRoles() 
	{
		String sql = "SELECT * FROM [Tasks_Management].[dbo].[Role];";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Role> result = new ArrayList<Role>();
		
		for (Map<String, Object> row : rows) 
		{
			Role role = new Role();
			role.setRole_id((String)row.get("role_id"));
			role.setRole_name((String) row.get("role_name"));
			result.add(role);
		}
		return result;
	}
}
