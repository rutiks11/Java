package com.FruitBasket;

import java.util.*;

public class UtilityFruit 
{
	static int icnt = 0;
	
	public static void acceptFruit(Fruit farr[])
	{
		Scanner sc = new Scanner(System.in);
		
		int choice =0;
		String name = null;
		String Color = null;
		Double Weight = 0.0;
		
		
		while(true)
		{
			System.out.println("Enter Choice :: \n1.Add Mango\n2.Add Orange\n3.Apple\n4.Done");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter Name : ");
					name = sc.next();

					System.out.println("Enter Color : ");
					Color = sc.next();
					
					System.out.println("Enter Weight : ");
					Weight = sc.nextDouble();

					
					farr[icnt] = new Mango(name,Color,Weight);
					icnt++;
					
					System.out.println("Mango Added");
					
					break;
					
					
				case 2:
					System.out.println("Enter Name : ");
					name = sc.next();

					System.out.println("Enter Color : ");
					Color = sc.next();
					
					System.out.println("Enter Weight : ");
					Weight = sc.nextDouble();

					
					farr[icnt] = new Orange(name,Color,Weight);
					icnt++;
					
					System.out.println("Orange Added");
					
					break;
					
				case 3:
					System.out.println("Enter Name : ");
					name = sc.next();

					System.out.println("Enter Color : ");
					Color = sc.next();
					
					System.out.println("Enter Weight : ");
					Weight = sc.nextDouble();

					
					farr[icnt] = new Apple(name,Color,Weight);
					icnt++;
					
					System.out.println("Apple Added");
					
					break;
				
				case 4:
					return;	
			}
			
		}
	}
	
	
	public static void Display(Fruit fruitbasket[])
	{
		for(int i =0; i < icnt ; i++)
		{
			System.out.println(fruitbasket[i]);
			
			
			if(fruitbasket[i] instanceof Mango)
			{
				((Mango)fruitbasket[i]).Pulp();
				((Mango)fruitbasket[i]).taste();
				System.out.println("");
				
			}
			else if(fruitbasket[i] instanceof Apple)
			{
				((Apple)fruitbasket[i]).Jam();
				((Apple)fruitbasket[i]).taste();
				System.out.println("");
			}
			else if(fruitbasket[i] instanceof Orange)
			{
				((Orange)fruitbasket[i]).Juice();
				((Orange)fruitbasket[i]).taste();
				System.out.println("");
			}
		}
	}
}
