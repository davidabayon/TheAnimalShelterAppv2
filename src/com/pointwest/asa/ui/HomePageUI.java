package com.pointwest.asa.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;
import com.pointwest.asa.bean.MainAnimalShelter;
import com.pointwest.asa.constant.GenericConstants;

public class HomePageUI implements AppPageUI {
	Scanner scanner = new Scanner(System.in);
	HashMap<AnimalShelter, List<Animal>> animalShelters = null;

	public HomePageUI(HashMap<AnimalShelter, List<Animal>> animalShelters) {
		this.animalShelters = animalShelters;
	}

	// Display continue confirmation
	public boolean confirmContinue() {
		String inputDecision = null;
		boolean askAgain = false;
		boolean isContinue = false;

		do {
			System.out.print("\n" + GenericConstants.CONFIRM_CONTINUE);
			inputDecision = scanner.next();

			if ("Y".equalsIgnoreCase(inputDecision.trim()) || "Yes".equalsIgnoreCase(inputDecision.trim())) {
				isContinue = true;
				askAgain = false;
			} else if ("N".equalsIgnoreCase(inputDecision.trim()) || "No".equalsIgnoreCase(inputDecision.trim())) {
				isContinue = false;
				askAgain = false;
			} else {
				System.out.println(GenericConstants.INPUT_NOT_VALID);
				askAgain = true;
			}

			scanner.nextLine();
			System.out.println();
		} while (askAgain);

		return isContinue;
	}

	// Display termination confirmation
	public boolean confirmTermination() {
		String inputDecision = null;
		boolean askAgain = false;
		boolean isTerminate = false;

		do {
			System.out.print("\n" + GenericConstants.CONFIRM_TERMINATION);
			inputDecision = scanner.next();

			if ("Y".equalsIgnoreCase(inputDecision.trim()) || "Yes".equalsIgnoreCase(inputDecision.trim())) {
				isTerminate = true;
				askAgain = false;
			} else if ("N".equalsIgnoreCase(inputDecision.trim()) || "No".equalsIgnoreCase(inputDecision.trim())) {
				isTerminate = false;
				askAgain = false;
			} else {
				System.out.println(GenericConstants.INPUT_NOT_VALID);
				askAgain = true;
			}

			scanner.nextLine();
			System.out.println();
		} while (askAgain);

		return isTerminate;
	}

	// Displays all shelters' current number
	public void displayAllPopulationStatus() {
		int totalNumberOfAnimals = MainAnimalShelter.getTotalNumberOfAnimals();
		int maxNumberOfAnimals = MainAnimalShelter.getMaxNumberOfAnimals();

		if (totalNumberOfAnimals == maxNumberOfAnimals) {
			System.out.println();
			System.out.format("%56s", "Current number of animals in the shelters are [" + totalNumberOfAnimals + "]");
			System.out.println();
			System.out.format("%47s", "Sorry, the shelters are now full!");
			System.out.println();
			System.out.format("%53s", "We can no longer accept any new animal\n");
		} else if (totalNumberOfAnimals > 0 && totalNumberOfAnimals <= maxNumberOfAnimals) {
			System.out.println();
			System.out.format("%56s",
					"Current number of animals in the shelters are [" + totalNumberOfAnimals + "]\n\n");
		} else {
			System.out.println();
			System.out.format("%61s",
					"There are [" + totalNumberOfAnimals + "] animals in the shelter, create one first\n\n");
		}
	}

	// Display all animals
	public void displayAllAnimals() {
		System.out.format("%45s", "--------------------------\n");
		System.out.format("%45s", "  VIEW ALL ANIMALS PAGE   \n");
		System.out.format("%46s", "--------------------------\n");

		for (Entry<AnimalShelter, List<Animal>> animalShelter : this.animalShelters.entrySet()) {
			System.out.format("%46s", "Meet our lovely " + animalShelter.getKey().getAnimalInShelter() + " friends!\n");
			for (Animal animal : animalShelter.getValue()) {
				System.out.println(animal.greet());
			}
			System.out.println();
		}
	}

	@Override
	// Displays the Home Page
	public void displayPage() {
		System.out.format("%45s", "--------------------------\n");
		System.out.format("%45s", "    H O M E    P A G E    \n");
		System.out.format("%45s", "--------------------------\n");
		System.out.format("%48s", "Welcome to JC's Animal Shelter!\n\n");
		System.out.println("Please select an option:");
		System.out.println("[1] " + GenericConstants.DOG + " shelter");
		System.out.println("[2] " + GenericConstants.CAT + " shelter");
		System.out.println("[3] " + GenericConstants.PARROT + " shelter");
		System.out.println("[4] View all animals");
		System.out.println("[5] End application");
	}

	@Override
	// Asks choice from user
	public String askChoice() {
		boolean flagError = false;
		String choice = null;

		do {
			System.out.print("\n" + GenericConstants.ASK_CHOICE);
			choice = scanner.next();

			// Validate if choice is within the list
			switch (choice.trim()) {
			case "1":
				choice = GenericConstants.DOG;
				flagError = false;
				break;
			case "2":
				choice = GenericConstants.CAT;
				flagError = false;
				break;
			case "3":
				choice = GenericConstants.PARROT;
				flagError = false;
				break;
			case "4":
				choice = GenericConstants.VIEW_ALL_ANIMAL;
				flagError = false;
				break;
			case "5":
				choice = GenericConstants.END_APP;
				flagError = false;
				break;
			default:
				flagError = true;
				System.out.println(GenericConstants.INPUT_NOT_VALID);
			}
		} while (flagError);

		return choice;
	}
}