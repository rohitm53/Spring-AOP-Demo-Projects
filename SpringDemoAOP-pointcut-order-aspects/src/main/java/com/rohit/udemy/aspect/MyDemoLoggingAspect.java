package com.rohit.udemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	@Before("com.rohit.udemy.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeaddAccountAdvice() {
		System.out.println("\n=========>>>> Executing @Before advice on method");
	}
	
	

	
}
