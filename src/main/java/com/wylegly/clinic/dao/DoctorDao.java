package com.wylegly.clinic.dao;

import java.util.List;

import com.wylegly.clinic.domain.Doctor;

public interface DoctorDao extends GenericDao<Doctor>{
	
	public List<Doctor> searchDoctors(String searchedName);
	
	@Override
	public Doctor get(int id);
}
