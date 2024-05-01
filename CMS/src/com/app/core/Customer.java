package com.app.core;

import java.time.LocalDate;

// Create a core Class 
public class Customer
{
	// Tightly Coupled and declare members 
 	private int customerid;
	private String firstname;
	private String lastname;
	private String emailid;
	private String password;
	private double regAmount;
	private LocalDate dobDate;
	private ServicePlan plan;
	public static int idgenerator;
	
	static 
	{
		System.out.println("======== Customer Management App ========");
		idgenerator = 1001;
	}

	public Customer(String firstname, String lastname, String emailid, String password,
			double regAmount, LocalDate dobDate, ServicePlan plan) {
		super();
		
		this.customerid = idgenerator++;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.regAmount = regAmount;
		this.dobDate = dobDate;
		this.plan = plan;
	}

	public Customer(String emailid) {
		super();
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}


	@Override
	public String toString() 
	{
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", emailid=" + emailid + ", password=" + password + ", regAmount=" + regAmount + ", dobDate="
				+ dobDate + ", plan=" + plan + "]";
	}
	
	public void setPassword(String password) {
		this.password = password;
		System.out.println("Password Successfully Updated");
	}

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Customer)
		{
			Customer cust = (Customer)o;
			return this.emailid.equals(cust.emailid);
		}
		return false;
	}
	
}
