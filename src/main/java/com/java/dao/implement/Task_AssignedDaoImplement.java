package com.java.dao.implement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.Task_AssignedDao;
import com.java.model.Task_Assigned;

@Repository
public class Task_AssignedDaoImplement extends JdbcDaoSupport implements Task_AssignedDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public List<Task_Assigned> getTaskAssignedByUsername(String username) 
	{
		String sql = "select * from [Tasks_Management].[dbo].Task_Assigned where userid in(select userid from [Tasks_Management].[dbo].[user] where username = ?)";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,new Object[]{username});
		ArrayList<Task_Assigned> result = new ArrayList <Task_Assigned>();
		
		for (Map<String, Object> row : rows) 
		{
			Task_Assigned taskAssigned = new Task_Assigned();
			taskAssigned.setTask_id((Integer)row.get("task_id"));
			taskAssigned.setUser_id((Integer)row.get("userid"));
			taskAssigned.setPhase_id((Integer)row.get("phase_id"));
			taskAssigned.setStatus((Integer)row.get("status"));
			taskAssigned.setDeadline((Date)row.get("deadline"));
			taskAssigned.setDescription((String)row.get("description"));
			taskAssigned.setFinished_date((Date)row.get("finished_date"));
			result.add(taskAssigned);
		}
		return result;
	}
	
	@Override
	public List<Task_Assigned> getTaskAssignedByTaskId(int id) 
	{
		String sql = "select * from [Tasks_Management].[dbo].Task_Assigned where task_id = ?";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,new Object[]{id});
		ArrayList<Task_Assigned> result = new ArrayList <Task_Assigned>();
		
		for (Map<String, Object> row : rows) 
		{
			Task_Assigned taskAssigned = new Task_Assigned();
			taskAssigned.setTask_id((Integer)row.get("task_id"));
			taskAssigned.setUser_id((Integer)row.get("userid"));
			taskAssigned.setPhase_id((Integer)row.get("phase_id"));
			taskAssigned.setStatus((Integer)row.get("status"));
			taskAssigned.setDeadline((Date)row.get("deadline"));
			taskAssigned.setDescription((String)row.get("description"));
			taskAssigned.setFinished_date((Date)row.get("finished_date"));
			result.add(taskAssigned);
		}
		return result;
	}

}
