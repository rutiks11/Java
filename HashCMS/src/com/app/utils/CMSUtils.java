package com.app.utils;

import static com.app.core.ServicePlan.valueOf;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.CutAction;

import com.app.CMSException.CMSException;
import com.app.core.Customer;
import com.app.core.ServicePlan;

public class CMSUtils {

	public static Customer authenticationCustomer(String email, String password, Map<String, Customer> customers)
			throws CMSException {
		// Passing the Object to the contains method
		Customer cust = customers.get(email);
		if (cust.getPassword() == password) {
			System.out.println("User Successfully Logged In");
			return cust;
		}
		throw new CMSException("Invalid Password");
	}

	public static void deletecustomer(Customer cust,Map<String, Customer> map) {
		map.remove(cust.getEmailid());
		System.out.println("User Deleted...");
	}

	public static void removespecifiedplanbefdate(String plan, String date, Map<String,Customer> map) throws CMSException {
		ServicePlan serviceplan = valueOf(plan.toUpperCase());
		LocalDate beforedate = LocalDate.parse(date);	
		
		 Iterator<Customer> iterator = map.values().iterator();
		    while (iterator.hasNext()) {
		        Customer cust = iterator.next();
		        if (cust.getPlan() == serviceplan && cust.getDobDate().isAfter(beforedate)) {
		            iterator.remove(); // Remove safely using iterator's remove() method
		        }
		    }
		    System.out.println("List Updated");
	}

	public static HashMap<String, Customer> populateCustomers() {
		Customer a1 = new Customer("Rutik", "Shinde", "rutikshinde11@gmail.com", "rts@11", 1000.0d,
				LocalDate.parse("2000-10-11"), ServicePlan.SILVER);
		Customer a2 = new Customer("Shubham", "Sanas", "shubh11@gmail.com", "abhi@11", 2000.0d,
				LocalDate.parse("2003-05-25"), ServicePlan.GOLD);
		Customer a3 = new Customer("Sameer", "Chikane", "sameer22@gmail.com", "sam@11", 10000.0d,
				LocalDate.parse("2000-10-11"), ServicePlan.PLATINUM);
		Customer a4 = new Customer("Akshay", "Mahangade", "aks11@gmail.com", "aks@11", 1000.0d,
				LocalDate.parse("2011-02-11"), ServicePlan.SILVER);
		Customer a5 = new Customer("Rahul", "Shoeran", "rahul11@gmail.com", "rshoe@11", 2000.0d,
				LocalDate.parse("1990-10-11"), ServicePlan.GOLD);
		Customer a6 = new Customer("Prashant", "Khaware", "prashant11@gmail.com", "khaw@11", 1000.0d,
				LocalDate.parse("1996-10-11"), ServicePlan.SILVER);
		Customer a7 = new Customer("Abhishek", "Pawar", "abhi@gmail.com", "abhi@11", 10000.0d,
				LocalDate.parse("1992-10-11"), ServicePlan.PLATINUM);
		Customer a8 = new Customer("Rushi", "Sale", "rutiks@gmail.com", "rts@11", 1000.0d,
				LocalDate.parse("2000-10-12"), ServicePlan.SILVER);

		Customer[] accts = { a1, a2, a3, a4, a5, a6, a7, a8 };
		HashMap<String, Customer> map = new HashMap<>(); // up casting
		for (Customer cust : accts)
			map.put(cust.getEmailid(), cust);

		return map;
	}
}
