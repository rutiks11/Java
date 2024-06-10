package com.pet.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.pet.core.Category;
import com.pet.core.Order;
import com.pet.core.Pet;
import com.pet.core.Status;
import com.pet.custom_exception.PETException;

public class OrderUtils {

	public static Map<Integer, Order> populateorderMap() {
		Map<Integer, Order> map = new HashMap<Integer, Order>();

		List<Order> orderList = new ArrayList<Order>(
				Arrays.asList(new Order(1, 4, Status.IN_PROCESS), new Order(1, 10, Status.IN_PROCESS),
						new Order(2, 1, Status.IN_PROCESS), new Order(3, 2, Status.IN_PROCESS),
						new Order(4, 3, Status.IN_PROCESS), new Order(5, 4, Status.IN_PROCESS),
						new Order(2, 5, Status.IN_PROCESS), new Order(4, 6, Status.IN_PROCESS)));

		orderList.forEach(s -> map.put(s.getOid(), s));
		return map;
	}

	public static String updateOrderStatus(int id, String status, Map<Integer, Order> orderMap) throws PETException {
		try {
			Status newstatus = Status.valueOf(status);
			System.out.println("IN update");
			if (orderMap.containsKey(id)) {
				System.out.println("In contains");
				Order order = orderMap.get(id);
				order.setStatus(newstatus);
				orderMap.put(order.getOid(), order);
				return "Updated Successfully";
			}
			throw new PETException("Order Id Doesnt exists");
		} catch (Exception e) {
			throw new PETException("Wrong Status ...!");
		}
	}

	public static Status chkStatus(int id, Map<Integer, Order> orderMap) throws PETException {
		if (orderMap.containsKey(id)) {
			Order order = orderMap.get(id);
			return order.getStatus();
		} else {
			throw new PETException("Id Doesn't exists");
		}
	}

	// add method to order the pet
	public static String orderPet(int id, int qty, double amount, Map<Integer, Pet> petMap, Map<Integer, Order> ordeMap)
			throws PETException {
		if (petMap.containsKey(id)) {
			Pet pet = petMap.get(id);
			if (pet.getStocks() > 0) {
				Order newOrder = new Order(pet.getPetid(), 1, Status.IN_PROCESS);
				ordeMap.put(newOrder.getOid(), newOrder);
				pet.setStocks(pet.getStocks() - 1);
				petMap.put(pet.getPetid(), pet);
				return "Order executed successfully";
			}else {
				throw new PETException("Out of Stock");
			}
		} else {
			throw new PETException("Pet doesn't exists");
		}
	}
	
	
	public static String storeData(String filename,Map<Integer,Order> orderMap)
	{
		try(PrintWriter pw= new PrintWriter(new FileWriter(filename)))
		{
			orderMap.values().stream().sorted(Comparator.comparing(Order::getQty)).forEach(s->pw.println(s));
			return "Successfully Stored data";
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "Error in data Storage";
	}
	
	public static void readStoredData(String filename) throws PETException
	{
		try(BufferedReader br=new BufferedReader(new FileReader(filename)))
		{
			br.lines().forEach(s->System.out.println(s));
		}
		catch (Exception e) {
			throw new PETException("File doens't Exists");
		}
	}
}
