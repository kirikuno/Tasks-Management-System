package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Project;

import com.java.service.ProjectService;



@Controller
public class Project_Controller {
	@Autowired
	ProjectService projectservice;
	
	@RequestMapping(value="/create-project")
	public ModelAndView cprojectdetail()
	{
		List<Project> projects=projectservice.getAllProject();
		ModelAndView model=new ModelAndView("create-project");
		model.addObject("projects", projects);
		model.addObject("project", new Project());
		return model;
	}
	@PostMapping(value = "/add-project")
	public ModelAndView createPJ(@ModelAttribute("project") Project project) {
		
		projectservice.insertProject(project);
		
		
	
		return new ModelAndView("redirect:create-project");
		
}
	
}