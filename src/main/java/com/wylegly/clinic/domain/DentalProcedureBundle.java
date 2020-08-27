//package com.wylegly.clinic.domain;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "details")
//public class DentalProcedureBundle extends MedicalProcedureImpl
//implements DentalProcedureBundleDetails {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@Column(name = "name")
//	private String bundleName;
//	
////	@OneToMany(fetch = FetchType.LAZY,
////			cascade = {
////					CascadeType.MERGE,
////					CascadeType.PERSIST,
////					CascadeType.REFRESH,
////					CascadeType.DETACH
////			})
////	private List<DentalProcedure> procedures;
//	
//	@Override
//	public String getName() {
//		return this.bundleName;
//	}
//
//	@Override
//	public Double getCost() {
////		Double totalCost = 0.0;
////		for (DentalProcedure dentalProcedure : procedures) {
////			totalCost += dentalProcedure.getCost();
////		}
////		
////		return totalCost;
//		return 0.0;
//	}
//
//	@Override
//	public Duration getDuration() {
////		Duration totalDuration = Duration.ZERO;
////		for (DentalProcedure dentalProcedure : procedures) {
////			totalDuration = totalDuration.plus(dentalProcedure.getDuration());
////		}
////		return totalDuration;
//		return null;
//	}
//
//	@Override
//	public List<String> getAllNames() {
////		List<String> procedureNames = new ArrayList<String>();
////		for(DentalProcedure procedure : procedures) {
////			procedureNames.add(procedure.getName());
////		}
////		
////		return procedureNames;
//		return null;
//	}
//	
//	public List<DentalProcedure> getProcedures() {
//		return null;
//	}
//
//	
//}
