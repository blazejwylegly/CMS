package com.wylegly.clinic.service_layer;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wylegly.clinic.data_layer.DoctorDao;
import com.wylegly.clinic.data_layer.GenericDao;
import com.wylegly.clinic.domain.Doctor;

@Service
public class DoctorServiceImpl extends GenericServiceImpl<Doctor> implements DoctorService{

	private DoctorDao doctorDao;
	
	public DoctorServiceImpl() {
		
	}
	
	@Autowired
	public DoctorServiceImpl(@Qualifier("doctorDaoImpl") GenericDao<Doctor> doctorDao) {
		super(doctorDao);
		this.doctorDao = (DoctorDao) doctorDao;
	}


	@Override
	@Transactional
	public List<Doctor> searchDoctors(String searchedName) {
		return doctorDao.searchDoctors(searchedName);
	}

		
	
}
