package com.rohit.udemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	@Pointcut("execution(* com.rohit.udemy.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// pointcut for getter methods
	@Pointcut("execution(* com.rohit.udemy.dao.*.get*(..))")
	private void getter() {}
	
	
	//pointcut for setter methods
	@Pointcut("execution(* com.rohit.udemy.dao.*.set*(..))")
	private void setter() {}
	
	
	//create pointcut : including package... exlude getter/setter 
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeaddAccountAdvice() {
		System.out.println("\n=========>>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n========>>>> Performing API Analytics");
	}
	
}
