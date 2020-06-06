package com.rohit.udemy;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.udemy.aopdemo.Account;
import com.rohit.udemy.aopdemo.DemoConfig;
import com.rohit.udemy.dao.AccountDAO;
import com.rohit.udemy.dao.MembershipDAO;

public class AfterReturningDemoApp 
{
    public static void main( String[] args )
    {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
    	
    	AccountDAO accountDAO = context.getBean(AccountDAO.class);
    	
    	List<Account> listAccounts = accountDAO.findAccounts();
    	
    	System.out.println("\n\nMain Program: AfterReturninDemoApp");
    	System.out.println("---");
    	System.out.println(listAccounts);
    	System.out.println("\n");
    	
    	context.close();
    	
    }
}
