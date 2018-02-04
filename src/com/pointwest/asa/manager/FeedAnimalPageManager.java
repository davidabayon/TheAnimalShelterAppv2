package com.pointwest.asa.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;

public class FeedAnimalPageManager {
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;
	AnimalShelter animalShelter = null;
	Animal animal = null;

	// Remove animal based on reference ID
	public Animal feedAnimal(HashMap<AnimalShelter, List<Animal>> animalShelters, String animal, String referenceId) {

		for (Entry<AnimalShelter, List<Animal>> animalShelter : animalShelters.entrySet()) {
			if (animal.equalsIgnoreCase(animalShelter.getKey().getAnimalInShelter())) {
				this.animalShelter = animalShelter.getKey();
				break;
			}
		}

		List<Animal> animals = animalShelter.getAnimals();
		int numberOfAnimals = animals.size();
		for (int index = 0; index < numberOfAnimals; index++) {
			if (animals.get(index).getReferenceId().equalsIgnoreCase(referenceId.trim())) {
				this.animal = animals.get(index);
				break;
			}
		}

		return this.animal;
	}
}