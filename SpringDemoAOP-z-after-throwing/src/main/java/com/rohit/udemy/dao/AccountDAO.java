package com.rohit.udemy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rohit.udemy.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + " : DOING MY DB WORK : ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(boolean flag){
		
		// Stimulating exception
		if(flag) {
			throw new RuntimeException("No soup for you");
		}
		List<Account> listAccounts = new ArrayList<Account>();
		
		Account account1 = new Account("Rohit", "GOLD");
		Account account2 = new Account("Anirudra", "Platinum");
		Account account3 = new Account("Vinit", "Silver");
		
		listAccounts.add(account1);
		listAccounts.add(account2);
		listAccounts.add(account3);
		
		return listAccounts;
	}

}
