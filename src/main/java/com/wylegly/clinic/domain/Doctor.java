package com.wylegly.clinic.domain;

import com.wylegly.clinic.domain.procedures.DentalProcedure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("doctor")
public class Doctor extends Person{

	@Column(name = "children_doctor")
	private Boolean childrenDoctor;
	
	@Column(name = "work_start_at", columnDefinition = "TIME")
	@Temporal(TemporalType.TIME)
	private Date workStart;
	
	@Column(name = "work_end_at", columnDefinition = "TIME")
	@Temporal(TemporalType.TIME)
	private Date workEnd;

	@OneToMany(mappedBy = "doctorInCharge",
			fetch = FetchType.LAZY,
			cascade = {
				CascadeType.MERGE,
				CascadeType.PERSIST,
				CascadeType.REFRESH,
				CascadeType.DETACH
			})
	private List<Patient> patients;
	
	@OneToMany(mappedBy = "doctor",
			fetch = FetchType.LAZY,
			cascade = {
				CascadeType.MERGE,
				CascadeType.PERSIST,
				CascadeType.REFRESH,
				CascadeType.DETACH
			})
	private List<DentalProcedure> procedures;
	
	public Doctor() {
		
	}

	public Boolean getChildrenDoctor() {
		return childrenDoctor;
	}

	public void setChildrenDoctor(Boolean childrenDoctor) {
		this.childrenDoctor = childrenDoctor;
	}

	public Date getWorkStart() {
		return workStart;
	}

	public void setWorkStart(Date workStart) {
		this.workStart = workStart;
	}

	public Date getWorkEnd() {
		return workEnd;
	}

	public void setWorkEnd(Date workEnd) {
		this.workEnd = workEnd;
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

	@Override
	public String toString() {
		return "Doctor [childrenDoctor=" + childrenDoctor + ", workStart=" + workStart + ", workEnd=" + workEnd
				+ ", id=" + super.getId() + ", pesel=" + pesel + ", surname=" + surname + ", firstName=" + firstName
				+ ", secondName=" + secondName + "]";
	}

	@PreRemove
	public void onDeleteSetNull() {
		for(Patient patient : patients) {
			patient.setDoctorInCharge(null);
		}
	}

	
	
}
