package com.FruitBasket;

public class Orange extends Fruit
{
	Orange(String name,String color,double weight)
	{
		super(name,color,weight);
	}
	
	public void taste()
	{
		System.out.println("Sweet-Sour");
	}
	
	public void Juice()
	{
		System.out.println("Juice is Ready");
	}
}
