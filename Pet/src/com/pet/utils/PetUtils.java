package com.pet.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pet.core.Category;
import com.pet.core.Pet;

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
		
	}
}
