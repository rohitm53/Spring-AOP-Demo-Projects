package com.rohit.udemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	@Before("execution(* com.rohit.udemy.dao.*.	(..))")
	public void beforeaddAccountAdvice() {
		
		System.out.println("\n=========>>>> Executing @Before advice on method");
		
	}
	
}
