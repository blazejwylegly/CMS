package com.wylegly.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wylegly.clinic.domain.Patient;
import com.wylegly.clinic.service_layer.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String listPatients(Model model) {
		
		List<Patient> patients = patientService.getAll();
		if(patients.isEmpty()) {
			System.out.println("Empty");
		}
		for (Patient patient : patients) {
			System.out.println(patient);
		}
		return "list-patients";
	}
}
