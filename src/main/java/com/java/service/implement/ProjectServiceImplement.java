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

	@Override
	public void updateProject(Project project) {
	projectDao.updateProject(project);
		
	}

	@Override
	public Project getbyId(int id) {
		
		return projectDao.getbyId(id);
	}

	@Override
	public void deleteProject(int id) {
		projectDao.deleteProject(id);
		
	}

	@Override
	public Project getProjectByTaskId(int id) {
		return projectDao.getProjectByTaskId(id);
	}
	




	


}
