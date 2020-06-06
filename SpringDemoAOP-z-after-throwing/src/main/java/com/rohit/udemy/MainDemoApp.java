package com.rohit.udemy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohit.udemy.aopdemo.Account;
import com.rohit.udemy.aopdemo.DemoConfig;
import com.rohit.udemy.dao.AccountDAO;
import com.rohit.udemy.dao.MembershipDAO;

public class MainDemoApp 
{
    public static void main( String[] args )
    {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
    	
    	AccountDAO accountDAO = context.getBean(AccountDAO.class);
    	MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
    	
    	Account account = new Account();
    	account.setName("Rohit");
    	account.setLevel("Platinum");
    	
    	
    	accountDAO.addAccount(account,true);
    	accountDAO.doWork();
    	
    	accountDAO.setName("Rohit Manohar");
    	accountDAO.setServiceCode("Gold");
    	
    	String name = accountDAO.getName();
    	String serviceCode = accountDAO.getServiceCode();
    	
    	membershipDAO.addMemershipAccount();
    	membershipDAO.goToSleep();
    	
    	context.close();
    	
    }
}
