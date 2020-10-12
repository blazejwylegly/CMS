package com.wylegly.clinic.controller;

import com.wylegly.clinic.service.procedure.details.*;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServicesController {

    private final Logger logger = Logger.getLogger(this.getClass());
    // Service for managing all types of details
    @Autowired
    private DentalDetailsService detailsService;

    // Managing bundles details
    @Autowired
    private DentalProcedureBundleDetailsService dentalBundlesService;

    // Managing single procedure details
    @Autowired
    private DentalProcedureDetailsService dentalDetailsService;

    @GetMapping("/pricelist")
    public String showPriceListForm(Model model) {

        model.addAttribute("availableServices", dentalDetailsService.getAll());
        model.addAttribute("availableBundles", dentalBundlesService.getAll());
        return "services-pricelist";
    }
}
