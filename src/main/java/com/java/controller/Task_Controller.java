package com.java.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.java.model.Project;
import com.java.model.Task;
import com.java.model.Task_Assigned;

import com.java.model.User;

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
		List<User> users = userservice.getAllUsers();
		List<Task> tasks = taskservice.getbyProject(id);
		Project pj = projectService.getbyId(id);

		model.addObject("tasks", tasks);
		model.addObject("users", users);
		model.addObject("task", new Task());
		model.addObject("project", pj);

		return model;
	}

	@RequestMapping(value = "/submitAssignedTask/{id}/{phaseId}")
	public ModelAndView submitAssignedTask(@PathVariable(name = "id") int id,
			@PathVariable(name = "phaseId") int phaseId) {
		String path = "redirect:/task-detail/" + id + "/" + phaseId;
		ModelAndView model = new ModelAndView(path);
		task_asignedservice.submitAssignedTask(id, phaseId);
		return model;
	}

	@GetMapping(value = "edit-task/{id}")
	public ModelAndView eitTask(@PathVariable(name = "id") int id, @ModelAttribute("task") Task task) {
		ModelAndView model = new ModelAndView("tasks");
		task = taskservice.getbyid(id);
		Project project=projectService.getbyId(task.getProject_id().getProject_id());
		List<Task> tasks = taskservice.getbyProject(task.getProject_id().getProject_id());
		List<User> users = userservice.getAllUsers();
		model.addObject("tasks", tasks);
		model.addObject("task", task);
		model.addObject("users", users);
		model.addObject("project", project);

		return model;
	}

	@PostMapping(value = "/add-task/{id}")
	public ModelAndView createtask(@ModelAttribute("task") Task task, @PathVariable(name = "id") int id,
			@RequestParam("user_name") String username) {
		String path = "redirect:/task-project/" + id;
		//
		User user = new User();
		user.setUser_id(userservice.getIdByUsername(username));
		System.out.println(user.getUser_id());
		task.setLead_id(user);
		//
		Project pj = new Project();
		pj.setProject_id(id);
		task.setProject_id(pj);
		//
		if ((task.getTask_id()) != 0) {

			taskservice.updateTask(task);
			System.out.println("UPDATE");
		} else {
			try {
				taskservice.insertTask(task);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("INSERT");

		}

		return new ModelAndView(path);
	}

	@GetMapping(value = "delete-task/{id}/{id2}")
	public ModelAndView delete(@PathVariable(name = "id") int id,@PathVariable(name = "id2") int id2) {
		Project pj=projectService.getbyId(id2);
		String path = "redirect:/task-project/" + pj.getProject_id();
		
		
		taskservice.deleteTask(id);
		return  new ModelAndView(path);

	}

	@GetMapping(value = "task-detail/{id}")
	public ModelAndView taskDetail2(@PathVariable(name = "id") int id) {

		ModelAndView model = new ModelAndView("task-detail");
		List<Task_Assigned> task_asign = task_asignedservice.getallTaskAssignedByID(id);
		model.addObject("taskAssign", task_asign);
		return model;
	}

	@RequestMapping(value = "/task-detail/{id}/{phaseId}")
	public ModelAndView taskDetail2(@PathVariable(name = "id") int id, @PathVariable(name = "phaseId") int phaseId) {
		String path = "task-detail";
		ModelAndView model = new ModelAndView(path);
		List<Task_Assigned> task_asign = task_asignedservice.getallTaskAssignedByID(id);
		Project project = projectService.getProjectByTaskId(id);
		Task task = taskservice.getbyid(id);
		Task_Assigned assignedTask = task_asignedservice.getAssignedTask(id, phaseId);

		model.addObject("taskAssign", task_asign);

		model.addObject("project", project);
		model.addObject("task", task);
		model.addObject("assignedTask", assignedTask);

		return model;
	}
}