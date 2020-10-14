package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Category;
import com.java.model.Project;
import com.java.model.Role;
import com.java.model.Role_Author;
import com.java.model.Task_Assigned;
import com.java.model.User;
import com.java.service.CategoryService;
import com.java.service.ProjectService;
import com.java.service.RoleService;
import com.java.service.Role_AuthorService;
import com.java.service.TaskService;
import com.java.service.Task_AssignedService;
import com.java.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	RoleService roleService;

	@Autowired
	Role_AuthorService roleAuthorService;

	@Autowired
	Task_AssignedService taskAssignedService;

	@Autowired
	ProjectService projectService;

	@Autowired
	TaskService taskService;

	@RequestMapping(value = { "/login", "/" })
	public ModelAndView firstPage() {
		User user = new User();
		ModelAndView model = new ModelAndView("authentication-login1");
		model.addObject("user", user);
		return model;
	}

	@GetMapping(value = "/assigned-task/{id}")
	public ModelAndView taskDetail(@PathVariable(name = "id") int id) {
		List<Task_Assigned> assignedTasks = taskAssignedService.getTaskAssignedByTaskId(id);
		ModelAndView model = new ModelAndView("assigned-task");
		model.addObject("assignedTasks", assignedTasks);
		return model;
	}

	@RequestMapping(value = "/menu2")
	public ModelAndView registerUser() {
		ModelAndView model = new ModelAndView("create-user", "user", new User());

		List<Role> roleList = roleService.getAllRoles();

		model.addObject("roleList", roleList);

		return model;
	}

	@RequestMapping("/menu3")
	public ModelAndView createProject() {
		return new ModelAndView("create-project", "project", new Project());
	}

	@RequestMapping(value = "/menu4")
	public ModelAndView analysis() {
		return new ModelAndView("analysis");
	}

	@RequestMapping(value = "/home")
	public ModelAndView homePage() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("user") User user) {
		if (userService.checkUser(user)) {
			ArrayList<Category> menuList = userService.loadingMenu(user);

			List<Task_Assigned> taskAssignedList = taskAssignedService.getTaskAssignedByUsername(user.getUsername());

			ModelAndView model = new ModelAndView("index", "menuList", menuList);
			model.addObject("taskAssignedList", taskAssignedList);
			return model;
		} else
			return new ModelAndView("authentication-login1");
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView processRegister(@ModelAttribute("user") User user,
			@RequestParam(value = "role_id", required = true) ArrayList<String> roleIdList) {
		if (userService.checkExistUser(user)) // exist UserName in DB
		{
			return registerUser(); // + show fail
		} else {
			userService.insertUser(user);

			ArrayList<Role_Author> roleAuthorList = new ArrayList<Role_Author>();

			for (String role_id : roleIdList) {
				Role role = new Role();
				role.setRole_id(role_id);
				user.setUser_id(userService.getIdByUsername(user.getUsername()));
				Role_Author roleAuthor = new Role_Author(user, role);
				roleAuthorList.add(roleAuthor);
			}
			roleAuthorService.insertRoleAuthors(roleAuthorList);
			return registerUser(); // + show success
		}
	}

}