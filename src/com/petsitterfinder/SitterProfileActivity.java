package com.petsitterfinder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.petsitterfinder.datamodel.PetSitter;

public class SitterProfileActivity extends Activity {

	TextView tvSitterName;
	TextView tvSitterCity;
	
	RatingBar rbSitterRating;
	CheckBox cbOverNight;
	CheckBox cbHouseCalls;

	TextView tvSitterDetails;
	ImageView ivSitterProfileImage;
	Button btnContact;
	PetSitter petSitter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sitter_profile);
		
		tvSitterName = (TextView) findViewById(R.id.tvSitterName);
		tvSitterCity = (TextView) findViewById(R.id.tvSitterCity);
		
		rbSitterRating = (RatingBar) findViewById(R.id.rbSitterRating);
		
		cbOverNight = (CheckBox) findViewById(R.id.cbOverNight);
		cbHouseCalls = (CheckBox) findViewById(R.id.cbHouseCalls);
		tvSitterDetails = (TextView) findViewById(R.id.tvSitterDetails);
		ivSitterProfileImage = (ImageView) findViewById(R.id.ivSitterProfileImage);
		btnContact = (Button) findViewById(R.id.btnContact);
		
		String sitterId = getIntent().getStringExtra("sitterId");
		
		PetSitter.getPetSitter(sitterId, new GetCallback<PetSitter>() {
			@Override
			public void done(PetSitter sitter, ParseException e) {
				if(e == null) {
					petSitter = sitter;
					
					tvSitterName.setText(petSitter.getName());
					tvSitterCity.setText(petSitter.getCity());
					
					rbSitterRating.setRating(petSitter.getRating());
					cbOverNight.setChecked(petSitter.getOverNight());
					cbHouseCalls.setChecked(petSitter.getHouseCalls());
					
					tvSitterDetails.setText(petSitter.getDescription());
					if(petSitter.getProfileImgUrl() != null && petSitter.getProfileImgUrl() != "") {
						ImageLoader imgLoader = ImageLoader.getInstance();
						imgLoader.displayImage(petSitter.getProfileImgUrl(), ivSitterProfileImage);
					}
				}
				
			}
			
		});
		
	}
}
