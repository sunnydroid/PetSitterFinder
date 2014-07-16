package com.petsitterfinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.petsitterfinder.R;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}
	
	public void onPetSelected(View v) {
		Intent i = new Intent(this, ProfileActivity.class);
		i.putExtra("petId", "KcwGD533Pj");
		i.putExtra("mode", "Edit");
		startActivity(i);
	}
	
	public void onSeachSitters(View v) {
		Intent i = new Intent(this, SitterSearchResult.class);
		i.putExtra("houseCalls", "true");
		startActivity(i);
	}
}
