package com.pet.utils;

<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
=======
import java.util.ArrayList;
import java.util.Arrays;
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
import java.util.List;
import java.util.Map;

import com.pet.core.Category;
import com.pet.core.Pet;
<<<<<<< HEAD
import com.pet.custom_exception.PETException;

public class PetUtils {
	public static Map<Integer, Pet> popopulatePetMap() {
		Map<Integer, Pet> petMap = new HashMap<Integer, Pet>();

		// Populating the Array List
		// petId, name, category, unitPrice, stocks
		List<Pet> petlist = new ArrayList<Pet>(
				Arrays.asList(new Pet("Tomy", Category.DOG, 10000, 1), new Pet("Rony", Category.DOG, 25000, 1),
						new Pet("lily", Category.CAT, 2000, 1), new Pet("Razer", Category.RABBIT, 3011, 1),
						new Pet("Goldy", Category.FISH, 456, 1), new Pet("Shine", Category.FISH, 250, 1)));
		// Populating the Map
		petlist.forEach(s -> petMap.put(s.getPetid(), s));
		// Returning the map
		return petMap;

	}

	
	public static boolean addNewPet(String name, String category, Double price , int stock , Map<Integer, Pet> petMap) throws PETException
	{	
		try {
		Category categoryenum = Category.valueOf(category);
		Pet pet = new Pet(name, categoryenum, price, stock);
		petMap.put(pet.getPetid(), pet);
		return true;
		}catch (Exception e) {
			throw new PETException("Category Does not Exists");
		}
	}
	
	public static String updatePet(int id,double price,int value,Map<Integer,Pet> petMap) throws PETException
	{	
		if(petMap.containsKey(id))
		{
			Pet pet = petMap.get(id);
			pet.setUnitprice(price);
			pet.setStocks(value);
			petMap.put(pet.getPetid(), pet);
			return "Successfully Updated";
		}
		throw new PETException("Pet Doesn't Exists");
	}
	
	public static String writeDataInSer(String filename,Map<Integer,Pet> orderMap) throws PETException
	{	
		try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(orderMap);
			return "Data Written suceesfully";
		}
		catch (Exception e) {
			throw new PETException("ERROR");
		}
	}
	
	
	public static String  readDataIndeser(String filename) throws PETException
	{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename)))
		{
			@SuppressWarnings("unchecked")
			Map<Integer, Pet> map= (Map<Integer, Pet>)in.readObject();
			map.values().stream().forEach(s->System.out.println(s));
			return "Data Successfully Read";
		}
		catch (Exception e) {
			throw new PETException("ERROR in Reading Binary File");
		}
=======

public class PetUtils {
	public static Map<Integer, Pet> popopulatePetMap()
	{
		//petId, name, category, unitPrice, stocks
		List<Pet> petlist = new ArrayList<Pet>(Arrays.asList(
				new Pet("Tomy", Category.DOG,10000,1),
				new Pet("Rony", Category.DOG,25000,1),
				new Pet("lily", Category.CAT,2000,1),
				new Pet("Rony", Category.DOG,25000,1),
				new Pet("Rony", Category.DOG,25000,1),
				new Pet("Rony", Category.DOG,25000,1)
				));
		
		return null;
		
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
	}
}
