package com.wylegly.clinic.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("patient")
public class Patient extends Person{

	@ManyToOne(fetch = FetchType.EAGER,
			cascade = {
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH,
					CascadeType.DETACH
			})
	@JoinColumn(name = "id_doctor_in_charge")
	private Doctor doctorInCharge;
	
	public Patient() {
		
	}

	public Doctor getDoctorInCharge() {
		return doctorInCharge;
	}

	public void setDoctorInCharge(Doctor doctorInCharge) {
		this.doctorInCharge = doctorInCharge;
	}

}
