package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Category;
import com.java.model.Role;
import com.java.model.Role_Author;
import com.java.model.User;
import com.java.service.CategoryService;
import com.java.service.RoleService;
import com.java.service.Role_AuthorService;
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

	@RequestMapping(value={"/login","/"})
	public ModelAndView firstPage() 
	{
		User user = new User();
		ModelAndView model = new ModelAndView("authentication-login1");
		model.addObject("user", user);
		return model;
	}	
	
	@RequestMapping(value="/menu1")
	public ModelAndView taskDetail()
	{
		return new ModelAndView("task-detail");
	}

	
	@RequestMapping(value="/menu2")
	public ModelAndView registerUser()
	{
        ModelAndView model = new ModelAndView("create-user","user",new User());
		
		List<Role> roleList = roleService.getAllRoles();
		
		model.addObject("roleList",roleList);
		
		return model;
	}
	
	@RequestMapping(value="/menu3")
	public ModelAndView createProject()
	{
		return new ModelAndView("create-project");
	}
	
	@RequestMapping(value="/menu4")
	public ModelAndView analysis()
	{
		return new ModelAndView("analysis");
	}
	
	@RequestMapping(value="/home")
	public ModelAndView homePage()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("user") User user)
	{
		if(userService.checkUser(user))
		{
			ArrayList<Category> menuList = userService.loadingMenu(user);
			
			return new ModelAndView("index","menuList",menuList);
		}
		else
			return new ModelAndView("authentication-login1");
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView processRegister(@ModelAttribute("user")User user, @RequestParam(value = "role_id", required = true) ArrayList<String> roleIdList )
	{
		if(userService.checkExistUser(user)) // exist UserName in DB
		{
			return registerUser(); // + show fail
		}
		else
		{
			userService.insertUser(user);
			
			ArrayList<Role_Author> roleAuthorList = new ArrayList<Role_Author>();
			
			for(String role_id: roleIdList)
			{
				Role_Author roleAuthor = new Role_Author(userService.getIdByUsername(user.getUsername()),role_id);
				roleAuthorList.add(roleAuthor);
			}
			roleAuthorService.insertRoleAuthors(roleAuthorList);
			return registerUser(); // + show success
		}
	}
	
	//test view 
	@RequestMapping(value="/project-detail")
	public ModelAndView projectdetail()
	{
		return new ModelAndView("project-detail");
	}
	@RequestMapping(value="/create-project")
	public ModelAndView cprojectdetail()
	{
		return new ModelAndView("create-project");
	}
	
	//
}