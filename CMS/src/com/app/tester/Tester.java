package com.app.tester;


import static com.app.utils.CMSValidation.validateCustomerInputs;
import static com.app.utils.CMSValidation.validatepass;
import static com.app.utils.CMSUtils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

import com.app.core.Customer;
import com.app.customsorting.CustomSorting;


public class Tester 
{	
	static 
	{
		System.out.println("======== Customer Management App ========");
	}
	
	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in))
		{
			boolean exit = false;
			
			ArrayList<Customer> customers = new  ArrayList<>(); 
			customers.addAll(populateCustomers());
			
			while(!exit)
			{
				System.out.println("Options : \n 1. Customer Sign Up \n 2. SignIn \n 3. Display all \n 4. Update Password \n 5. Delete User \n 6. Email Sort \n 7. DOB and Lastname Sort \n 8. Delete Specified Plan n Before DOBdate \n 0. Exit");
				System.out.println("Select Option");
				try 
				{
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Details : ");
						System.out.println("1.firstname \n2.lastname \n3.emailid \n4.password \n5.regAmount \n6.dobDate \n7.Plan");
						Customer newcust = validateCustomerInputs(sc.next(), sc.next(), sc.next(), sc.next(),sc.nextDouble(),sc.next(),sc.next(), customers);
						customers.add(newcust);
						System.out.println("Registration Successfull");
						break;
					
					case 2:
						System.out.println("Enter Email and Password");
						Customer user =authenticationCustomer(sc.next(),sc.next(),customers);
						System.out.println(user);
						break;
					
					case 3:
						System.out.println("Customer Details ");
							for(Customer cust: customers)
							{
								System.out.println(cust);
							}
						break;
					
					case 4:
						System.out.println("Enter Email and Password");
						Customer user1 =authenticationCustomer(sc.next(),sc.next(),customers);
						System.out.println("Enter Password ");
						String pass1 = sc.next();
						validatepass(pass1);
						user1.setPassword(pass1);
						break;
						
					case 5:
						System.out.println("Enter Email and Password");
						Customer user2 =authenticationCustomer(sc.next(),sc.next(),customers);
						deletecustomer(user2,customers);
						break;
						
					case 6:
						System.out.println("Sorted List...");
						Collections.sort(customers);
						break;
					
					case 7:
						System.out.println("Sorted with DOB and LastName");
						Collections.sort(customers, new CustomSorting());
						break;
					
					case 8:
						System.out.println("Enter Plan and Remove - After Date");
						removespecifiedplanbefdate(sc.next(),sc.next(),customers);
						break;
						
					case 0:
						System.out.println("Thank You For using App...");
						return;
					}
				}catch(PatternSyntaxException p)
				{
					System.out.println("Email Invalid");
				}
				catch(IllegalArgumentException iarg)
				{
					System.out.println("Invalid Plan");
				}
				catch (Exception e) {
					// To Flush Scanner
					sc.nextLine();
					System.out.println(e);
				}
			}
		}
	}
}
