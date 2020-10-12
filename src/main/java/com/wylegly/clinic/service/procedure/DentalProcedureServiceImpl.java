package com.wylegly.clinic.service.procedure;


import com.wylegly.clinic.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wylegly.clinic.dao.GenericDao;
import com.wylegly.clinic.dao.procedures.DentalProcedureDao;
import com.wylegly.clinic.domain.procedures.DentalProcedure;

@Service
public class DentalProcedureServiceImpl extends GenericServiceImpl<DentalProcedure> implements DentalProcedureService {

	private DentalProcedureDao dentalProcedureDao;
	
	public DentalProcedureServiceImpl() {
		
	}
	
	@Autowired
	public DentalProcedureServiceImpl(@Qualifier("dentalProcedureDaoImpl") GenericDao<DentalProcedure> procedureDao) {
		super(procedureDao);
		this.dentalProcedureDao = (DentalProcedureDao) procedureDao;
	}
	
	
}
