package com.java.dao;


import java.util.List;

import com.java.model.Project;



public interface ProjectDAO {

	List<Project> getAllProject();
	void insertProject(Project project);
	
}