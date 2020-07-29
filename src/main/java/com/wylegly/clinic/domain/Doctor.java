package com.wylegly.clinic.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("doctor")
public class Doctor extends Person{

	// mappedBy - which member in child class represents parent class (this class)
//	@OneToMany(mappedBy = "doctorInCharge",
//			fetch = FetchType.LAZY,
//			cascade = {
//					CascadeType.MERGE,
//					CascadeType.PERSIST,
//					CascadeType.REFRESH,
//					CascadeType.DETACH
//			})
//	private List<Patient> patients;

	public Doctor() {
		
	}
	
//
//	public List<Patient> getPatients() {
//		return patients;
//	}
//
//	public void setPatients(List<Patient> patients) {
//		this.patients = patients;
//	}
//	
//	public void addPatient(Patient patient) {
//		if(this.patients == null) this.patients = new ArrayList<>();
//		if(patient != null) this.patients.add(patient);
//	}
//	
	
}
