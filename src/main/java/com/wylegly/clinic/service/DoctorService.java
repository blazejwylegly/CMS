package com.wylegly.clinic.service;

import java.util.List;

import com.wylegly.clinic.domain.Doctor;

public interface DoctorService extends GenericService<Doctor>{

	/**
	 * @TODO
	 * Add methods that are specific for managing doctors
	 * */
	
	/**
	 * Method searches doctor entities for records
	 * that contain 'serachedName' as firstName, secondName or surname
	 * @param filtered value
	 * @return docotrs containing specified name
	 * */
	public List<Doctor> searchDoctors(String searchedName);
	
}
