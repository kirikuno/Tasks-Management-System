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

import com.java.dao.TaskDAO;
import com.java.model.Project;
import com.java.model.Task;
import com.java.model.User;



@Repository
public class TaskDaoImplement extends JdbcDaoSupport implements TaskDAO{

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public List<Task> getAllTask() 
	{
		String sql = "SELECT * FROM [Tasks_Management].[dbo].Tasks";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Task> result = new ArrayList<Task>();
		
		for (Map<String, Object> row : rows) 
		{
			Task task = new Task();
			task.setTask_id((int)row.get("task_id"));
			task.setTask_name((String) row.get("task_name"));
			task.setDue_date((Date) row.get("due_date"));
			task.setStatus((String) row.get("status"));
			task.setTask_description((String)row.get("task_description"));
			task.setLead_id((User)row.get("lead_id"));
			task.setProject_id((Project) row.get("project_id"));
			result.add(task);
		}
		return result;
	}

	@Override
	public void insertTask(Task task) {
		String sql = "INSERT INTO [Tasks_Management].[dbo].tasks " +
				"(task_id, status,due_date,task_name,task_description,leader_id,project_id) VALUES (?, ?, ?,?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				task.getTask_id(), task.getStatus(),task.getDue_date(),task.getTask_name(),task.getTask_description(),task.getLead_id().getUser_id(),task.getProject_id()
		});
		
	}

	@Override
	public void updateTask(Task task) {
		String sql = "UPDATE  [Tasks_Management].[dbo].tasks " +
				"SET  status=?,due_date=?,task_name=?,task_description=?,leader_id=?,project_id=? where task_id=?" ;
		getJdbcTemplate().update(sql, new Object[]{
				task.getTask_id(), task.getStatus(),task.getDue_date(),task.getTask_name(),task.getTask_description(),task.getLead_id().getUser_id(),task.getProject_id()
		});
		
	}

	@Override
	public Task getbyid(int id) {

		String sql = "SELECT * FROM [Tasks_Management].[dbo].[tasks] WHERE task_id = ?";
		Task task= (Task)getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Task>(){
			@Override
			public Task mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Task task = new Task();
				Project project=new Project();
				project.setProject_id(rs.getInt("project_id"));
				User user=new User();
				user.setUser_id(rs.getInt("leader_id"));
				task.setTask_id(rs.getInt("task_id"));
				task.setStatus(rs.getString("status"));
				task.setDue_date(rs.getDate("due_date"));
				task.setTask_name(rs.getString("task_name"));
				task.setTask_description("task_description");
				task.setProject_id(project);
				task.setLead_id(user);
				return task;
			}
		});
		return task;
	

	

		
	}


	@Override
	public void deleteTask(int id) {
		
		
	}

	@Override
	public List<Task> getbyProject(int id) {
		String sql = "SELECT * FROM [Tasks_Management].[dbo].Tasks t,[Tasks_Management].[dbo].[user] u where project_id=? and t.leader_id = u.userid order by leader_id; ";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,id);
		
		
		List<Task> result = new ArrayList<Task>();
		for(Map<String, Object> row:rows){
			Task ta = new Task();
			User user=new User();
			user.setUser_id((int) row.get("leader_id"));
			user.setUsername((String)row.get("username"));
			Project project=new Project();
			project.setProject_id((int) row.get("project_id"));
			ta.setTask_id((int) row.get("task_id"));
			ta.setTask_name((String)row.get("task_name"));
			ta.setTask_description((String)row.get("task_description"));
			ta.setStatus((String)row.get("status"));
			ta.setDue_date((Date)row.get("due_date"));
			ta.setLead_id(user);
			ta.setProject_id(project);
			result.add(ta);
		}
		
		return result;
		


}
}