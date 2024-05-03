package com.app.utils;

import static com.app.core.ServicePlan.valueOf;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import com.app.CMSException.CMSException;
import com.app.core.Customer;
import com.app.core.ServicePlan;

public class CMSValidation {
	
	public static String regexPattern;
	public static String regexPatternPass;
	
	static
	{
		regexPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.(com|net|org)$";
		regexPatternPass = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
	}
	
	public static void parseAndvalidateDob(String dobDate)throws CMSException
	{
		LocalDate date = LocalDate.parse(dobDate);
		if(18 > Period.between(date,LocalDate.now()).getYears())
			throw new CMSException("Under Age....");
	}
	
	// Method to check the validation of the email
	public static void validatemail(String emailString) throws CMSException
	{	
		if(!emailString.matches(regexPattern))
			throw new CMSException("Invalid Email...Please enter Correct Email");
	}
	
	public static void validatepass(String password) throws CMSException
	{
		if(!password.matches(regexPatternPass))
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
		parseAndvalidateDob(dobDate);
		ServicePlan servicePlan = parsenValidateServicePlanCharages(plan,regAmount);
		LocalDate dob = LocalDate.parse(dobDate);
		
		return new Customer(firstname, lastname, emailid, password, regAmount, dob, servicePlan);
	}

}