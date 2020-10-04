package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/home")
	public ModelAndView homePage()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("user") User user)
	{
		if(userService.checUser(user))
			return new ModelAndView("welcome");
		else
			return new ModelAndView("login");
	}
}
