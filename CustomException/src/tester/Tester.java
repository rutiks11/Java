package tester;

import java.util.Scanner;

import utils.VehicleUtility;

import vehiclemain.Vehicle;

public class Tester {

	public static void main(String[] args) {
		Vehicle varr[] = new Vehicle[10];
		int choice = 0;

		System.out.println("\n\n========== WELCOME TO REVEH VEHICLE ==========\n\n");
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				System.out.println("\nEnter Choice :: \n\n1.AcceptVehicle\n2.DisplayVehicle\n3.Drive Vehicle\n4.Exit");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					try {
						VehicleUtility.acceptVehicle(varr);
					} catch (IllegalArgumentException i) {
						System.out.println("Color Not Available..");
					} catch (Exception e) {
						System.out.println("Message :: " + e.getMessage());
					}
					break;
				case 2:
					VehicleUtility.displayVehicle(varr);
					break;
				case 3:
					try {
						VehicleUtility.DriveVehicle(varr);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Thank You for Using App ... ");
					return;
				}
			}
		}

	}

}
