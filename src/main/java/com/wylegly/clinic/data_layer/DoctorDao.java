package com.wylegly.clinic.data_layer;

import java.util.List;

import com.wylegly.clinic.domain.Doctor;

public interface DoctorDao extends GenericDao<Doctor>{
	
	public List<Doctor> searchDoctors(String searchedName);

}
