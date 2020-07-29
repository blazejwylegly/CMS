package com.wylegly.clinic.data_layer;

import java.util.List;

import org.hibernate.query.Query;
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
	
	@Override
	public List<Patient> searchPatients(String searchedName) {
		
		Query query = null;
		if(searchedName == null || searchedName.trim().length() <= 0) {
			query = currentSession().createQuery("from Patient", Patient.class);
		}
		else {
			query = currentSession().createQuery("from Patient where"
					+ " lower(firstName) like :searchedName"
					+ " or lower(secondName) like:searchedName"
					+ " or lower(surname) like:searchedName", Patient.class);
			query.setParameter("searchedName", "%" + searchedName.toLowerCase() + "%");
		}
		
		return query.getResultList();
	}
	
	
	
}
