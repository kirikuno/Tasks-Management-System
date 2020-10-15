package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> branch 'master' of https://github.com/kirikuno/Tasks-Management-System
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Project;
import com.java.model.Task;
import com.java.model.Task_Assigned;
<<<<<<< HEAD
import com.java.model.User;
=======
import com.java.service.ProjectService;
>>>>>>> branch 'master' of https://github.com/kirikuno/Tasks-Management-System
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
<<<<<<< HEAD
	int id_pj; 
=======
	@Autowired
	ProjectService projectService;
	
>>>>>>> branch 'master' of https://github.com/kirikuno/Tasks-Management-System
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
	
	@RequestMapping(value = "/submitAssignedTask/{id}/{phaseId}")
	public ModelAndView submitAssignedTask(@PathVariable(name = "id") int id,@PathVariable(name = "phaseId") int phaseId)
	{
		String path = "redirect:/task-detail/" + id + "/" + phaseId;
		ModelAndView model = new ModelAndView(path);
		task_asignedservice.submitAssignedTask(id,phaseId);
		return model;
	}
	

<<<<<<< HEAD
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
=======
	@RequestMapping(value = "/task-detail/{id}/{phaseId}")
	public ModelAndView taskDetail2(@PathVariable(name = "id") int id,@PathVariable(name = "phaseId") int phaseId)
	{
		String path = "task-detail";
		ModelAndView model = new ModelAndView(path);
		List<Task_Assigned> task_asign = task_asignedservice.getallTaskAssignedByID(id);
		Project project = projectService.getProjectByTaskId(id);
		Task task = taskservice.getbyid(id); 
		Task_Assigned assignedTask = task_asignedservice.getAssignedTask(id,phaseId);
>>>>>>> branch 'master' of https://github.com/kirikuno/Tasks-Management-System
		model.addObject("taskAssign", task_asign);
<<<<<<< HEAD

=======
		model.addObject("project",project);
		model.addObject("task",task);
		model.addObject("assignedTask",assignedTask);
		
>>>>>>> branch 'master' of https://github.com/kirikuno/Tasks-Management-System
		return model;
	}
}