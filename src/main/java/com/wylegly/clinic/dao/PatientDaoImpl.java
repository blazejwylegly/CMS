package com.wylegly.clinic.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
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
	public List<Patient> searchPatients(String searchedName) {
		
		Query<Patient> query = null;
		if(searchedName == null || searchedName.trim().length() <= 0) {
			query = currentSession().createQuery("from Patient", Patient.class);
		}
		else {
			query = currentSession().createQuery("from Patient where"
					+ " lower(firstName) like :searchedName"
					+ " or lower(secondName) like :searchedName"
					+ " or lower(surname) like :searchedName", Patient.class);
			query.setParameter("searchedName", "%" + searchedName.toLowerCase() + "%");
		}
		
		return query.getResultList();
	}
	
	@Override
	public Patient get(int id) {
		Session session = currentSession();
		Patient patient = session.get(Patient.class, id);
		Hibernate.initialize(patient.getDoctorInCharge());
		return patient;
	}
	
	@Override
	public List<Patient> getAll() {
		List<Patient> patients = null;
		Session session = currentSession();
		
		patients = session.createQuery("select patient " +
			"from Patient patient " +
			"left join fetch patient.doctorInCharge", Patient.class)
			.getResultList();
		return patients;
	}
	
}
