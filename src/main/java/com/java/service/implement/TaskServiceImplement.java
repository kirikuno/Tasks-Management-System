package com.java.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.TaskDAO;
import com.java.dao.UserDao;
import com.java.model.Category;
import com.java.model.Task;
import com.java.model.User;
import com.java.service.TaskService;
import com.java.service.UserService;

@Service
public class TaskServiceImplement implements TaskService {

	@Autowired
	TaskDAO taskDao;
	
	@Override
	public List<Task> getAllTask() {
		return taskDao.getAllTask();
	}

	@Override
	public void insertTask(Task task) {
		
	}



}