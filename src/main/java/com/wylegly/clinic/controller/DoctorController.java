package com.wylegly.clinic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wylegly.clinic.domain.Doctor;
import com.wylegly.clinic.service.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
	
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@GetMapping("/list")
	public String listDoctors(Model model) {
		List<Doctor> doctors = doctorService.getAll();
		model.addAttribute("doctors", doctors);
		
		return "doctors-list";
	}
	
	@GetMapping("/addDoctor")
	public String showAddDoctorForm(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		
		return "doctors-add";
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(
			@Valid @ModelAttribute("doctor") Doctor doctor,
			BindingResult bindingResult) {
		
		if(!bindingResult.hasErrors()) {
			doctorService.saveOrUpdate(doctor);
		}
		else {
			for(ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error);
			}
		}
		return "redirect:/doctors/list";
	}
	
	@GetMapping("/updateDoctor")
	public String showUpdateDoctorForm(
			@RequestParam("doctorId") int id, Model model) {
		Doctor doctor = doctorService.get(id);
		model.addAttribute("doctor", doctor);
		
		return "doctors-add";
	}
	
	@GetMapping("/deleteDoctor")
	public String showDeletePatientForm(
			@RequestParam("doctorId") int id) {
		doctorService.remove(id);
		return "redirect:/doctors/list";
		
	}
	
	@GetMapping("/details")
	public String showDoctorDetailsForm(
			@RequestParam("doctorId") int id, Model model) {
		Doctor doctor = doctorService.get(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("patients", doctor.getPatients());
		
		return "doctors-details";
	}


}
