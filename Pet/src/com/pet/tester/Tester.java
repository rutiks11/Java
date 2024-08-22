package com.pet.tester;

<<<<<<< HEAD
import static com.pet.utils.PetUtils.addNewPet;
import static com.pet.utils.PetUtils.*;
import static com.pet.utils.PetUtils.popopulatePetMap;
import static com.pet.utils.UserUtils.*;
import static com.pet.utils.OrderUtils.*;

import java.util.ArrayList;
=======
import static com.pet.utils.UserUtils.authenticateUser;

>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

<<<<<<< HEAD
import com.pet.core.Order;
import com.pet.core.Pet;
import com.pet.core.Role;
import com.pet.core.Status;
import com.pet.core.User;

public class Tester {
	public static void main(String args[]) {

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;

			Map<Integer, Pet> petMap = new HashMap<Integer, Pet>(popopulatePetMap());
			ArrayList<User> userList = new ArrayList<User>(populateUserList());
			Map<Integer, Order> orderMap = new HashMap<Integer, Order>(populateorderMap());

			while (!exit) {
				try {
					System.out.println("=======  Pet Shop  =======");
					System.out.println("----- SingIn -----");
					System.out.println("Enter username");
					String uname = sc.next();
					System.out.println("Enter Password");
					String password = sc.next();
					User user = authenticateUser(uname, password, userList);

					if (user.getRole() == Role.ADMIN) {
						boolean adminflag = false;

						while (!adminflag) {
							System.out.println("Enter Choice");
							System.out.println(
									"1.Add Pet\n2.Display Pet details\n3.Update Pet Details\n4.Update Status Id \n5. Display Orders \n6.Check Status  \n7.View Order History \n8.Logout \n0.Close App");
							switch (sc.nextInt()) {
							case 1:
								System.out.println();
								// String name, Category category, double unitprice, double stocks
								System.out.println("Enter Name, Category , per Unit price and stock");
								boolean bRet = addNewPet(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt(), petMap);
								if (bRet) {
									System.out.println("Pet Added Successfully...!!!");
								} else {
									System.out.println("Sorry Pet cound't added");
								}
								break;

							case 2:
								System.out.println("Display All Pets ");
								petMap.values().forEach(s -> System.out.println(s));
								break;

							case 3:
								System.out.println("Update Pet Details");
								System.out.println("Enter Id and Updated values of All Pet");
								String retString = updatePet(sc.nextInt(), sc.nextDouble(), sc.nextInt(), petMap);
								System.out.println(retString);
								break;

							case 4:
								System.out.println("Enter Id and Status");
								String result = updateOrderStatus(sc.nextInt(), sc.next(), orderMap);
								System.out.println(result);
								break;

							case 5:
								System.out.println("Display Orders and Pet Details");
								orderMap.values().forEach(s -> System.out.println(s));
								readDataIndeser("PetDetails.ser");
								break;

							case 6:
								System.out.println("Enter Id of the order");
								Status status = chkStatus(sc.nextInt(), orderMap);
								System.out.println("Status of Order " + status);
								break;

							case 8:
								String ret = storeData("OrderDetails.txt", orderMap);
								System.out.println(ret);
								adminflag = true;
								break;

							case 7:
								System.out.println("Order History");
								readStoredData("OrderDetails.txt");
								writeDataInSer("PetDetails.ser", petMap);
								break;

							case 9:
								petMap.values().removeIf(s -> s.getName().equals("lily"));
								break;

							case 0:
								String ret1 = storeData("OrderDetails.txt", orderMap);
								System.out.println(ret1);
								adminflag = true;
								exit = true;
								System.out.println("Thank you!!!");
								break;
							}
						}
					} else if (user.getRole() == Role.CUSTOMER) {
						boolean userflag = false;
						while (!userflag) {
							try {
								System.out.println("Enter Choice :\n1.Display Pets \n2.Order Pet\n0.Close App");
								switch (sc.nextInt()) {
								case 1:
									System.out.println("Display All Pets ");
									petMap.values().forEach(s -> System.out.println(s));
									break;

								case 2:
									System.out.println("Select Pet Id");
									petMap.values().forEach(s -> System.out.println(s));
									System.out.println("Enter Pet iD for order Pet and Deposit Amount :: ");
									String result = orderPet(sc.nextInt(), sc.nextInt(), sc.nextDouble(), petMap,
											orderMap);
									System.out.println(result);
									break;

								case 3:
									userflag = true;
									System.out.println("Thank You!!");
									break;

								case 0:
									String ret1 = storeData("OrderDetails.txt", orderMap);
									System.out.println(ret1);
									userflag = true;
									exit = true;
									System.out.println("Thank you!!!");
									break;
								}
							} catch (Exception e) {
								System.out.println(e);
								e.printStackTrace();
								sc.nextLine();
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					sc.nextLine();
				}
=======
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
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
			}
		}
	}
}
