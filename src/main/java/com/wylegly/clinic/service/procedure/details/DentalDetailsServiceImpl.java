package com.wylegly.clinic.service.procedure.details;

import com.wylegly.clinic.dao.procedures.details.DentalDetailsDao;
import com.wylegly.clinic.domain.procedures.details.DentalDetails;
import com.wylegly.clinic.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DentalDetailsServiceImpl extends GenericServiceImpl<DentalDetails>
implements DentalDetailsService {

    private DentalDetailsDao dentalDetailsDao;

    @Autowired
    public DentalDetailsServiceImpl(
            @Qualifier("dentalDetailsDaoImpl") DentalDetailsDao dentalDetailsDao
    ) {
       super(dentalDetailsDao);
       this.dentalDetailsDao = dentalDetailsDao;
    }
}
