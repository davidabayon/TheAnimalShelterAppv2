package com.pointwest.asa.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;
import com.pointwest.asa.bean.MainAnimalShelter;

public class RemoveAnimalPageManager {
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;
	AnimalShelter animalShelter = null;
	Animal animal = null;

	// Remove animal based on reference ID
	public boolean removeAnimal(HashMap<AnimalShelter, List<Animal>> animalShelters, String animal,
			String referenceId) {
		boolean isFound = false;

		for (Entry<AnimalShelter, List<Animal>> animalShelter : animalShelters.entrySet()) {
			if (animal.equalsIgnoreCase(animalShelter.getKey().getAnimalInShelter())) {
				this.animalShelter = animalShelter.getKey();
				break;
			}
		}

		List<Animal> animals = animalShelter.getAnimals();
		int numberOfAnimals = animals.size();
		int totalNumberOfAnimals = MainAnimalShelter.getTotalNumberOfAnimals();
		for (int index = 0; index < numberOfAnimals; index++) {
			if (animals.get(index).getReferenceId().equalsIgnoreCase(referenceId.trim())) {
				animals.remove(animals.get(index));
				MainAnimalShelter.setTotalNumberOfAnimals(totalNumberOfAnimals - 1);
				isFound = true;
				break;
			} else
				isFound = false;
		}

		return isFound;
	}
}