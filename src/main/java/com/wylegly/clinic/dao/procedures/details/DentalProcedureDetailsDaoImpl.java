package com.wylegly.clinic.dao.procedures.details;

import com.wylegly.clinic.dao.GenericDaoImpl;
import com.wylegly.clinic.domain.procedures.details.DentalProcedureDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DentalProcedureDetailsDaoImpl extends GenericDaoImpl<DentalProcedureDetails>
implements DentalProcedureDetailsDao{

    @Override
    public List<DentalProcedureDetails> getAll() {
        return currentSession().createQuery("select procDetails " +
                        "from DentalProcedureDetails procDetails "
                        ,DentalProcedureDetails.class
                )
                .getResultList();
    }
}
