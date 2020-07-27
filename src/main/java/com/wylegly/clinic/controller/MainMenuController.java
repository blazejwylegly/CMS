package com.wylegly.clinic.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainMenuController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		System.out.println("Main page requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		return "main";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@RequestParam("username") String username,
			@RequestParam("userPassword") String password, Model model) {
		 
		System.out.println("User page requested");
		//model.addAttribute("userFirstName", user.getFirstName());
		model.addAttribute("username", username);
		return "user";
	}
}
