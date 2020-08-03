package com.wylegly.clinic.data_layer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.wylegly.clinic.domain.Doctor;
import com.wylegly.clinic.domain.Patient;

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
	
//	@Override
//	public Doctor get(int id) {
//		
//		Session session = currentSession();
//		
//		List<Patient> patients = session.createQuery(
//				"select p " +
//				"from Patient p " +
//				"join fetch p.doctorInCharge " +
//				"where p.id = :num", Patient.class)
//			.setParameter("num", id)
//			.list();
//				
//		System.out.println("Patients retrieved " + patients);
//		return session.get(Doctor.class, id);
//	}


}
