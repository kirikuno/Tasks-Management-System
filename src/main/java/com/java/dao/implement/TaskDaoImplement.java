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

import com.java.dao.TaskDAO;

import com.java.model.Task;


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
		String sql = "SELECT * FROM Tasks";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Task> result = new ArrayList<Task>();
		
		for (Map<String, Object> row : rows) 
		{
			Task task = new Task();
			task.setTask_id((int)row.get("task_id"));
			task.setTask_name((String) row.get("task_name"));
			task.setDue_date((Date) row.get("due_date"));
			task.setStatus((String) row.get("status"));
			
			result.add(task);
		}
		return result;
	}

	@Override
	public void insertTask(Task task) {
		String sql = "INSERT INTO tasks " +
				"(task_id, status,due_date,task_name) VALUES (?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
//				emp.getEmpId(), emp.getEmpName(),emp.getDepartId()
		});
		
	}



}
