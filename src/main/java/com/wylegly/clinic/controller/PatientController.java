package com.wylegly.clinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wylegly.clinic.domain.Patient;
import com.wylegly.clinic.service.DoctorService;
import com.wylegly.clinic.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/list")
	public String listPatients(Model model) {

		List<Patient> patients = patientService.getAll();

		model.addAttribute("patients", patients);

		return "patients-list-new";
	}

	@GetMapping("/addPatient")
	public String showAddPatientForm(Model model) {
		Patient patient = new Patient();

		model.addAttribute("patient", patient);
		model.addAttribute("doctorList", doctorService.getAll());

		return "patients-add";
	}

	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient, BindingResult bindingResult) {

		String doctorInChargeValue = (String) bindingResult.getFieldValue("doctorInCharge");

		if (doctorInChargeValue != null && !doctorInChargeValue.trim().isEmpty()) {

			Integer doctorInChargeId = Integer.parseInt(doctorInChargeValue);

			if (doctorInChargeId != null) {
				System.out.println(doctorInChargeId);
				patient.setDoctorInCharge(doctorService.get(doctorInChargeId));
			}
		}

		patientService.saveOrUpdate(patient);
		return "redirect:/patients/list";
	}

	@GetMapping("/updatePatient")
	public String showUpdatePatientForm(@RequestParam("patientId") int patientId, Model model) {

		Patient patient = patientService.get(patientId);
		model.addAttribute("patient", patient);
		model.addAttribute("doctorInCharge", patient.getDoctorInCharge());
		model.addAttribute("doctorList", doctorService.getAll());

		return "patients-add";
	}

	@GetMapping("/deletePatient")
	public String showDeletePatientForm(@RequestParam("patientId") int patientId) {
		patientService.remove(patientId);
		return "redirect:/patients/list";
	}

	@GetMapping("/searchPatient")
	public String showSearchPatientForm(@RequestParam("searchedName") String searchedName, Model model) {

		List<Patient> patientsFound = patientService.searchPatients(searchedName);

		model.addAttribute("patients", patientsFound);

		return "patients-list";
	}

	// COMMENT FOR COMMIT TEST POURPOSES - MASTER

}
