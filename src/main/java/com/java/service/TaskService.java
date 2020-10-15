package com.java.service;


import java.util.List;


import com.java.model.Task;

public interface TaskService {
  List<Task> getAllTask();
  void insertTask(Task task);
<<<<<<< HEAD
  Task getbyid(int id);
=======
  Task getbyid(int id); 
>>>>>>> branch 'master' of https://github.com/kirikuno/Tasks-Management-System
  public List<Task> getbyProject(int id);
	void deleteTask(int id);
	void updateTask(Task id);
}
