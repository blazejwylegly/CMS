package com.wylegly.clinic.domain;

import com.wylegly.clinic.domain.procedures.DentalProcedure;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("patient")
public class Patient extends Person{

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH,
					CascadeType.DETACH
			})
	@JoinColumn(name = "id_doctor_in_charge")
	private Doctor doctorInCharge;
	
	@OneToMany(
			mappedBy = "patient",
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH,
					CascadeType.DETACH
			})
	private List<DentalProcedure> procedures;
	
	public Patient() {
		
	}

	public Doctor getDoctorInCharge() {
		return doctorInCharge;
	}

	public void setDoctorInCharge(Doctor doctorInCharge) {
		this.doctorInCharge = doctorInCharge;
	}

}
