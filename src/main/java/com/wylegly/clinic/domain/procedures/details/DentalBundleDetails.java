package com.wylegly.clinic.domain.procedures.details;

import com.wylegly.clinic.domain.DurationToLongConverter;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "dentalProcedureBundleDetails")
public class DentalBundleDetails
        extends DentalDetails {

    @Column(name = "discount")
    private int discount;

    @Transient
    private Double cost;

    @Transient
    private Double moneySaved;

    @Transient
    private Duration duration;


    // TODO: Think about changing this method to db column
    @PostLoad
    private void calculateValues() {

        cost = 0.0;
        duration = Duration.ZERO;

        for (DentalProcedureDetails proceduresDetail : proceduresDetails) {
            cost += proceduresDetail.getCost();
            duration = duration.plus(proceduresDetail.getDuration());
        }

        if(discount > 0){
            moneySaved = cost * (discount / 100.0);
            cost -= moneySaved;
        }
    }

    // Mapping describes which services belong to given bundle
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
            joinColumns = @JoinColumn(name = "bundle_id"),
            inverseJoinColumns = @JoinColumn(name = "details_id")
    )
    private List<DentalProcedureDetails> proceduresDetails;

    public DentalBundleDetails() {

    }

    @Override
    public Double getCost() {


        return cost;
    }

    @Override
    public Duration getDuration() {

        return duration;

    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount){
        this.discount = discount;
    }

    public Double getMoneySaved() {
        return moneySaved;
    }

    public List<DentalProcedureDetails> getProceduresDetails() {
        return proceduresDetails;
    }
}
