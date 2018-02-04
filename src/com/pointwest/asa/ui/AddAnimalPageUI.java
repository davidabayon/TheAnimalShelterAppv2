package com.pointwest.asa.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;
import com.pointwest.asa.constant.GenericConstants;
import com.pointwest.asa.manager.AddAnimalPageManager;

public class AddAnimalPageUI implements AppPageUI {
	Scanner scanner = new Scanner(System.in);
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;
	AnimalShelter animalShelter = null;
	String animal = null;

	public AddAnimalPageUI(HashMap<AnimalShelter, List<Animal>> animalShelters, String animal) {
		this.animalShelters = animalShelters;

		for (Entry<AnimalShelter, List<Animal>> animalShelter : animalShelters.entrySet()) {
			if (animal.equalsIgnoreCase(animalShelter.getKey().getAnimalInShelter())) {
				this.animalShelter = animalShelter.getKey();
				this.animal = animal;
				break;
			}
		}
	}

	// Ask for details of animal then create animal
	public void askAnimalDetails() {
		AddAnimalPageManager addAnimalPageManager = new AddAnimalPageManager();
		String name = null;
		String age = null;
		int ageInt = 0;
		String gender = null;
		boolean flagError = false;

		// Enter name
		System.out.print("   Name : ");
		name = scanner.next();

		// Enter age
		do {
			System.out.print("    Age : ");
			age = scanner.next();

			// Validate if choice is within choices
			for (int index = 1; index <= 20; index++) {
				if (("" + index).trim().equalsIgnoreCase(age.trim())) {
					ageInt = Integer.parseInt(age);
					flagError = false;
					break;
				} else
					flagError = true;
			}

			if (flagError)
				System.out.println("    " + GenericConstants.INPUT_NOT_VALID);
		} while (flagError);

		// Enter gender
		do {
			System.out.print(" Gender : ");
			gender = scanner.next();

			// Validate input
			if ("Male".equalsIgnoreCase(gender) || "M".equalsIgnoreCase(gender)) {
				flagError = false;
				gender = "Male";
			} else if ("Female".equalsIgnoreCase(gender) || "F".equalsIgnoreCase(gender)) {
				flagError = false;
				gender = "Female";
			} else {
				flagError = true;
				System.out.println(" " + GenericConstants.INPUT_NOT_VALID);
			}
		} while (flagError);

		// Create animal
		animal = addAnimalPageManager.createAnimal(animalShelters, animal, name, ageInt, gender);
		System.out.println("You have successfully added a " + animal + "!");
	}

	@Override
	// Displays the Add Animal Page
	public void displayPage() {
		System.out.format("%45s", "--------------------------\n");
		System.out.format("%45s", "      ADD ANIMAL PAGE     \n");
		System.out.format("%46s", "--------------------------\n\n");
		System.out.println("Fill in the details for your " + animal + ":");
	}

	@Override
	public String askChoice() {
		return null;
	}
}