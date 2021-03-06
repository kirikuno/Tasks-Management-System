package com.java.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.ProjectDAO;

import com.java.model.Project;


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
		String sql = "SELECT * FROM [Tasks_Management].[dbo].project";
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
	public Project getProjectByTaskId(int id) 
	{
		String sql = "SELECT * FROM [Tasks_Management].[dbo].[Project] WHERE project_id in (SELECT project_id FROM [Tasks_Management].[dbo].[Tasks] WHERE task_id = ?);";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,new Object[]{id});
		Project project = new Project();
		for (Map<String, Object> row : rows) 
		{
			project.setProject_id((int)row.get("project_id"));
			project.setProject_name((String) row.get("project_name"));
			project.setDue_date((Date) row.get("due_date"));
			project.setProject_description((String) row.get("project_description"));
		}
		return project;
	}


	@Override
	public void insertProject(Project project) {
		String sql = "INSERT INTO [Tasks_Management].[dbo].project " +
				"( project_name,project_description,due_date) VALUES (?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				project.getProject_name(), project.getProject_description(),project.getDue_date()
		});
		
	}

	@Override
	public void updateProject(Project project) {
		String sql="update [Tasks_Management].[dbo].project set project_name=?,project_description=?,due_date=? where project_id=? ";
		getJdbcTemplate().update(sql,
				project.getProject_name(), project.getProject_description(),project.getDue_date(),project.getProject_id()
		);
		
	}

	@Override
	public Project getbyId(int id) {
		String sql = "SELECT * FROM [Tasks_Management].[dbo].[project] WHERE project_id = ?";
		Project project= (Project)getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Project>(){
			@Override
			public Project mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Project project = new Project();
				project.setProject_id(rs.getInt("project_id"));
				project.setProject_name(rs.getString("project_name"));
				project.setDue_date(rs.getDate("due_date"));
				project.setProject_description(rs.getString("project_description"));
				return project;
			}
		});
		return project;
	
	}

	@Override
	public void deleteProject(int id) {
		String sql="DELETE FROM [Tasks_Management].[dbo].Task_Assigned WHERE task_id in (select task_id from [Tasks_Management].[dbo].Tasks where project_id = ?); DELETE FROM [Tasks_Management].[dbo].Tasks WHERE project_id = ?; DELETE FROM [Tasks_Management].[dbo].Project WHERE project_id = ? ";
		getJdbcTemplate().update(sql,new Object[]{id,id,id});
	}



}
