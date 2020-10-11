package com.java.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.java.model.Project;

import com.java.service.ProjectService;

@Controller
public class Project_Controller {
	@Autowired
	ProjectService projectservice;

	@GetMapping(value = "/create-project")
	public ModelAndView cprojectdetail() {
		List<Project> projects = projectservice.getAllProject();
		ModelAndView model = new ModelAndView("create-project");
		model.addObject("projects", projects);
		model.addObject("project", new Project());
		return model;
	}

	@PostMapping(value = "/add-project")
	public ModelAndView createPJ(@ModelAttribute("project") Project project) {
			
		if ((project.getProject_id())!=0) {
			projectservice.updateProject(project);
		} else {
			projectservice.insertProject(project);
		}

		return new ModelAndView("redirect:create-project");

	}

	@GetMapping(value = "/edit-project/{id}")
	public ModelAndView edit(@PathVariable(name = "id") int id, @ModelAttribute("project") Project project) {
		ModelAndView model = new ModelAndView("create-project");
		project = projectservice.getbyId(id);
		List<Project> projects = projectservice.getAllProject();
		model.addObject("project", project);
		model.addObject("projects", projects);
		return model;

	}
	@GetMapping(value="delete-project/{id}")
	public ModelAndView delete(@PathVariable(name = "id") int id,@ModelAttribute("project") Project project) {
		ModelAndView model = new ModelAndView("create-project");
		projectservice.deleteProject(id);
		List<Project> projects = projectservice.getAllProject();
		model.addObject("projects", projects);
		model.addObject("project", project);
		
		return  model;
		
	}

}