package com.petsitterfinder.datamodel;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("PetSitter")
public class PetSitter extends ParseObject {

	public PetSitter() {
		super();
	}
	
	//city
	public void setAge(int age) {
		put("age", age);
	}
	
	public int getAge() {
		return getInt("age");
	}
	
	//houseCalls
	public void setHouseCalls(Boolean houseCalls) {
		put("houseCalls", houseCalls);
	}
	
	public Boolean getHouseCalls() {
		return getBoolean("houseCalls");
	}
	
	//name
	public void setName(String Name) {
		put("name", Name);
	}
	
	public String getName() {
		return getString("name");
	}
	
	//overNight
	public void setOverNight(Boolean overNight) {
		put("houseBroken", overNight);
	}
	
	public Boolean getOverNight() {
		return getBoolean("overNight");
	}
	
	//profileImgUrl
	public void setProfileImgUrl(String profileImgUrl) {
		put("profileImgUrl", profileImgUrl);
	}
	
	public String getProfileImgUrl() {
		return getString("profileImgUrl");
	}
	
	//rating
	public void setRating(int rating) {
		put("rating", rating);
	}
	
	public int getRating() {
		return getInt("rating");
	}
	
	//zip
	public void setZip(int zip) {
		put("zip", zip);
	}
	
	public int getZip() {
		return getInt("zip");
	}
	
	//description
	public void setDescription(String description) {
		put("description", description);
	}
	
	public String getDescription() {
		return getString("description");
	}
	
	
	public static void getPetSitter(String id, GetCallback<PetSitter> callback) {
		ParseQuery<PetSitter> query = ParseQuery.getQuery(PetSitter.class);
		query.getInBackground(id, callback);	
	}
	
	public static void getFilteredSitters(ParseQuery<PetSitter> query, FindCallback<PetSitter> callback) {
		query.findInBackground(callback);
	}
}
