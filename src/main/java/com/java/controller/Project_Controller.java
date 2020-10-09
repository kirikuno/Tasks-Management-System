package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Task;
import com.java.service.TaskService;

@Controller
public class Project_Controller {
	@Autowired
	TaskService taskservice;
	@RequestMapping(value="/create-project")
	public ModelAndView cprojectdetail()
	{
		List<Task> task=taskservice.getAllTask();
		ModelAndView model=new ModelAndView("create-project");
		model.addObject("task", task);
		return model;
	}
	@PostMapping(value = "/create-project")
	public ModelAndView createPJ() {
		
		return null;
		
	}
	
}