package com.wylegly.clinic.data_layer;

import org.springframework.stereotype.Repository;

import com.wylegly.clinic.domain.Patient;


@Repository
public class PatientDaoImpl extends GenericDaoImpl<Patient> implements PatientDao{

	@Override
	public void patientSpecificMethod() {
	}
	/**
	 * Implement Patient - specific methods
	 * */

	@Override
	public Patient get(int id) {
		
		Patient patient = super.get(id);
		System.out.println(patient.getId());
		return patient;
	}
	
	
	
}
