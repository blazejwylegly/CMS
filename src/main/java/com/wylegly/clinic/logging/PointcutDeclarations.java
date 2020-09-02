 package com.wylegly.clinic.logging;

 import org.aspectj.lang.annotation.Aspect;
 import org.aspectj.lang.annotation.Pointcut;

 @Aspect
 public final class PointcutDeclarations {
	
 	@Pointcut("execution(* com.wylegly.clinic.controller.*.*(..))")
 	public void forControllerPackage() {}
	
 	@Pointcut("execution(* com.wylegly.clinic.service.*.*(..))")
 	public void forServicePackage() {}
	
 	@Pointcut("execution(* com.wylegly.clinic.dao.*.*(..))")
 	public void forDaoPackage() {}
	
 	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
 	public void forApplicationFlow() {}
 }
