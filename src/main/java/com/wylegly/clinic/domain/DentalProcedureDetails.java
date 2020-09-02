 package com.wylegly.clinic.domain;

import java.time.Duration;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class DentalProcedureDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private Double cost;
	
	@Column(name = "duration")
	private Duration duration;
	
//	@OneToMany(mappedBy = "details",
//			fetch = FetchType.LAZY,
//			cascade = {
//					CascadeType.MERGE,
//					CascadeType.PERSIST,
//					CascadeType.REFRESH,
//					CascadeType.DETACH
//			})
//	private List<DentalProcedure> procedures;
	
	public DentalProcedureDetails() {
	
	}
	
	public String getName() {
		return this.name;
	}
	
	public Double getCost() {
		return this.cost;
	}

	public Duration getDuration() {
		return this.duration;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public List<DentalProcedure> getProcedures() {
//		return procedures;
//	}
//
//	public void setProcedures(List<DentalProcedure> procedures) {
//		this.procedures = procedures;
//	}
	
	
}
