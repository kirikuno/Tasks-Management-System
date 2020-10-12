package com.java.service;

import java.util.List;

import com.java.model.Task_Assigned;

public interface Task_AssignedService {
      List<Task_Assigned> getTaskAssignedByUsername(String username);
  	  List<Task_Assigned> getTaskAssignedByTaskId(int id);
  	List<Task_Assigned> getallTaskAssignedByID(int id);
}
