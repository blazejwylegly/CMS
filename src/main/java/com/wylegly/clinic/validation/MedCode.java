package com.wylegly.clinic.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MedCodeConstraintValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface MedCode {

	// define default medical doce
	public String value() default "MED";
	
	// define default error message
	public String message() default "Must start with MED";
	
	// define default groups
	public Class<?>[] groups() default {};
	
	// define default payloads - payloads provide custom detauils about validation failure
	public Class<? extends Payload>[] payload() default {};
	
}
