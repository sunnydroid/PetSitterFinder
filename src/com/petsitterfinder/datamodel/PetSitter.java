package com.petsitterfinder.datamodel;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("PetSitter")
public class PetSitter extends ParseObject {
	
	public PetSitter() {
		
	}
	
	@Override
	public String toString() {
		String stringValue = this.getString("name");
		return stringValue;
	}
}
