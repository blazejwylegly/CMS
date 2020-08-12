package com.wylegly.clinic.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Before("com.wylegly.clinic.aspect.PointcutDeclarations.forApplicationFlow()")
	public void before(JoinPoint joinPoint) {
		logger.info("\n>>> " + joinPoint.getSignature().toShortString() + " called\n"
				+ ">>> Parameteres passed: " + joinPoint.getArgs());
	
	}
}
