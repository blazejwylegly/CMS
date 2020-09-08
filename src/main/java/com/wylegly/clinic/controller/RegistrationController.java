package com.wylegly.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wylegly.clinic.controller.security.helper.UserAccountHelper;
import com.wylegly.clinic.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmer);
	}
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model){
		model.addAttribute("userAccount", new UserAccountHelper());
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
			@ModelAttribute(name = "userAccount") UserAccountHelper account) {
		System.out.println("New account: " + account);
		userService.save(account);
		
		
		return null;
	}
	
	
}
