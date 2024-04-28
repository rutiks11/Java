package utils;

import static custom_excetion.VehicleValidation.ChkPollutionRate;
import static custom_excetion.VehicleValidation.ChkColorAvailibility;
import static custom_excetion.VehicleValidation.ChkKilometers;

import java.util.Scanner;

import custom_excetion.PollutionLevExceedException;
import vehiclemain.Color;
import vehiclemain.Vehicle;

public class VehicleUtility {
	public static int icnt = 0;
	static Scanner sc = new Scanner(System.in);

	public static void acceptVehicle(Vehicle varr[]) throws PollutionLevExceedException {

		String chasisno;
		Color col = null;
		Double price;
		Double pollutionLevel;
		String colorString;

		char c = 0;

		while (icnt < varr.length) {
			System.out.println("\nEnter Chasis Number :: ");
			chasisno = sc.next();

			System.out.println("Enter Color :: \n1.BLACK\n2.BLUE\n3.RED\n4.SILVER\n5.White");
			col = ChkColorAvailibility(colorString = sc.next());
			
			
			System.out.println("Enter Price :: ");
			price = sc.nextDouble();

			System.out.println("Enter Pollution Level :: ");
			ChkPollutionRate(pollutionLevel = sc.nextDouble());

			varr[icnt] = new Vehicle(chasisno, col, price, pollutionLevel);
			icnt++;

			System.out.println("Add More : y/n");
			c = sc.next().charAt(0);
			if (c == 'n')
				break;
		}

	}

	public static void displayVehicle(Vehicle varr[]) {
		for (int i = 0; i < icnt; i++) {
			System.out.println(varr[i]);
		}
	}

	public static void DriveVehicle(Vehicle varr[]) throws PollutionLevExceedException {
		Double km = 0.0;
		String chasisNoString = "";

		System.out.println("Enter ChasisNo : ");
		chasisNoString = sc.next();

		for (int icnt = 0; icnt < VehicleUtility.icnt; icnt++) {
			
			if ((varr[icnt].getChasisno()).equalsIgnoreCase(chasisNoString)) {
				System.out.println("Enter Kilometers ");
				ChkKilometers(km = sc.nextDouble());
			}
			else {
				System.out.println("Vehicle Not Available..");
			}
		}

	}
}
