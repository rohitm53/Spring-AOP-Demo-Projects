package com.rohit.udemy;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.udemy.aopdemo.DemoConfig;
import com.rohit.udemy.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp 
{
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main( String[] args )
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire); 
		
		myLogger.info("\nMy fortune is : "+data);
		
		myLogger.info("Finished");
		
		context.close();

	}

}
