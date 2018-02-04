package com.pointwest.asa.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;
import com.pointwest.asa.constant.GenericConstants;
import com.pointwest.asa.manager.RemoveAnimalPageManager;

public class RemoveAnimalPageUI implements AppPageUI {
	Scanner scanner = new Scanner(System.in);
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;
	AnimalShelter animalShelter = null;
	String animal = null;

	public RemoveAnimalPageUI(HashMap<AnimalShelter, List<Animal>> animalShelters, String animal) {
		this.animalShelters = animalShelters;

		for (Entry<AnimalShelter, List<Animal>> animalShelter : animalShelters.entrySet()) {
			if (animal.equalsIgnoreCase(animalShelter.getKey().getAnimalInShelter())) {
				this.animalShelter = animalShelter.getKey();
				this.animal = animal;
				break;
			}
		}
	}

	// Displays removed animal confirmation
	public void displayRemovedAnimal(String referenceId) {
		RemoveAnimalPageManager removeAnimalPageManager = new RemoveAnimalPageManager();
		boolean isFound = false;

		isFound = removeAnimalPageManager.removeAnimal(animalShelters, animal, referenceId);
		if (isFound)
			System.out.println(animal + " " + referenceId + " has been removed");
		else
			System.out.println(animal + " " + referenceId + " is not on found!");
	}

	@Override
	// Displays the Remove Animal Page
	public void displayPage() {
		System.out.format("%45s", "--------------------------\n");
		System.out.format("%45s", "    REMOVE ANIMAL PAGE    \n");
		System.out.format("%46s", "--------------------------\n\n");
		System.out.println("  ------------------------------------------------------------");
		System.out.format("%-15s %-14s %-11s %-7s %-11s", "   REFERENCE ID", "| NAME ", "| TYPE ", "| AGE", "| GENDER");
		System.out.println();
		System.out.println("  ------------------------------------------------------------");

		for (Animal animal : animalShelter.getAnimals()) {
			System.out.format("%-15s %-14s %-11s %-7s %-11s", "   " + animal.getReferenceId(), "| " + animal.getName(),
					"| " + animal.getAnimalType(), "| " + animal.getAge(), "| " + animal.getGender());
			System.out.println();
		}
		System.out.println("  ------------------------------------------------------------");
	}

	@Override
	// Asks choice from user
	public String askChoice() {
		String referenceId = null;

		System.out.print("\n" + GenericConstants.ASK_REFERENCE_ID_REMOVE);
		referenceId = scanner.next();

		return referenceId;
	}
}