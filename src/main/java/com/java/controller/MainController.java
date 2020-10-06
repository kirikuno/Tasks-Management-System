package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Category;
import com.java.model.User;
import com.java.service.CategoryService;
import com.java.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;

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
		return new ModelAndView("create-user");
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
		if(userService.checUser(user))
		{
			ArrayList<Category> menuList = userService.loadingMenu(user);
			
			return new ModelAndView("index","menuList",menuList);
		}
		else
			return new ModelAndView("authentication-login1");
	}
	//test view 
	@RequestMapping(value="/project-detail")
	public ModelAndView projectdetail()
	{
		return new ModelAndView("project-detail");
	}
}