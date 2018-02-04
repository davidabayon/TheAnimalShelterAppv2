package com.pointwest.asa.bean;

import java.util.HashMap;
import java.util.List;

public class MainAnimalShelter {
	private HashMap<AnimalShelter, List<Animal>> animalShelters;
	private static int maxNumberOfAnimals = 15;
	private static int totalNumberOfAnimals = 0;

	public MainAnimalShelter() {
		animalShelters = new HashMap<AnimalShelter, List<Animal>>();

		AnimalShelter dogShelter = new DogShelter(5);
		AnimalShelter catShelter = new CatShelter(5);
		AnimalShelter parrotShelter = new ParrotShelter(5);

		animalShelters.put(dogShelter, dogShelter.getAnimals());
		animalShelters.put(catShelter, catShelter.getAnimals());
		animalShelters.put(parrotShelter, parrotShelter.getAnimals());
	}

	public HashMap<AnimalShelter, List<Animal>> getAnimalShelters() {
		return animalShelters;
	}

	public static int getMaxNumberOfAnimals() {
		return maxNumberOfAnimals;
	}

	public static int getTotalNumberOfAnimals() {
		return totalNumberOfAnimals;
	}

	public static void setTotalNumberOfAnimals(int totalNumberOfAnimals) {
		MainAnimalShelter.totalNumberOfAnimals = totalNumberOfAnimals;
	}
}