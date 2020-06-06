package com.rohit.udemy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.rohit.udemy.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	@Before("com.rohit.udemy.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeaddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=========>>>> Executing @Before advice on method");
		
		//display the method signature
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: "+methodSignature);
		
		
		//display method arguments
		
		//get args
		Object[] args = joinPoint.getArgs();
		
		//loop thru args
		for(Object arg : args) {
			
			if(arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("Account Name : "+account.getName());
				System.out.println("Account Level : "+account.getLevel());
			}else {
				System.out.println(arg);
			}
		}
	}
	
	

	
}
