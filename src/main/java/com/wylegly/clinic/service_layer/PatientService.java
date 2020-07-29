package com.wylegly.clinic.service_layer;

import java.util.List;

import com.wylegly.clinic.domain.Patient;

public interface PatientService extends GenericService<Patient>{

	/**
	 * @TODO
	 * Add methods that are specific for managing patients
	 * */
	
	/**
	 * Method searches patient entities for records
	 * that contain 'serachedName' as firstName, secondName or surname
	 * @param filtered value
	 * @return patients containing specified name
	 * */
	public List<Patient> searchPatients(String searchedName);
	public void executePatientSpecificMethod();
}
