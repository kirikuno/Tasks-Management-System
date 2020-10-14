package com.java.dao.implement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.Role_AuthorDao;
import com.java.model.Role;
import com.java.model.Role_Author;
import com.java.model.User;

@Repository
public class Role_AuthorDaoImplement extends JdbcDaoSupport implements Role_AuthorDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void ininialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public void insertRole_Author(Role_Author ra) 
	{
			String sql = "INSERT INTO [Tasks_Management].[dbo].Role_Author " +
					"(userid,role_id) VALUES (?,?)" ;
			getJdbcTemplate().update(sql, new Object[]{
					ra.getUser_id(), ra.getRole_id()
			});
	}
	
        
}
