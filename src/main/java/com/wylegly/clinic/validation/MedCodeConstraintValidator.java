package com.wylegly.clinic.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MedCodeConstraintValidator 
implements ConstraintValidator<MedCode, String>{

	private String codePrefix;
	
	@Override
	public void initialize(MedCode medCode) {
		codePrefix = medCode.value();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null ) return false;
		return value.startsWith(codePrefix);
	}

}
