package com.wylegly.clinic.service.procedure.details;

import com.wylegly.clinic.dao.procedures.details.DentalProcedureBundleDetailsDao;
import com.wylegly.clinic.domain.procedures.details.DentalBundleDetails;
import com.wylegly.clinic.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DentalProcedureBundleDetailsServiceImpl
        extends GenericServiceImpl<DentalBundleDetails>
implements DentalProcedureBundleDetailsService{

    private DentalProcedureBundleDetailsDao bundleDetailsDao;

    @Autowired
    public DentalProcedureBundleDetailsServiceImpl(
            @Qualifier("dentalProcedureBundleDetailsDaoImpl") DentalProcedureBundleDetailsDao bundleDetailsDao
    ) {
        super(bundleDetailsDao);
        this.bundleDetailsDao = bundleDetailsDao;
    }
}
