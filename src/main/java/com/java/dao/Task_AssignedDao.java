package com.java.dao;

import java.util.List;

import com.java.model.Task_Assigned;

public interface Task_AssignedDao {
	List<Task_Assigned> getTaskAssignedByUsername(String username);
	List<Task_Assigned> getTaskAssignedByTaskId(int id);
	List<Task_Assigned> getallTaskAssignedByID(int id);
	void deleteAssignedTask(int task_id, int user_id, int phase_id);
	
}
