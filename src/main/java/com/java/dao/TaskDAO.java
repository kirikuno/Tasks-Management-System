package com.java.dao;


import java.util.List;


import com.java.model.Task;


public interface TaskDAO {

	List<Task> getAllTask();
	void insertTask(Task task);
	
}
