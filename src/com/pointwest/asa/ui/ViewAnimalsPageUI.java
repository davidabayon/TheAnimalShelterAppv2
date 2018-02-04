package com.pointwest.asa.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;

public class ViewAnimalsPageUI implements AppPageUI {
	Scanner scanner = new Scanner(System.in);
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;
	AnimalShelter animalShelter = null;
	String animal = null;

	public ViewAnimalsPageUI(HashMap<AnimalShelter, List<Animal>> animalShelters, String animal) {
		this.animalShelters = animalShelters;

		for (Entry<AnimalShelter, List<Animal>> animalShelter : animalShelters.entrySet()) {
			if (animal.equalsIgnoreCase(animalShelter.getKey().getAnimalInShelter())) {
				this.animalShelter = animalShelter.getKey();
				this.animal = animal;
				break;
			}
		}
	}

	@Override
	public void displayPage() {
		System.out.format("%45s", "--------------------------\n");
		System.out.format("%45s", "     VIEW ANIMALS PAGE    \n");
		System.out.format("%46s", "--------------------------\n");
		System.out.format("%46s", "Meet our lovely " + animal + " friends!\n");

		for (Animal animal : animalShelter.getAnimals()) {
			System.out.println(animal.greet());
		}
	}

	@Override
	public String askChoice() {
		return null;
	}
}