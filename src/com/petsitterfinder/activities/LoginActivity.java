package com.petsitterfinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.petsitterfinder.R;
import com.petsitterfinder.datamodel.User;

public class LoginActivity extends Activity {
	
	EditText username;
	EditText password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setupView();
	}
	
	private void setupView() {
		username = (EditText) findViewById(R.id.etUsername);
		password = (EditText) findViewById(R.id.etPassword);
	}
	
	public void login(View v) {
		ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
			
			@Override
			public void done(ParseUser user, ParseException e) {
				if(user != null) {					
					showUserProfile(user);
				} else {
					Toast.makeText(getApplicationContext(), "Login Failure " + e.getMessage(), Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	private void showUserProfile(ParseUser pUser) {
		Intent i = new Intent(this, ProfileActivity.class);
		User user = new User(pUser);
		i.putExtra("pUser", user);
		startActivity(i);
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
