package com.rohit.udemy.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		//stimulate delay
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//return fortune
		return "Exepect heavy traffic this mornning";
		
	}

	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		return getFortune();
	}
	
}
