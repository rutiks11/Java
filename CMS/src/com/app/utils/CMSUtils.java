package com.app.utils;

import static com.app.core.ServicePlan.valueOf;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.CutAction;

import com.app.CMSException.CMSException;
import com.app.core.Customer;
import com.app.core.ServicePlan;

public class CMSUtils 
{
	public static Customer authenticationCustomer(String email,String password,List<Customer> customers) throws CMSException
	{
		// Passing the Object to the contains method
			
			Customer cust = new Customer(email);
			int index = customers.indexOf(cust);
		
			if(index==-1)
				throw new CMSException("User Does not Exists ");
		
			Customer user = customers.get(index);
			if((user.getPassword()).equals(password))
			{
				System.out.println("Successfully Login..!!!");
				return user;
			}
		
		
		throw new CMSException("Invalid Password");
	}
	
	public static void deletecustomer(Customer cust, List<Customer> list)
	{
		if(list.remove(cust))
			System.out.println("User Deleted...");
	}
	
	public static void removespecifiedplanbefdate(String plan,String date,List<Customer> list) throws CMSException
	{
		ServicePlan serviceplan = valueOf(plan.toUpperCase());
		LocalDate beforedate = LocalDate.parse(date);
		
		for(Customer customer : list)
		{
			if((customer.getPlan() == serviceplan) && (customer.getDobDate().isAfter(beforedate)))
				list.remove(list.get(list.indexOf(customer)));	
		}
		System.out.println("List Upodated");
	}
	
	public static List<Customer> populateCustomers() {
		Customer a1 = new Customer("Rutik", "Shinde",  "rutikshinde11@gmail.com" , "rts@11" , 1000.0d , LocalDate.parse("2000-10-11"), ServicePlan.SILVER);
		Customer a2 = new Customer("Shubham", "Sanas",  "shubh11@gmail.com" , "abhi@11" , 2000.0d , LocalDate.parse("2003-05-25"), ServicePlan.GOLD);
		Customer a3 = new Customer("Sameer", "Chikane",  "sameer22@gmail.com" , "sam@11" , 10000.0d , LocalDate.parse("2000-10-11"), ServicePlan.PLATINUM);
		Customer a4 = new Customer("Akshay", "Mahangade",  "aks11@gmail.com" , "aks@11" , 1000.0d , LocalDate.parse("2011-02-11"), ServicePlan.SILVER);
		Customer a5 = new Customer("Rahul", "Shoeran",  "rahul11@gmail.com" , "rshoe@11" , 2000.0d , LocalDate.parse("1990-10-11"), ServicePlan.GOLD);
		Customer a6 = new Customer("Prashant", "Khaware",  "prashant11@gmail.com" , "khaw@11" , 1000.0d , LocalDate.parse("1996-10-11"), ServicePlan.SILVER);
		Customer a7 = new Customer("Abhishek", "Pawar",  "abhi@gmail.com" , "abhi@11" , 10000.0d , LocalDate.parse("1992-10-11"), ServicePlan.PLATINUM);
		
		Customer[] accts = { a1, a2, a3, a4, a5, a6, a7 };
		List<Customer> list = new ArrayList<>();	// up casting
		for (Customer a : accts)
			list.add(a);
		
		return list;
	}
}
