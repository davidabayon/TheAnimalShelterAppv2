package com.pointwest.asa.bean;

import com.pointwest.asa.constant.GenericConstants;

public class DogShelter extends AnimalShelter {
	public DogShelter(int maxNumberOfAnimal) {
		super(maxNumberOfAnimal);

		// Set animal in shelter
		setAnimalInShelter(GenericConstants.DOG);
	}
}