package com.pointwest.asa.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;
import com.pointwest.asa.bean.Cat;
import com.pointwest.asa.bean.Dog;
import com.pointwest.asa.bean.Parrot;
import com.pointwest.asa.constant.GenericConstants;

public class AddAnimalPageManager {
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;
	AnimalShelter animalShelter = null;
	Animal animal = null;

	// Create animal based on choice
	public String createAnimal(HashMap<AnimalShelter, List<Animal>> animalShelters, String animal, String name, int age,
			String gender) {
		for (Entry<AnimalShelter, List<Animal>> animalShelter : animalShelters.entrySet()) {
			if (animal.equalsIgnoreCase(animalShelter.getKey().getAnimalInShelter())) {
				this.animalShelter = animalShelter.getKey();
				break;
			}
		}

		switch (animal) {
		case GenericConstants.DOG:
			this.animal = new Dog(animalShelter, name, age, gender);
			animalShelter.getAnimals().add(this.animal);
			break;
		case GenericConstants.CAT:
			this.animal = new Cat(animalShelter, name, age, gender);
			animalShelter.getAnimals().add(this.animal);
			break;
		case GenericConstants.PARROT:
			this.animal = new Parrot(animalShelter, name, age, gender);
			animalShelter.getAnimals().add(this.animal);
			break;
		}

		animal = this.animal.getAnimalType();
		return animal;
	}
}