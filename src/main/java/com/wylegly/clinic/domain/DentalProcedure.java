package com.wylegly.clinic.domain;

import java.time.Duration;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "DentalProcedure")
@Table(name = "procedure_single")
public class DentalProcedure extends MedicalProcedure
//implements DentalProcedureDetails 
{

//	@ManyToOne(fetch = FetchType.LAZY,
//			cascade = {
//					CascadeType.MERGE,
//					CascadeType.PERSIST,
//					CascadeType.REFRESH,
//					CascadeType.DETACH
//			})
//	@JoinColumn(name = "detail_id")
//	private DentalProcedureDetails details;
	
	@Column(name = "data")
	private String data;

	public DentalProcedure() {

	}
	
//	public DentalProcedureDetails getDetails() {
//		return details;
//	}
//
//	public String getName() {
//		return details.getName();
//	}
//
//	public Double getCost() {
//		return details.getCost();
//	}
//
//	public Duration getDuration() {
//		return details.getDuration();
//	}
//
//	public void setDetails(DentalProcedureDetails details) {
//		this.details = details;
//	}

}
