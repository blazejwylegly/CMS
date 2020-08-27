package com.wylegly.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/procedures")
public class ProcedureController {

  @GetMapping("/overview")
  public String showOverviewForm() {
    return "procedure-add";
  }
}