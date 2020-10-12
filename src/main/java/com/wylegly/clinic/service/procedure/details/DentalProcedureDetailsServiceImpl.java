package com.wylegly.clinic.service.procedure.details;

import com.wylegly.clinic.dao.procedures.details.DentalProcedureDetailsDaoImpl;
import com.wylegly.clinic.domain.procedures.details.DentalProcedureDetails;
import com.wylegly.clinic.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DentalProcedureDetailsServiceImpl extends GenericServiceImpl<DentalProcedureDetails>
implements DentalProcedureDetailsService{

    private DentalProcedureDetailsDaoImpl detailsDao;

    @Autowired
    public DentalProcedureDetailsServiceImpl(
            @Qualifier("dentalProcedureDetailsDaoImpl") DentalProcedureDetailsDaoImpl detailsDao
    ){
        super(detailsDao);
        this.detailsDao = detailsDao;
    }
}
