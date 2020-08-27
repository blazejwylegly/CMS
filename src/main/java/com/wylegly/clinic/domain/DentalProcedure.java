package com.wylegly.clinic.domain;

import java.time.Duration;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "procedure_single")
public class DentalProcedure extends MedicalProcedureImpl implements DentalProcedureDetails {

	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH,
					CascadeType.DETACH
			})
	private DentalProcedureDetailsImpl details;

	public DentalProcedure() {

	}

	@Override
	public String getName() {
		return details.getName();
	}

	@Override
	public Double getCost() {
		return details.getCost();
	}

	@Override
	public Duration getDuration() {
		return details.getDuration();
	}

	public void setDetails(DentalProcedureDetailsImpl details) {
		this.details = details;
	}

}
