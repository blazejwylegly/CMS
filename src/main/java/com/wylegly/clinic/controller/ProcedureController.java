package com.wylegly.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wylegly.clinic.domain.procedures.DentalProcedure;
import com.wylegly.clinic.service.DoctorService;
import com.wylegly.clinic.service.PatientService;
import com.wylegly.clinic.service.procedure.DentalProcedureService;

@Controller
@RequestMapping("/procedures")
public class ProcedureController {

	@Autowired
	private DentalProcedureService dentalProcedureService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String showListForm(Model model) {
		model.addAttribute("procedures", dentalProcedureService.getAll());
		return "procedures-list";
	}

	
	@GetMapping("/addProcedure")
	public String showAddProcedureForm(Model model,
			@RequestParam(name = "patientId") int id
			) {
		
		model.addAttribute("selectedPatient", patientService.get(id));
		model.addAttribute("newProcedure", new DentalProcedure());
		
		model.addAttribute("doctors", doctorService.getAll());
		
		return "procedure-add";
	}
}