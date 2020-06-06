package com.rohit.udemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	
	@Pointcut("execution(* com.rohit.udemy.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// pointcut for getter methods
	@Pointcut("execution(* com.rohit.udemy.dao.*.get*(..))")
	public void getter() {}
	
	
	//pointcut for setter methods
	@Pointcut("execution(* com.rohit.udemy.dao.*.set*(..))")
	public void setter() {}
	
	
	//create pointcut : including package... exlude getter/setter 
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
	
}
