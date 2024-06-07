package com.pet.core;


public class Pet {
	// petId, name, category, unitPrice, stocks
	private static int idgenerator;
	private int petid;
	private String name;
	private Category category;
	private double unitprice;
	private double stocks;
	
	static 
	{
		idgenerator = 0;
	}
	public Pet() {
		super();
	}

	public Pet( String name, Category category, double unitprice, double stocks) {
		super();
		this.petid = ++idgenerator;
		this.name = name;
		this.category = category;
		this.unitprice = unitprice;
		this.stocks = stocks;
	}

	public int getPetid() {
		return petid;
	}

	public void setPetid(int petid) {
		this.petid = petid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public double getStocks() {
		return stocks;
	}

	public void setStocks(double stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Pet [petid=" + petid + ", name=" + name + ", category=" + category + ", unitprice=" + unitprice
				+ ", stocks=" + stocks + "]";
	}
	
	
}
