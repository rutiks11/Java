package com.FruitBasket;

public class Apple extends Fruit
{	
	Apple(String name,String Color, Double Weight)
	{
		super(name,Color,Weight);
	}
	
	public void taste()
	{
		System.out.println("Taste is Sour");
	}
	
	public void Jam()
	{
		System.out.println("Jam is Ready ...");
	}
}
