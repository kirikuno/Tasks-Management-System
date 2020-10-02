package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value={"/login","/"})
	public ModelAndView firstPage() {
		return new ModelAndView("login");
	}	
	
}
