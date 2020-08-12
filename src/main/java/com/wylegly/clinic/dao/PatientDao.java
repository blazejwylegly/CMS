package com.wylegly.clinic.dao;


import java.util.List;

import com.wylegly.clinic.domain.Patient;

public interface PatientDao extends GenericDao<Patient>{
	
	/**
	 * @TODO
	 * Add methods that are specific for managing patients
	 * */
	
	public void patientSpecificMethod();

	public List<Patient> searchPatients(String searchedName);
	
	@Override
	public Patient get(int id);
	
	@Override
	public List<Patient> getAll();
}
