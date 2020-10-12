package com.wylegly.clinic.domain.procedures;

import com.wylegly.clinic.domain.procedures.details.DentalBundleDetails;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dentalProcedureBundle")
public class DentalProcedureBundle extends MedicalProcedure {

    // Procedures planned on behalf of
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }
    )
    private List<DentalProcedure> procedures;

    @ManyToOne
    private DentalBundleDetails bundleDetails;

    

    
}
