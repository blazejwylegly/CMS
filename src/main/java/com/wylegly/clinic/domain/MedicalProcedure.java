package com.wylegly.clinic.domain;

import java.util.Date;

public interface MedicalProcedure {

	public Date getDate();
	public Date getTime();
	public Doctor getDoctor();
	public Patient getPatient();
}
