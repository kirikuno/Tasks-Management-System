package com.java.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Project;
import com.java.model.Task;
import com.java.model.Task_Assigned;
import com.java.service.ProjectService;
import com.java.service.TaskService;
import com.java.service.Task_AssignedService;
import com.java.service.UserService;

@Controller
public class Task_Controller {
	@Autowired
	TaskService taskservice;
	@Autowired
	Task_AssignedService task_asignedservice;
	@Autowired
	UserService userservice;
	@Autowired
	ProjectService projectService;
	
	@GetMapping(value = "task-project/{id}")
	public ModelAndView taskProject(@PathVariable(name = "id") int id) {

		ModelAndView model = new ModelAndView("tasks");
		List<Task> tasks = taskservice.getbyProject(id);
		model.addObject("tasks", tasks);
		model.addObject("project", new Project());

		return model;
	}
	

	@RequestMapping(value = "/task-detail/{id}/{userId}/{phaseId}")
	public ModelAndView taskDetail2(@PathVariable(name = "id") int id,@PathVariable(name = "phaseId") int phaseId ,@PathVariable(name = "userId") int userId)
	{
		String path = "task-detail";
		ModelAndView model = new ModelAndView(path);
		List<Task_Assigned> task_asign = task_asignedservice.getallTaskAssignedByID(id);
		Project project = projectService.getProjectByTaskId(id);
		Task task = taskservice.getbyid(id); 
		Task_Assigned assignedTask = task_asignedservice.getAssignedTask(id,userId,phaseId);
		model.addObject("taskAssign", task_asign);
		model.addObject("project",project);
		model.addObject("task",task);
		model.addObject("assignedTask",assignedTask);
		
		return model;
	}
}