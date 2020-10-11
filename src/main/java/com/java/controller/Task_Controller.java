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
import com.java.model.Task;
import com.java.service.ProjectService;
import com.java.service.TaskService;

@Controller
public class Task_Controller {
	@Autowired
	TaskService taskservice;

	@GetMapping(value = "task-project/{id}")
	public ModelAndView taskProject(@PathVariable(name ="id")int id) {
		
		ModelAndView model = new ModelAndView("tasks");
		List<Task>  tasks=taskservice.getbyProject(id);
		model.addObject("tasks", tasks);
		model.addObject("project", new Project());
		
		return model;
		
		
	}

}