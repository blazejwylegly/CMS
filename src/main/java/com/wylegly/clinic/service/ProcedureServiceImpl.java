package com.wylegly.clinic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wylegly.clinic.dao.GenericDao;
import com.wylegly.clinic.dao.ProcedureDao;
import com.wylegly.clinic.domain.DentalProcedure;

@Service
public class ProcedureServiceImpl extends GenericServiceImpl<DentalProcedure> implements ProcedureService {

	private ProcedureDao procedureDao;
	
	public ProcedureServiceImpl() {
		
	}
	
	@Autowired
	public ProcedureServiceImpl(@Qualifier("procedureDaoImpl") GenericDao<DentalProcedure> procedureDao) {
		super(procedureDao);
		this.procedureDao = (ProcedureDao) procedureDao;
	}
	
	
}
