package com.wylegly.clinic.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wylegly.clinic.domain.DentalProcedure;

@Repository
public class ProcedureDaoImpl extends GenericDaoImpl<DentalProcedure> implements ProcedureDao {

	@Override
	public DentalProcedure get(int id) {
		System.out.println("To ten get");
		Session session = currentSession();
		DentalProcedure procedure = session.createQuery("select dentalProcedure "
				+ "from DentalProcedure dentalProcedure "
				+ "left join fetch dentalProcedure.patient "
				+ "left join fetch dentalProcedure.doctor "
				+ "where dentalProcedure.id = :theId", DentalProcedure.class)
				.setParameter("theId", id)
				.getSingleResult();
		return procedure;
				
	}
	
	@Override
	public List<DentalProcedure> getAll() {
		Session session = currentSession();
		List<DentalProcedure> procedures = null;
		
		procedures = session.createQuery("select p "
				+ "from DentalProcedure p "
				+ "left join fetch p.patient "
				+ "left join fetch p.doctor", DentalProcedure.class)
				.getResultList();
		
		return procedures;
	}
}
