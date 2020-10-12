package com.wylegly.clinic.domain.procedures;

import com.wylegly.clinic.domain.procedures.details.DentalDetails;
import com.wylegly.clinic.domain.procedures.details.DentalProcedureDetails;

import javax.persistence.*;

@Entity(name = "DentalProcedure")
@Table(name = "dentalProcedure")
public class DentalProcedure extends MedicalProcedure
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// Many procedures may be described using one details entity
	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH,
					CascadeType.DETACH
			})
	@JoinColumn(name = "details_id")
	private DentalProcedureDetails details;

	public DentalProcedure() {

	}

	public DentalDetails getDetails() {
		return details;
	}

	public void setDetails(DentalProcedureDetails details) {
		this.details = details;
	}

}
