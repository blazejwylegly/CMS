package com.wylegly.clinic.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.pl.PESEL;

@Entity
@DiscriminatorValue("doctor")
public class Doctor extends Person{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	// mappedBy - which member in child class represents parent class (this class)
	@OneToMany(mappedBy = "doctorInCharge",
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH,
					CascadeType.DETACH
			})
	private List<Patient> patients;

	public Doctor(@PESEL String pesel, String surname, 
			String firstName, String secondName) {
		super(pesel, surname, firstName, secondName);
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public void addPatient(Patient patient) {
		if(this.patients == null) this.patients = new ArrayList<>();
		if(patient != null) this.patients.add(patient);
	}
	
	
}
