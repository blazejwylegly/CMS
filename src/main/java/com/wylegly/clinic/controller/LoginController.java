package com.wylegly.clinic.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
public class LoginController {

	//Method that works as pre-processor for every web request
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	@GetMapping("/showLoginForm")
	public String showLoginForm(Model model) {
		
		return "login-page";
	}
	
}
