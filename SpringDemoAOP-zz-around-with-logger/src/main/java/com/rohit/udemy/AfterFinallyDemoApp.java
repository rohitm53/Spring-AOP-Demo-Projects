package com.rohit.udemy;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.udemy.aopdemo.Account;
import com.rohit.udemy.aopdemo.DemoConfig;
import com.rohit.udemy.dao.AccountDAO;
import com.rohit.udemy.dao.MembershipDAO;

public class AfterFinallyDemoApp 
{
	public static void main( String[] args )
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean(AccountDAO.class);

		List<Account> listAccounts = null;
		try {
			boolean flag = false;
			listAccounts=accountDAO.findAccounts(flag);
		}catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception : "+e);
		}

		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("---");
		System.out.println(listAccounts);
		System.out.println("\n");

		context.close();

	}

}
