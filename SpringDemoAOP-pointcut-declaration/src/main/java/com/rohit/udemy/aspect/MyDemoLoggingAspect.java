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
	
	
	@Before("forDaoPackage()")
	public void beforeaddAccountAdvice() {
		System.out.println("\n=========>>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n========>>>> Performing API Analytics");
	}
	
}
