package com.javainspires.demothymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javainspires.demothymeleaf.form.LoginForm;

@Controller
public class LoginController {
	
	
	//to get login form page
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm()
	{
		//return html page name
		return "login";
	}
	//checking for login credentials
	@RequestMapping(value="/login",method=RequestMethod.POST)  
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm,Model model) {
		
		String username=loginForm.getUsername();
		String password=loginForm.getPassword();
		
		
		if("admin".equals(username) && "123".equals(password))
		{
			//if username and password is correct we are returning the home page
			return "home.html";
		}
		
		model.addAttribute("invaildCredentials",true);
		//returning agin login page
		return "login";
	}
}
