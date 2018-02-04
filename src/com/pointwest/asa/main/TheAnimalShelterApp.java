package com.pointwest.asa.main;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.pointwest.asa.bean.Animal;
import com.pointwest.asa.bean.AnimalShelter;
import com.pointwest.asa.bean.MainAnimalShelter;
import com.pointwest.asa.constant.GenericConstants;
import com.pointwest.asa.ui.AddAnimalPageUI;
import com.pointwest.asa.ui.AnimalMenuPage;
import com.pointwest.asa.ui.FeedAnimalPageUI;
import com.pointwest.asa.ui.HomePageUI;
import com.pointwest.asa.ui.RemoveAnimalPageUI;
import com.pointwest.asa.ui.ViewAnimalsPageUI;

/*
* Author: David Abayon
* Date: January 31, 2018
*/

public class TheAnimalShelterApp {
	public static void main(String[] args) {
		// Instantiate objects needed
		Scanner scanner = new Scanner(System.in);
		MainAnimalShelter mainAnimalShelter = new MainAnimalShelter();
		HashMap<AnimalShelter, List<Animal>> animalShelters = null;
		HomePageUI homePage = null;

		// Declare and initialize variables
		String choiceHomePage = null;
		String choiceAnimalMenuPage = null;
		boolean isTerminate = false;
		boolean askAgain = false;
		boolean isContinue = false;
		boolean isGoBack = false;

		// Start the application
		GenericConstants.displayMainHeader();
		do {
			animalShelters = mainAnimalShelter.getAnimalShelters();
			do {
				int totalNumberOfAnimals = MainAnimalShelter.getTotalNumberOfAnimals();
				int maxNumberOfAnimals = MainAnimalShelter.getMaxNumberOfAnimals();

				// Home Page
				homePage = new HomePageUI(animalShelters);
				if (totalNumberOfAnimals != maxNumberOfAnimals)
					homePage.displayAllPopulationStatus();
				homePage.displayPage();
				choiceHomePage = homePage.askChoice();

				switch (choiceHomePage) {
				case GenericConstants.DOG:
				case GenericConstants.CAT:
				case GenericConstants.PARROT:
					askAgain = false;
					break;
				case GenericConstants.VIEW_ALL_ANIMAL:
					homePage.displayAllAnimals();
					askAgain = true;
					break;
				case GenericConstants.END_APP:
					isTerminate = homePage.confirmTermination();
					askAgain = !isTerminate;
					isGoBack = isTerminate;
					isContinue = !isTerminate;
					break;
				}
			} while (askAgain);

			do {
				if (!isTerminate) {
					// Go to Animal Menu Page
					AnimalMenuPage animalMenuPage = new AnimalMenuPage(animalShelters, choiceHomePage);
					animalMenuPage.displayAnimalPopulationStatus();
					animalMenuPage.displayPage();
					choiceAnimalMenuPage = animalMenuPage.askChoice();
					String referenceId = null;

					switch (choiceAnimalMenuPage) {
					case GenericConstants.ADD_ANIMAL:
						AddAnimalPageUI addAnimalPageUI = new AddAnimalPageUI(animalShelters, choiceHomePage);
						isGoBack = false;

						// Add Animal Page
						animalMenuPage.displayAnimalPopulationStatus();
						addAnimalPageUI.displayPage();
						addAnimalPageUI.askAnimalDetails();

						// Ask confirm if max number of animals is reached
						if (MainAnimalShelter.getTotalNumberOfAnimals() == MainAnimalShelter.getMaxNumberOfAnimals()) {
							homePage.displayAllPopulationStatus();
							isContinue = homePage.confirmContinue();
							isTerminate = !isContinue;
							isGoBack = true;
						}

						break;
					case GenericConstants.REMOVE_ANIMAL:
						RemoveAnimalPageUI removeAnimalPageUI = new RemoveAnimalPageUI(animalShelters, choiceHomePage);
						isGoBack = false;

						// Remove Animal Page
						animalMenuPage.displayAnimalPopulationStatus();
						removeAnimalPageUI.displayPage();
						referenceId = removeAnimalPageUI.askChoice();
						removeAnimalPageUI.displayRemovedAnimal(referenceId);
						break;
					case GenericConstants.VIEW_ANIMAL:
						ViewAnimalsPageUI viewAnimalsPageUI = new ViewAnimalsPageUI(animalShelters, choiceHomePage);
						isGoBack = false;

						// View Animal Page
						animalMenuPage.displayAnimalPopulationStatus();
						viewAnimalsPageUI.displayPage();
						break;
					case GenericConstants.FEED_ANIMAL:
						FeedAnimalPageUI feedAnimalPageUI = new FeedAnimalPageUI(animalShelters, choiceHomePage);
						isGoBack = false;

						// Feed Animal Page
						animalMenuPage.displayAnimalPopulationStatus();
						feedAnimalPageUI.displayPage();
						referenceId = feedAnimalPageUI.askChoice();
						feedAnimalPageUI.displayFedAnimal(referenceId);
						break;
					case GenericConstants.GO_BACK:
						isGoBack = true;
						break;
					}
				}
			} while (!isGoBack);
		} while (!isTerminate || isContinue);

		// Terminate the application
		GenericConstants.displayMainFooter();
		scanner.close();
	}
}