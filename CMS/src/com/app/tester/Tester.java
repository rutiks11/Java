package com.app.tester;

import static com.app.utils.CMSValidation.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

import javax.naming.AuthenticationException;

import com.app.core.Customer;

public class Tester {
	
	static 
	{
		System.out.println("======== Customer Management App ========");
	}
	
	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in))
		{
			boolean exit = false;
			
			ArrayList<Customer> customers = new  ArrayList<>(); 
			
			while(!exit)
			{
				System.out.println("Options : \n 1. Customer Sign Up \n 2. SignIn \n 3. Display all \n 0. Exit");
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
						Customer user =authorisation(sc.next(),sc.next(),customers);
						System.out.println("Enter Password ");
						String pass = sc.next();
						validatepass(pass);
						user.setPassword(pass);
						break;
						
					case 3:
						System.out.println("Customer Details ");
							for(Customer cust: customers)
							{
								System.out.println(cust);
							}
						break;
						
					default:
						break;
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
