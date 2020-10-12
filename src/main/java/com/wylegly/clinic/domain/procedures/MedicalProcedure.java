package com.wylegly.clinic.domain.procedures;

import com.wylegly.clinic.domain.Doctor;
import com.wylegly.clinic.domain.Patient;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "medicalProcedure")
@Inheritance(strategy = InheritanceType.JOINED)
public class MedicalProcedure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;	
	
	@Temporal(TemporalType.TIME)
	@Column(name = "time")
	private Date time;
	
	@ManyToOne(
			fetch = FetchType.LAZY
			)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	// Mapping describes that one patient may have
	// many appointments planned/done
	@ManyToOne(
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.MERGE,
					CascadeType.DETACH,
					CascadeType.PERSIST,
					CascadeType.REFRESH
			})
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public MedicalProcedure() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public Date getTime() {
		return time;
	}

	public Doctor getDoctor() {
		return doctor;
	}

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
