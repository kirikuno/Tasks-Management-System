package com.java.service;

import java.util.List;

import com.java.model.Task_Assigned;

public interface Task_AssignedService {
      List<Task_Assigned> getTaskAssignedByUsername(String username);
  	  List<Task_Assigned> getTaskAssignedByTaskId(int id);
  	  List<Task_Assigned> getallTaskAssignedByID(int id);
  	  Task_Assigned getAssignedTask(int taskId, int userId, int phaseId);
	  void deleteAssignedTask(int task_id,int user_id, int phase_id);
	  void insertAssignedTask(Task_Assigned ta);
	  void updateAssignedTask(Task_Assigned ta);
}
