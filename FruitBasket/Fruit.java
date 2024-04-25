package com.FruitBasket;

public abstract class Fruit 
{

	private String name;
	private String Color;
	private Double Weight;
	private boolean fresh;
	
	public Fruit(String name, String Color,Double Weight)
	{
		this.name = name;
		this.Color = Color;
		this.Weight = Weight;
		this.fresh = true;
	}
	
	@Override
	public String toString()
	{
		return "Name : " + this.name + "\nColor : " + this.Color + "Weight : "  + this.Weight;
	}
	
	public abstract void taste();
	
}
