package com.wylegly.clinic.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wylegly.clinic.dao.GenericDao;
import com.wylegly.clinic.dao.PatientDao;
import com.wylegly.clinic.domain.Patient;

@Service
public class PatientServiceImpl extends GenericServiceImpl<Patient> implements PatientService{

	private PatientDao patientDao;
	
	public PatientServiceImpl() {
		
	}
	
	@Autowired
	public PatientServiceImpl(@Qualifier("patientDaoImpl") GenericDao<Patient> patientDao) {
		super(patientDao);
		this.patientDao = (PatientDao) patientDao;
	}

	@Override
	@Transactional
	public List<Patient> searchPatients(String searchedName) {
		return patientDao.searchPatients(searchedName);
	}
	
}
