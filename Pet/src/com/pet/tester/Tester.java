package com.pet.tester;

import static com.pet.utils.UserUtils.authenticateUser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.pet.core.Pet;
import com.pet.core.Role;
import com.pet.core.User;
import static com.pet.utils.PetUtils.popopulatePetMap;

public class Tester {
	public static void main(String args[]) {
		
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<Integer, Pet> petlist = new HashMap<Integer, Pet>(popopulatePetMap());
			
			try {
				while (!exit) {
					System.out.println("=======  Pet Shop  =======");
					System.out.println("SingIn");
					System.out.println("Enter username");
					String uname = sc.next();
					String password = sc.next();
					User user = authenticateUser(uname,password);
					
					if(user.getRole() == Role.ADMIN)
					{
						boolean adminflag = false;
						System.out.println("Enter Choice");
						
						while(!adminflag)
						{	
							System.out.println("Enter Choice");
							System.out.println("1.Add Pet\n2.Update Pet details\n0.Logout");
							switch(sc.nextInt()) {
							case 1:
								//String name, Category category, double unitprice, double stocks
								//addNewPet()
								break;

							default:
								break;
							}
						}
					}
					else if(user.getRole() == Role.CUSTOMER)
					{
						
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				sc.nextLine();
			}
		}
	}
}
