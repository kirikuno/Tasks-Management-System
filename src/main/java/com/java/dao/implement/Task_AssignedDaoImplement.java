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
import com.java.model.User;

@Repository
public class Task_AssignedDaoImplement extends JdbcDaoSupport implements Task_AssignedDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<Task_Assigned> getTaskAssignedByUsername(String username) {
		String sql = "select * from [Tasks_Management].[dbo].Task_Assigned where userid in(select userid from [Tasks_Management].[dbo].[user] where username = ?)";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { username });
		ArrayList<Task_Assigned> result = new ArrayList<Task_Assigned>();

		for (Map<String, Object> row : rows) {
			Task_Assigned taskAssigned = new Task_Assigned();
			User user = new User();
			user.setUser_id((Integer) row.get("userid"));
			taskAssigned.setTask_id((Integer) row.get("task_id"));
			taskAssigned.setUser_id(user);
			taskAssigned.setPhase_id((Integer) row.get("phase_id"));
			taskAssigned.setStatus((Integer) row.get("status"));
			taskAssigned.setDeadline((Date) row.get("deadline"));
			taskAssigned.setDescription((String) row.get("description"));
			taskAssigned.setFinished_date((Date) row.get("finished_date"));
			result.add(taskAssigned);
		}
		return result;
	}

	@Override
	public List<Task_Assigned> getTaskAssignedByTaskId(int id) {
		String sql = "select * from [Tasks_Management].[dbo].Task_Assigned ta, [Tasks_Management].[dbo].[user] u where task_id = ? and u.userid = ta.userid order by phase_id;";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { id });
		ArrayList<Task_Assigned> result = new ArrayList<Task_Assigned>();
		//
		for (Map<String, Object> row : rows) {
			Task_Assigned taskAssigned = new Task_Assigned();
			User user = new User();
			user.setUser_id((Integer) row.get("userid"));
			user.setUsername((String)row.get("username"));
			
			taskAssigned.setTask_id((Integer) row.get("task_id"));
			taskAssigned.setUser_id(user);
			taskAssigned.setPhase_id((Integer) row.get("phase_id"));
			taskAssigned.setStatus((Integer) row.get("status"));
			taskAssigned.setDeadline((Date) row.get("deadline"));
			taskAssigned.setDescription((String) row.get("description"));
			taskAssigned.setFinished_date((Date) row.get("finished_date"));
			result.add(taskAssigned);
		}
		return result;
	}

	@Override
	public List<Task_Assigned> getallTaskAssignedByID(int id) {
		String sql = "select  ta.userid,ta.task_id,u.username,ta.deadline,ta.description,ta.finished_date,ta.phase_id,ta.status from [Tasks_Management].[dbo].Task_Assigned ta,[Tasks_Management].[dbo].[user] u  where ta.userid= u.userid and task_id =? order by phase_id asc";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, id);

		List<Task_Assigned> result = new ArrayList<Task_Assigned>();
		for (Map<String, Object> row : rows) {
			Task_Assigned t_a = new Task_Assigned();
			User user = new User();
			user.setUser_id((int) row.get("userid"));
			user.setUsername((String) row.get("username"));
			t_a.setTask_id((int) row.get("task_id"));
			t_a.setStatus((int) row.get("status"));
			t_a.setDescription((String) row.get("description"));
			t_a.setDeadline((Date) row.get("deadline"));
			t_a.setFinished_date((Date) row.get("finished_date"));
			t_a.setUser_id(user);
			t_a.setPhase_id((int) row.get("phase_id"));
			result.add(t_a);
		}

		return result;
	}

	@Override
	public void deleteAssignedTask(int task_id, int user_id, int phase_id) 
	{
		String sql = "DELETE FROM [Tasks_Management].[dbo].[Task_Assigned] WHERE task_id = ? and userid=? and phase_id=?;";
		getJdbcTemplate().update(sql, new Object[]{task_id,user_id,phase_id});	
	}

	@Override
	public void insertAssignedTask(Task_Assigned ta) {
		String sql = "INSERT INTO [Tasks_Management].[dbo].[Task_Assigned] " +
				"(task_id,userid,phase_id,deadline,finished_date,description,status) VALUES (?,?,?,?,?,?,?);"
				+ "UPDATE [Tasks_Management].[dbo].[Task_Assigned] SET finished_date = NULL WHERE task_id = ? and userid = ? and phase_id = ?";
		getJdbcTemplate().update(sql, new Object[]{
				ta.getTask_id(),ta.getUser_id().getUser_id(),ta.getPhase_id(),ta.getDeadline(),ta.getFinished_date(),ta.getDescription(),ta.getStatus(),ta.getTask_id(),ta.getUser_id().getUser_id(),ta.getPhase_id()
		});
	}
	
	@Override
	public void updateAssignedTask(Task_Assigned ta) {
		String sql = "UPDATE [Tasks_Management].[dbo].[Task_Assigned] SET userid=?, phase_id=?, deadline=?, finished_date=?, description=?, status=? WHERE task_id = ? and userid = ? and phase_id = ?";
		getJdbcTemplate().update(sql, new Object[]{
				ta.getUser_id().getUser_id(),ta.getPhase_id(),ta.getDeadline(),ta.getFinished_date(),ta.getDescription(),ta.getStatus(),ta.getTask_id(),ta.getUser_id().getUser_id(),ta.getPhase_id()
		});
	}

	
	@Override
	public void submitAssignedTask(int taskId,	int phaseId) {
		String sql = "EXEC submitAssignedTask @taskId = ?, @phaseId = ?;";
		getJdbcTemplate().update(sql, new Object[]{taskId,phaseId});
	}
	
	@Override
	public Task_Assigned getAssignedTask(int taskId,int phaseId) {
		String sql = "SELECT * FROM [Tasks_Management].[dbo].[Task_Assigned] WHERE task_id = ? and phase_id=?;";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { taskId,phaseId });
		Task_Assigned taskAssigned = new Task_Assigned();
		for (Map<String, Object> row : rows) {
			
			User user = new User();
			user.setUser_id((Integer) row.get("userid"));
			user.setUsername((String)row.get("username"));
			
			taskAssigned.setTask_id((Integer) row.get("task_id"));
			taskAssigned.setUser_id(user);
			taskAssigned.setPhase_id((Integer) row.get("phase_id"));
			taskAssigned.setStatus((Integer) row.get("status"));
			taskAssigned.setDeadline((Date) row.get("deadline"));
			taskAssigned.setDescription((String) row.get("description"));
			taskAssigned.setFinished_date((Date) row.get("finished_date"));
			
		}
		return taskAssigned;
	}
}
