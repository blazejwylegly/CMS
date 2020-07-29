package com.wylegly.clinic.data_layer;


import java.util.List;

import com.wylegly.clinic.domain.Patient;

public interface PatientDao extends GenericDao<Patient>{
	
	/**
	 * @TODO
	 * Add methods that are specific for managing patients
	 * */
	
	public void patientSpecificMethod();

	public List<Patient> searchPatients(String searchedName);
}
