package com.wylegly.clinic.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wylegly.clinic.domain.User;


@Controller
@RequestMapping("/login")
public class LoginController {

	//Method that works as pre-processor for every web request
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage(Model model) {
		
		//create new user object
		User user = new User();
		//add new object to the model
		model.addAttribute("user", user);
		
		return "login-page";
	}
	
	
	@RequestMapping("/processLogin")
	public String showLoginPage(@Valid @ModelAttribute("user") User user,
			BindingResult bindingResult) {
		//log the input data
		if(bindingResult.hasErrors()) return "login-page";
		else return "login-confirmation-page";
	}
}
