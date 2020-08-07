package com.wylegly.clinic.data_layer;

import java.util.List;

import org.hibernate.Hibernate;
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
		
		Doctor doctor = session.get(Doctor.class, id);
		
		Hibernate.initialize(doctor.getPatients());
		return doctor;
	}
	
//	@Override
//	public void delete(Doctor obj) {
//		// TODO Auto-generated method stub
//		super.delete(obj);
//	}
//	
//	@Override
//	public void deleteWithId(int id) {
//		// TODO Auto-generated method stub
//		super.deleteWithId(id);
//	}


}
