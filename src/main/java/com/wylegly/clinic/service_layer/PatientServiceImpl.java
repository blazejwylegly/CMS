package com.wylegly.clinic.service_layer;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wylegly.clinic.data_layer.GenericDao;
import com.wylegly.clinic.data_layer.PatientDao;
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
	public void executePatientSpecificMethod() {
		patientDao.patientSpecificMethod();
	}

	@Override
	@Transactional
	public List<Patient> searchPatients(String searchedName) {
		return patientDao.searchPatients(searchedName);
	}
	
	
	/**
	 * @TODO
	 * Implement Patient - specific methods
	 * */
	
	
}
