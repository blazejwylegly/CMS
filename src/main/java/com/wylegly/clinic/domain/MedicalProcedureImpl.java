package com.wylegly.clinic.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "procedure")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MedicalProcedureImpl implements MedicalProcedure{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "time")
	private Date time;
	
	@ManyToOne(
			fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@ManyToOne(
			fetch = FetchType.LAZY
			)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	public MedicalProcedureImpl() {
		
	}
	
	
	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public Date getTime() {
		return time;
	}

	@Override
	public Doctor getDoctor() {
		return doctor;
	}

	@Override
	public Patient getPatient() {
		return patient;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
