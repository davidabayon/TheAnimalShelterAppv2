package com.pointwest.asa.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;
import com.pointwest.asa.constant.GenericConstants;

public class AnimalMenuPage implements AppPageUI {
	Scanner scanner = new Scanner(System.in);
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;
	AnimalShelter animalShelter = null;
	String animal = null;
	int numberOfAnimals;
	int maxNumberOfAnimals;

	public AnimalMenuPage(HashMap<AnimalShelter, List<Animal>> animalShelters, String animal) {
		this.animalShelters = animalShelters;

		for (Entry<AnimalShelter, List<Animal>> animalShelter : this.animalShelters.entrySet()) {
			if (animal.equalsIgnoreCase(animalShelter.getKey().getAnimalInShelter())) {
				this.animalShelter = animalShelter.getKey();
				this.animal = animal;
				break;
			}
		}
	}

	@Override
	public void displayPage() {
		numberOfAnimals = this.animalShelter.getAnimals().size();
		maxNumberOfAnimals = this.animalShelter.getMaxNumberOfAnimals();

		if (numberOfAnimals == maxNumberOfAnimals) {
			System.out.format("%45s", "--------------------------\n");
			System.out.format("%45s", "    M E N U    P A G E    \n");
			System.out.format("%45s", "--------------------------\n");
			System.out.format("%48s", "Welcome to the " + animal + "  Shelter!\n\n");
			System.out.println("Please select an option:");
			System.out.println("[1] Remove a " + animal);
			System.out.println("[2] View all " + animal + "(s)");
			System.out.println("[3] Feed a " + animal);
			System.out.println("[4] Go back to Home Page\n");
		} else if (numberOfAnimals > 0 && numberOfAnimals <= maxNumberOfAnimals) {
			System.out.format("%45s", "--------------------------\n");
			System.out.format("%45s", "    M E N U    P A G E    \n");
			System.out.format("%45s", "--------------------------\n");
			System.out.format("%48s", "Welcome to the " + animal + "  Shelter!\n\n");
			System.out.println("Please select an option:");
			System.out.println("[1] Add a " + animal);
			System.out.println("[2] Remove a " + animal);
			System.out.println("[3] View all " + animal + "(s)");
			System.out.println("[4] Feed a " + animal);
			System.out.println("[5] Go back to Home Page\n");
		} else {
			System.out.format("%45s", "--------------------------\n");
			System.out.format("%45s", "    M E N U    P A G E    \n");
			System.out.format("%45s", "--------------------------\n");
			System.out.format("%48s", "Welcome to the " + animal + "  Shelter!\n\n");
			System.out.println("Please select an option:");
			System.out.println("[1] Add a " + animal);
			System.out.println("[2] Go back to Home Page\n");
		}
	}

	@Override
	public String askChoice() {
		numberOfAnimals = this.animalShelter.getAnimals().size();
		maxNumberOfAnimals = this.animalShelter.getMaxNumberOfAnimals();
		boolean flagError = false;
		String choice = null;

		if (numberOfAnimals == maxNumberOfAnimals) {
			do {
				System.out.print(GenericConstants.ASK_CHOICE);
				choice = scanner.next();

				// Validate if choice is within choices
				switch (choice.trim()) {
				case "1":
					choice = GenericConstants.REMOVE_ANIMAL;
					flagError = false;
					break;
				case "2":
					choice = GenericConstants.VIEW_ANIMAL;
					flagError = false;
					break;
				case "3":
					choice = GenericConstants.FEED_ANIMAL;
					flagError = false;
					break;
				case "4":
					choice = GenericConstants.GO_BACK;
					flagError = false;
					break;
				default:
					flagError = true;
					System.out.println(GenericConstants.INPUT_NOT_VALID);
				}
			} while (flagError);
		} else if (numberOfAnimals > 0 && numberOfAnimals <= maxNumberOfAnimals) {
			do {
				System.out.print(GenericConstants.ASK_CHOICE);
				choice = scanner.next();

				// Validate if choice is within choices
				switch (choice.trim()) {
				case "1":
					choice = GenericConstants.ADD_ANIMAL;
					flagError = false;
					break;
				case "2":
					choice = GenericConstants.REMOVE_ANIMAL;
					flagError = false;
					break;
				case "3":
					choice = GenericConstants.VIEW_ANIMAL;
					flagError = false;
					break;
				case "4":
					choice = GenericConstants.FEED_ANIMAL;
					flagError = false;
					break;
				case "5":
					choice = GenericConstants.GO_BACK;
					flagError = false;
					break;
				default:
					flagError = true;
					System.out.println(GenericConstants.INPUT_NOT_VALID);
				}
			} while (flagError);
		} else {
			do {
				System.out.print(GenericConstants.ASK_CHOICE);
				choice = scanner.next();

				// Validate if choice is within choices
				switch (choice.trim()) {
				case "1":
					choice = GenericConstants.ADD_ANIMAL;
					flagError = false;
					break;
				case "2":
					choice = GenericConstants.GO_BACK;
					flagError = false;
					break;
				default:
					flagError = true;
					System.out.println(GenericConstants.INPUT_NOT_VALID);
				}
			} while (flagError);
		}
		return choice;
	}

	// Displays animal shelter's current number
	public void displayAnimalPopulationStatus() {
		numberOfAnimals = this.animalShelter.getAnimals().size();
		maxNumberOfAnimals = this.animalShelter.getMaxNumberOfAnimals();

		if (numberOfAnimals == maxNumberOfAnimals) {
			System.out.println();
			System.out.format("%56s",
					"Current number of " + animal + "(s) in the shelter is [" + numberOfAnimals + "]");
			System.out.println();
			System.out.format("%47s", "Sorry, the " + animal + " shelter is now full!");
			System.out.println();
			System.out.format("%53s", "We can no longer accept any new " + animal + "\n\n");
		} else if (numberOfAnimals > 0 && numberOfAnimals <= maxNumberOfAnimals) {
			System.out.println();
			System.out.format("%56s",
					"Current number of " + animal + "(s) in the shelter is [" + numberOfAnimals + "]\n\n");
		} else {
			System.out.println();
			System.out.format("%61s",
					"There are [" + numberOfAnimals + "] " + animal + "(s) in the shelter, create one first\n\n");
		}
	}
}