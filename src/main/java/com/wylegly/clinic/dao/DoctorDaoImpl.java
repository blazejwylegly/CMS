package com.wylegly.clinic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.wylegly.clinic.domain.Doctor;

@Repository
public class DoctorDaoImpl extends GenericDaoImpl<Doctor> implements DoctorDao {

	@Override
	public List<Doctor> searchDoctors(String searchedName) {
		Query<Doctor> query = null;
		
		if(searchedName == null || searchedName.trim().length() <= 0) {
			query = currentSession().createQuery("from Doctor", Doctor.class);
		}
		else {
			query = currentSession().createQuery("from Doctor where"
					+ " lower(firstName) like :searchedName" 
					+ " or lower(secondName) like :searchedName"
					+ " or lower(suranme) like :searchedName", Doctor.class);
			query.setParameter("searchedName", "%" + searchedName.toLowerCase() + "%");
		}
		
		return query.getResultList();
	}
	
	@Override
	public Doctor get(int id) {
		
		Session session = currentSession();
		
		// Left join fetch so associated entities can be
		// loaded after closing session
		Doctor doctor = session.createQuery("select doctor "
				+ "from Doctor doctor "
				+ "left join fetch doctor.patients "
				+ "where doctor.id = :theId", Doctor.class)
				.setParameter("theId", id)
				.getSingleResult();
		return doctor;
	}
	
	@Override
	public List<Doctor> getAll() {
		
		List<Doctor> doctors;
		
		doctors = currentSession().createQuery("select doctor "
				+ "from Doctor doctor "
				+ "left join fetch doctor.patients", Doctor.class)
				.getResultList();
		
		return doctors;
	}

}
