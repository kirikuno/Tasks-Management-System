package com.java.service;


import java.util.List;

import com.java.model.Project;


public interface ProjectService {
  List<Project> getAllProject();
  void insertProject(Project project);
  void updateProject(Project project);
	Project getbyId(int id);
	void deleteProject(int id);
	Project getProjectByTaskId(int id);
}
