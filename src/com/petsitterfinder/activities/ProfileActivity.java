package com.petsitterfinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.petsitterfinder.R;
import com.petsitterfinder.SearchActivity;
import com.petsitterfinder.datamodel.Pet;

public class ProfileActivity extends Activity {

	TextView tvPetName;
	TextView tvPetBreed;
	TextView tvAge;
	RatingBar rbPetRating;
	CheckBox cbHouseBroken;
	CheckBox cbSpayed;
	CheckBox cbBasicCommands;
	CheckBox cbAggressive;
	TextView tvPetDetails;
	ImageView ivProfileImage;
	Button btnSubmit;
	Pet myPet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		tvPetName = (TextView) findViewById(R.id.tvPetName);
		tvPetBreed = (TextView) findViewById(R.id.tvPetBreed);
		tvAge = (TextView) findViewById(R.id.tvAge);
		rbPetRating = (RatingBar) findViewById(R.id.rbPetRating);
		cbHouseBroken = (CheckBox) findViewById(R.id.cbHouseBroken);
		cbSpayed = (CheckBox) findViewById(R.id.cbSpayed);
		cbBasicCommands = (CheckBox) findViewById(R.id.cbBasicCommands);
		cbAggressive = (CheckBox) findViewById(R.id.cbAggressive);
		tvPetDetails = (TextView) findViewById(R.id.tvPetDetails);
		ivProfileImage = (ImageView) findViewById(R.id.ivProfileImage);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		
		String petId = getIntent().getStringExtra("petId");
		String mode = getIntent().getStringExtra("mode");
		
		Pet.getPet(petId, new GetCallback<Pet>() {

			@Override
			public void done(Pet pet, ParseException e) {
				if(e == null) {
					myPet = pet;
					tvPetName.setText(pet.getName());
					tvPetBreed.setText(pet.getBreed());
					tvAge.setText(String.valueOf(pet.getAge()) + " year(s) old");
					rbPetRating.setRating(pet.getRating());
					cbHouseBroken.setChecked(pet.getHouseBroken());
					cbSpayed.setChecked(pet.getSpayedNeutered());
					cbBasicCommands.setChecked(pet.getBasicTraining());
					cbAggressive.setChecked(pet.getSocialized());
					tvPetDetails.setText(pet.getDescription());
					if(pet.getProfileImgUrl() != null && pet.getProfileImgUrl() != "") {
						ImageLoader imgLoader = ImageLoader.getInstance();
						imgLoader.displayImage(pet.getProfileImgUrl(), ivProfileImage);
					}
				}
			}
		});
		
		if ("View".equals(mode)) {
			
			cbHouseBroken.setClickable(false);
			cbSpayed.setClickable(false);
			cbBasicCommands.setClickable(false);
			cbAggressive.setClickable(false);
			rbPetRating.setClickable(false);
			btnSubmit.setVisibility(View.INVISIBLE);
			
		} else if ("Edit".equals(mode)) {
			
			cbHouseBroken.setClickable(true);
			cbSpayed.setClickable(true);
			cbBasicCommands.setClickable(true);
			cbAggressive.setClickable(true);
			rbPetRating.setClickable(true);
			rbPetRating.setEnabled(true);
			rbPetRating.setActivated(true);
			btnSubmit.setVisibility(View.VISIBLE);
			
			cbHouseBroken.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
						myPet.setHouseBroken(isChecked);
				}
			});
			
			cbSpayed.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
						myPet.setSpayedNeutered(isChecked);
				}
			});
			
			cbBasicCommands.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
						myPet.setBasicTraining(isChecked);
				}
			});
			
			cbAggressive.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
						myPet.setSocialized(isChecked);
				}
			});
			
		}
	}
	
	public void onSubmit(View v) {
		myPet.saveInBackground();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_item, menu);
		return true;
	}
	
	public void onSearch(MenuItem mi) {
		Intent i = new Intent(this, SearchActivity.class);
		startActivity(i);
	}
}
