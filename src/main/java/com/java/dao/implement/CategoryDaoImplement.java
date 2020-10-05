package com.java.dao.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.CategoryDao;
import com.java.model.Category;


@Repository
public class CategoryDaoImplement extends JdbcDaoSupport implements CategoryDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public List<Category> getAllMenu() {
		String sql = "SELECT * FROM Category;";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Category> result = new ArrayList<Category>();
		
		for (Map<String, Object> row : rows) 
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
	public Category getMenuById(String id) {
		
		String sql = "SELECT * FROM Category Where Menu_id=?;";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,new Object[]{id});
		Category result = new Category();
		
		for (Map<String, Object> row : rows) 
		{
			Category menu = new Category();
			menu.setMenu_id((String)row.get("Menu_id"));
            menu.setMenu_name((String)row.get("Menu_name"));
            menu.setMenu_description((String)row.get("Menu_description"));
		}
		return result;
	}

}
