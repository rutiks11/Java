package com.pet.core;

<<<<<<< HEAD
import java.io.Serializable;

public class Pet implements Serializable {
=======

public class Pet {
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
	// petId, name, category, unitPrice, stocks
	private static int idgenerator;
	private int petid;
	private String name;
	private Category category;
	private double unitprice;
	private double stocks;
<<<<<<< HEAD

	static {
		idgenerator = 0;
	}

=======
	
	static 
	{
		idgenerator = 0;
	}
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
	public Pet() {
		super();
	}

<<<<<<< HEAD
	public Pet(String name, Category category, double unitprice, double stocks) {
=======
	public Pet( String name, Category category, double unitprice, double stocks) {
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
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
<<<<<<< HEAD
	public boolean equals(Object o) {
		Pet pet = (Pet) o;
		if (o instanceof Pet) {
			return this.petid==pet.getPetid();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return ((Integer)this.petid).hashCode() * 7;
	}
	
	@Override
=======
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
	public String toString() {
		return "Pet [petid=" + petid + ", name=" + name + ", category=" + category + ", unitprice=" + unitprice
				+ ", stocks=" + stocks + "]";
	}
<<<<<<< HEAD

=======
	
	
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
}
