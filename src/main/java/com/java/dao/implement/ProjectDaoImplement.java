package com.java.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.ProjectDAO;
import com.java.dao.TaskDAO;
import com.java.model.Project;
import com.java.model.Task;


@Repository
public class ProjectDaoImplement extends JdbcDaoSupport implements ProjectDAO{

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public List<Project> getAllProject() 
	{
		String sql = "SELECT * FROM project";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Project> result = new ArrayList<Project>();
		
		for (Map<String, Object> row : rows) 
		{
			Project project = new Project();
			project.setProject_id((int)row.get("project_id"));
			project.setProject_name((String) row.get("project_name"));
			project.setDue_date((Date) row.get("due_date"));
			project.setProject_description((String) row.get("project_description"));
			
			result.add(project);
		}
		return result;
	}


	@Override
	public void insertProject(Project project) {
		String sql = "INSERT INTO project " +
				"( project_name,project_description,due_date) VALUES (?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				project.getProject_name(), project.getProject_description(),project.getDue_date()
		});
		
	}



}
