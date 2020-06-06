package com.rohit.udemy.dao;

import org.springframework.stereotype.Component;

import com.rohit.udemy.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + " : DOING MY DB WORK : ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
	
}