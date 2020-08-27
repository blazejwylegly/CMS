 package com.wylegly.clinic.domain;

import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class DentalProcedureDetailsImpl implements DentalProcedureDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private Double cost;
	
	@Column(name = "duration")
	private Duration duration;
	
	public DentalProcedureDetailsImpl() {
	
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public Double getCost() {
		return this.cost;
	}
	@Override
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
	
}
