package com.rohit.udemy;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.udemy.aopdemo.DemoConfig;
import com.rohit.udemy.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp 
{
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main( String[] args )
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = trafficFortuneService.getFortune(); 
		
		myLogger.info("\nMy fortune is :"+data);
		
		myLogger.info("Finished");
		
		context.close();

	}

}
