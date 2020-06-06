package com.rohit.udemy.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMemershipAccount() {

		System.out.println(getClass() + " : DOING MY DB WORK : ADDING MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public void  goToSleep() {
		System.out.println(getClass() + ": I'm going to sleep  now...");
	}

}
