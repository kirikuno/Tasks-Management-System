package com.java.service.implement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.ProjectDAO;

import com.java.model.Project;


import com.java.service.ProjectService;


@Service
public class ProjectServiceImplement implements ProjectService {

	@Autowired
	ProjectDAO projectDao;

	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return projectDao.getAllProject();
	}

	@Override
	public void insertProject(Project project) {
	 projectDao.insertProject(project);
		
	}
	




	


}
