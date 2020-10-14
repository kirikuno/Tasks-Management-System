package com.java.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.Task_AssignedDao;
import com.java.model.Task_Assigned;
import com.java.service.Task_AssignedService;

@Service
public class Task_AssignedServiceImplement implements Task_AssignedService {

	@Autowired
	Task_AssignedDao taskAssignedDao;
	
	@Override
	public List<Task_Assigned> getTaskAssignedByUsername(String username) {
		
		return taskAssignedDao.getTaskAssignedByUsername(username);
	}

	@Override
	public List<Task_Assigned> getTaskAssignedByTaskId(int id) {
		return taskAssignedDao.getTaskAssignedByTaskId(id);
	}

	@Override
	public List<Task_Assigned> getallTaskAssignedByID(int id) {
		
		return taskAssignedDao.getallTaskAssignedByID(id);
	}

	@Override
	public void deleteAssignedTask(int task_id, int user_id, int phase_id) {
		taskAssignedDao.deleteAssignedTask(task_id,user_id,phase_id);	
	}

	@Override
	public void insertAssignedTask(Task_Assigned ta) {
		taskAssignedDao.insertAssignedTask(ta);
	}

}
