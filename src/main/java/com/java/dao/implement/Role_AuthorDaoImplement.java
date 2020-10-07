package com.java.dao.implement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.Role_AuthorDao;
import com.java.model.Role_Author;

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
			String sql = "INSERT INTO Role_Author " +
					"(userid,role_id) VALUES (?,?)" ;
			getJdbcTemplate().update(sql, new Object[]{
					ra.getUser_id(), ra.getRole_id()
			});
	}
        
}
