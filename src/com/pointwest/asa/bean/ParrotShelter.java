package com.pointwest.asa.bean;

import com.pointwest.asa.constant.GenericConstants;

public class ParrotShelter extends AnimalShelter {
	public ParrotShelter(int maxNumberOfAnimal) {
		super(maxNumberOfAnimal);

		// Set animal in shelter
		setAnimalInShelter(GenericConstants.PARROT);
	}
}
