package com.wylegly.clinic.dao.procedures.details;

import com.wylegly.clinic.dao.GenericDaoImpl;
import com.wylegly.clinic.domain.procedures.details.DentalDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DentalDetailsDaoImpl extends GenericDaoImpl<DentalDetails>
implements DentalDetailsDao {

    @Override
    public List<DentalDetails> getAll() {
        return currentSession().createQuery("SELECT d" +
                " FROM DentalDetails d", DentalDetails.class).getResultList();
    }
}
