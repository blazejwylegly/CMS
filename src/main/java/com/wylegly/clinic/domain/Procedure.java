package com.wylegly.clinic.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "treatment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "procedure_type")
public class Procedure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "start_time")
	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	@Column(name = "duration")
	private long duration;
	
	//Patient mapping
	@ManyToOne(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Doctor doctor;
	
//	//Doctors mapping
//	@ManyToMany(
//			fetch = FetchType.LAZY,
//			cascade = {
//				CascadeType.MERGE,
//				CascadeType.PERSIST,
//				CascadeType.REFRESH,
//				CascadeType.DETACH
//			})
//	private List<Doctor> medicalPersonel; 
	
	public Procedure() {
		
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

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
}
