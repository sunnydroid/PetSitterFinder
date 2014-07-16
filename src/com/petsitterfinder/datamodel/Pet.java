package com.petsitterfinder.datamodel;

import android.text.style.SuperscriptSpan;

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
	
	public Boolean getBasicTraining() {
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
	
	//profileImgUrl
	public void setProfileImgUrl(String profileImgUrl) {
		put("profileImgUrl", profileImgUrl);
	}
	
	public String getProfileImgUrl() {
		return getString("profileImgUrl");
	}
	
	public static void getPet(String id, GetCallback<Pet> callback) {
		ParseQuery<Pet> query = ParseQuery.getQuery(Pet.class);
		query.getInBackground(id, callback);	
	}
}
