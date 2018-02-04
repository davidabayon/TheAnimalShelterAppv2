package com.pointwest.asa.bean;

import java.text.DecimalFormat;

import com.pointwest.asa.constant.GenericConstants;

public class Parrot extends Animal {
	public Parrot(AnimalShelter animalShelter, String name, int age, String gender) {
		super(name, age, gender);

		// Format for the Reference ID
		DecimalFormat format = new DecimalFormat("P000");

		// Set the reference ID and increase the number of animal
		int totalNumberOfAnimals = MainAnimalShelter.getTotalNumberOfAnimals();
		int numberOfAnimal = animalShelter.getNumberOfAnimal();
		setReferenceId(format.format(numberOfAnimal++));
		MainAnimalShelter.setTotalNumberOfAnimals(totalNumberOfAnimals + 1);
		animalShelter.setNumberOfAnimal(numberOfAnimal);

		// Set Animal Type
		setAnimalType(GenericConstants.PARROT);
	}

	@Override
	public String makeSound() {
		String sound = "Aack! Aack! Aack!";
		return sound;
	}

	@Override
	public String greet() {
		String greeting = getReferenceId() + " : (" + makeSound() + ") Hi! I'm " + getName() + " the " + getAnimalType()
				+ ", " + getAge() + " yrs. old";
		return greeting;
	}
}