package com.wylegly.clinic.domain.procedures.details;

import com.wylegly.clinic.domain.DurationToLongConverter;
import com.wylegly.clinic.domain.procedures.DentalProcedure;

import java.time.Duration;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "dentalProcedureDetails")
public class DentalProcedureDetails extends DentalDetails {

	@Transient
	private static final String durationPattern = "%d:%02d:%02d";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "cost")
	private Double cost;

	@Column(name = "duration")
	@Convert(converter = DurationToLongConverter.class)
	private Duration duration;

	@OneToMany(
			mappedBy = "details"
	)
	private List<DentalProcedure> procedures;

	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.MERGE,
					CascadeType.DETACH,
					CascadeType.PERSIST,
					CascadeType.REFRESH
			}
	)
	@JoinTable(
			name = "bundles_details",
			joinColumns = @JoinColumn(name = "details_id"),
			inverseJoinColumns = @JoinColumn(name = "bundle_id")
	)
	private List<DentalBundleDetails> bundles;
	
	public DentalProcedureDetails() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Duration getDuration() {
		 return duration;
	 }

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getFormattedDuration() {

		long seconds = duration.getSeconds();

		return String.format(
				durationPattern,
				seconds / 3600,
				(seconds % 3600)/60,
				seconds % 60
		);

	}
}
