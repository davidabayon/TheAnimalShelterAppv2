package com.pointwest.asa.bean;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
	private List<Animal> animals;
	private String animalInShelter;
	private int maxNumberOfAnimals;
	private int numberOfAnimal = 0;

	public AnimalShelter(int maxNumberOfAnimals) {
		this.maxNumberOfAnimals = maxNumberOfAnimals;

		animals = new ArrayList<Animal>();
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public String getAnimalInShelter() {
		return animalInShelter;
	}

	public void setAnimalInShelter(String animalInShelter) {
		this.animalInShelter = animalInShelter;
	}

	public int getMaxNumberOfAnimals() {
		return maxNumberOfAnimals;
	}

	public void setNumberOfAnimal(int numberOfAnimal) {
		this.numberOfAnimal = numberOfAnimal;
	}

	public int getNumberOfAnimal() {
		return numberOfAnimal;
	}
}