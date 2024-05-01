package com.app.core;

public enum ServicePlan 
{
//	SILVER : 1000 
//	GOLD : 2000
//	DIAMOND : 5000
//	PLATINUM : 10000
	
	SILVER(1000) , GOLD(2000) , DIAMOND(5000) , PLATINUM(10000);
	
	private double planecost;
	
	// Create a constructor to set the Values to enum Constant
	private ServicePlan(double planCost)
	{
		this.planecost = planCost;
	}
	
	// Getter
	public double getPlanCost()
	{
		return planecost;
	}
}
