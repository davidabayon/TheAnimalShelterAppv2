package com.pointwest.asa.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;
import com.pointwest.asa.constant.GenericConstants;
import com.pointwest.asa.manager.FeedAnimalPageManager;

public class FeedAnimalPageUI implements AppPageUI {
	Scanner scanner = new Scanner(System.in);
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;
	AnimalShelter animalShelter = null;
	String animal = null;

	public FeedAnimalPageUI(HashMap<AnimalShelter, List<Animal>> animalShelters, String animal) {
		this.animalShelters = animalShelters;

		for (Entry<AnimalShelter, List<Animal>> animalShelter : animalShelters.entrySet()) {
			if (animal.equalsIgnoreCase(animalShelter.getKey().getAnimalInShelter())) {
				this.animalShelter = animalShelter.getKey();
				this.animal = animal;
				break;
			}
		}
	}

	// Displays fed animal
	public void displayFedAnimal(String referenceId) {
		FeedAnimalPageManager feedAnimalPageManager = new FeedAnimalPageManager();
		Animal animal = null;

		animal = feedAnimalPageManager.feedAnimal(animalShelters, this.animal, referenceId);
		if (animal != null)
			System.out.println("\n" + animal.getReferenceId() + " " + animal.getName() + ": (" + animal.makeSound()
					+ ") Thanks for feeding me! <3");
		else
			System.out.println(this.animal + " " + referenceId + " is not on found!");
	}

	@Override
	public void displayPage() {
		System.out.format("%46s", "--------------------------\n");
		System.out.format("%45s", "     FEED ANIMAL PAGE     \n");
		System.out.format("%46s", "--------------------------\n");
		System.out.format("%46s", "Meet our lovely " + animal + " friends!\n");
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
	public String askChoice() {
		String referenceId = null;

		System.out.print("\n" + GenericConstants.ASK_REFERENCE_ID_FEED);
		referenceId = scanner.next();

		return referenceId;
	}
}