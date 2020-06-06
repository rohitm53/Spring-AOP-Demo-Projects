package com.rohit.udemy.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.rohit.udemy.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		//print out the method we are advising
		String method  = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @Around  on method: "+method);
		
		//get begin timestamp
		long  startTime = System.currentTimeMillis();
		
		//now, lets execute the method 
		Object result = proceedingJoinPoint.proceed();
		
		//get end timestamp
		long endTime =  System.currentTimeMillis();
		
		//compute duration and display it
		long duration  = endTime-startTime;
		System.out.println("\n=====>>>> Duration : "+duration/1000.0 + "seconds");
		
		return result;
	}
	
	
	
	
	@After("execution(* com.rohit.udemy.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAccountsAdvice(JoinPoint joinPoint) {
		//print out which method we are advising on 
		String method  = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @After (finally) on method: "+method);
	}

	//add new advice for @AfterThrowing on the findAccount method
	@AfterThrowing(pointcut="execution(* com.rohit.udemy.dao.AccountDAO.findAccounts(..))",throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		
		//print out which method we are advising on 
		String method  = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterThrowing on method: "+method);
		
		//log the exception
		System.out.println("\n====>>>> The exception is :"+theExc);
	}
	
	//add new advice for @AfterReturning on the findAccount method
	@AfterReturning(pointcut="execution(* com.rohit.udemy.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturingFindAccountAdvice(JoinPoint  joinPoint , List<Account> result) {
		
		String method  = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: "+method);
		
		System.out.println("\n======>>> result is: "+result);
		convertAccountNameToUpperCase(result);
	}

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
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		
		for(Account account :result) {
			account.setName(account.getName().toUpperCase());
		}
	}

	
}
