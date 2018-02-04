package com.pointwest.asa.bean;

import com.pointwest.asa.constant.GenericConstants;

public class CatShelter extends AnimalShelter {
	public CatShelter(int maxNumberOfAnimal) {
		super(maxNumberOfAnimal);

		// Set animal in shelter
		setAnimalInShelter(GenericConstants.CAT);
	}
}