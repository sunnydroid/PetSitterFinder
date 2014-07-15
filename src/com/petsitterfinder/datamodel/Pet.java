package com.petsitterfinder.datamodel;

import com.parse.GetCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Pet")
public class Pet extends ParseObject {
	
	public Pet() {
		super();
	}
	
	//age
	public void setAge(int age) {
		put("age", age);
	}
	
	public int getAge() {
		return getInt("age");
	}
	
	//basic training
	public void setBasicTraining(Boolean basicTraining) {
		put("basicTraining", basicTraining);
	}
	
	public Boolean getbasicTraining() {
		return getBoolean("basicTraining");
	}
	
	//breed
	public void setBreed(String Breed) {
		put("breed", Breed);
	}
	
	public String getBreed() {
		return getString("breed");
	}
	
	//houseBroken
	public void setHouseBroken(Boolean houseBroken) {
		put("houseBroken", houseBroken);
	}
	
	public Boolean getHouseBroken() {
		return getBoolean("houseBroken");
	}
	
	//name
	public void setName(String Name) {
		put("name", Name);
	}
	
	public String getName() {
		return getString("name");
	}
	
	//rating
	public void setRating(int rating) {
		put("rating", rating);
	}
	
	public int getRating() {
		return getInt("rating");
	}
	
	//socialized
	public void setSocialized(Boolean socialized) {
		put("socialized", socialized);
	}
	
	public Boolean getSocialized() {
		return getBoolean("socialized");
	}
	
	//spayedNeutered
	public void setSpayedNeutered(Boolean spayedNeutered) {
		put("houseBroken", spayedNeutered);
	}
	
	public Boolean getSpayedNeutered() {
		return getBoolean("spayedNeutered");
	}
	
	//description
	public void setDescription(String description) {
		put("description", description);
	}
	
	public String getDescription() {
		return getString("description");
	}
	
	public void getPet(String id) {
		ParseQuery<Pet> query = ParseQuery.getQuery(Pet.class);
		query.getInBackground(id, new GetCallback<Pet>() {
			
			@Override
			public void done(Pet arg0, ParseException e) {
				if(e == null) {
					//got the pet
				}
				else {
					//throw some exception
				}
			}
		});	
	}
}
