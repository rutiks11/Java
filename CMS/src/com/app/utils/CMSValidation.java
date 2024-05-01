package com.app.utils;

import java.io.ObjectInputStream.GetField;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import static com.app.core.ServicePlan.*;

import com.app.CMSException.CMSException;
import com.app.core.Customer;
import com.app.core.ServicePlan;

public class CMSValidation {
	
	// Method to Sign In
	public static Customer authorisation(String email,String password,List<Customer> customers) throws CMSException
	{
		Customer cust = new Customer(email);
		if(!customers.contains(cust))
		{
			throw new CMSException("Account Does not Exists");		
		}
		else 
		{
			int index = customers.indexOf(cust);
			Customer user = customers.get(index);
			if((user.getPassword()).equals(password))
			{
				System.out.println("Successfully Login..!!!");
				return user;
			}
		}
		
		throw new CMSException("Invalid Password");
	}
	
	// Method to check the validation of the email
	public static void validatemail(String emailString) throws CMSException
	{
		String regexPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.(com|net|org)$";
		
		if(!patternMatches(emailString,regexPattern))
			throw new CMSException("Invalid Email...Please enter Correct Email");
	}
	
	public static boolean patternMatches(String email, String regexString) 
	{
		return Pattern.compile(regexString).matcher(email).matches();
	}
	
	public static void validatepass(String password) throws CMSException
	{
		String regexPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";

		if(!patternMatches(password,regexPattern))
			throw new CMSException("Password must contains A-Z a-z 0-9...");
	}
	
	// Method to Check for Duplicates 
	public static void ChkdupEmail(String email, List <Customer> list) throws CMSException
	{
		// email wrap
		Customer customer = new Customer(email);
		
		/*for(Customer cust : list)
		{
			if(customer.equals(cust))
			{
				throw new CMSException("User Already Exists...");
			}
		}*/
		
		if(list.contains(customer))
			throw new CMSException("Duplicate Email ..");
		}

	// Method to parse and validate the service plan and Exception
	public static ServicePlan parsenValidateServicePlanCharages(String serviceplan,Double regamount) throws CMSException
	{
		// Parse the input 
		ServicePlan plan = valueOf(serviceplan.toUpperCase());
		
		if(plan.getPlanCost() == regamount)
			return plan;
		
		throw new CMSException("Reg Amount Does'nt match with choosen Plan");
	}
	
	public static Customer validateCustomerInputs(String firstname, String lastname, String emailid, String password,
			double regAmount, String dobDate,String plan,List<Customer> list) throws CMSException
	{
		// Check for Duplicates
		ChkdupEmail(emailid,list);
		// Check service plan with register amount
		validatemail(emailid);
		validatepass(password);
		ServicePlan servicePlan = parsenValidateServicePlanCharages(plan,regAmount);
		LocalDate dob = LocalDate.parse(dobDate);
		
		return new Customer(firstname, lastname, emailid, password, regAmount, dob, servicePlan);
	}
	

}
