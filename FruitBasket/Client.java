package com.FruitBasket;

import java.util.*;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		Fruit fruitbasket[] = new Fruit[5];
		
		int ichoice = 0;
		
		while(true)
		{
			System.out.println("Enter Choice : \n1.Add Fruit\n2.View Basket\n3.Exit");
			ichoice = sc.nextInt();
			
			switch(ichoice)
			{
				case 1:
					UtilityFruit.acceptFruit(fruitbasket);
					break;
				
				case 2:
					UtilityFruit.Display(fruitbasket);
					break;
				case 3:
					return;
			}
		}
	}

}
