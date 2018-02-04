package com.pointwest.asa.constant;

public class GenericConstants {
	public static final String DOG = "Dog";
	public static final String CAT = "Cat";
	public static final String PARROT = "Parrot";
	public static final String[] CHOICES = { "1", "2", "3", "4", "5" };

	public static final String ADD_ANIMAL = "ADD";
	public static final String REMOVE_ANIMAL = "REMOVE ANIMAL";
	public static final String VIEW_ANIMAL = "VIEW ANIMAL";
	public static final String VIEW_ALL_ANIMAL = "VIEW ALL ANIMAL";
	public static final String FEED_ANIMAL = "FEED ANIMAL";
	public static final String GO_BACK = "GO BACK";
	public static final String END_APP = "END APP";

	public static final String ASK_CHOICE = "Enter your choice: ";
	public static final String ASK_REFERENCE_ID_REMOVE = "Enter the Reference ID of the animal to be removed: ";
	public static final String ASK_REFERENCE_ID_FEED = "Enter the Reference ID of the animal to be fed: ";
	public static final String CONFIRM_TERMINATION = "Are you sure you want to end? [Y or N]: ";
	public static final String CONFIRM_CONTINUE = "Do you want to continue? [Y or N]: ";

	public static final String INPUT_OUT_OF_RANGE = "Input is out of range!";
	public static final String INPUT_NOT_VALID = "Input is not valid!";

	// Displays the Main Header
	public final static void displayMainHeader() {
		System.out.println("================================================================");
		System.out.println("                       THE ANIMAL SHELTER                       ");
		System.out.println("================================================================");
	}

	// Displays the Main Footer
	public final static void displayMainFooter() {
		System.out.println("\n================================================================");
		System.out.println("                    GOODBYE! COME BACK AGAIN!                   ");
		System.out.println("================================================================");
	}
}