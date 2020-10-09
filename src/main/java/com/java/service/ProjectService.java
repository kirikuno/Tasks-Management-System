package com.java.service;


import java.util.List;

import com.java.model.Project;


public interface ProjectService {
  List<Project> getAllProject();
  void insertProject(Project project);

}
