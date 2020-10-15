package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Project;
import com.java.model.Task;
import com.java.model.Task_Assigned;
import com.java.model.User;
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
	int id_pj; 
	@GetMapping(value = "task-project/{id}")
	public ModelAndView taskProject(@PathVariable(name = "id") int id) {

		ModelAndView model = new ModelAndView("tasks");
		List<User> users = userservice.getAllUsers();
		List<Task> tasks = taskservice.getbyProject(id);
		id_pj=id;
		model.addObject("tasks", tasks);
		model.addObject("users", users);
		model.addObject("user", new User());
		model.addObject("task", new Task());

		return model;
	}

	@GetMapping(value = "edit-task/{id}")
	public ModelAndView eitTask(@PathVariable(name = "id") int id, @ModelAttribute("task") Task task) {
		ModelAndView model = new ModelAndView("tasks");
		task = taskservice.getbyid(id);
		List<Task> tasks = taskservice.getbyProject(id);
		List<User> users = userservice.getAllUsers(); 
		model.addObject("tasks", tasks);
		model.addObject("task", task);
		model.addObject("users", users);
		
		return model;
	}

	@PostMapping(value = "/add-task")
	public ModelAndView createtask(@ModelAttribute("task") Task task,@RequestParam("user_name") String username) {
		task.getLead_id().setUser_id(userservice.getIdByUsername(username));
		
//		if ((task.getTask_id()) != 0) {
//			
//			taskservice.updateTask(task);
//		} else {
//			
//			taskservice.insertTask(task);
//		}

		return taskProject(id_pj);
	}

	@GetMapping(value = "delete-task/{id}")
	public ModelAndView delete(@PathVariable(name = "id") int id) {
		taskservice.deleteTask(id);
		return null;

	}

	@GetMapping(value = "task-detail/{id}")
	public ModelAndView taskDetail2(@PathVariable(name = "id") int id) {

		ModelAndView model = new ModelAndView("task-detail");
		List<Task_Assigned> task_asign = task_asignedservice.getallTaskAssignedByID(id);
		model.addObject("taskAssign", task_asign);

		return model;
	}
}