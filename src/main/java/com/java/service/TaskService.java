package com.java.service;


import java.util.List;


import com.java.model.Task;

public interface TaskService {
  List<Task> getAllTask();
  void insertTask(Task task);
  Task getbyid(int id); 
  public List<Task> getbyProject(int id);
	void deleteTask(int id);
}
