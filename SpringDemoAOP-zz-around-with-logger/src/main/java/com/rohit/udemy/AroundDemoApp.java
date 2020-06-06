package com.rohit.udemy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.udemy.aopdemo.DemoConfig;
import com.rohit.udemy.service.TrafficFortuneService;

public class AroundDemoApp 
{
	public static void main( String[] args )
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("Calling getFortune");
		
		String data = trafficFortuneService.getFortune(); 
		System.out.println("\nMy fortune is :"+data);
		context.close();

	}

}
