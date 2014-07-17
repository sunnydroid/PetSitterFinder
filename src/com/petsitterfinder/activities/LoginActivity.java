package com.petsitterfinder.activities;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.PushService;
import com.petsitterfinder.R;
import com.petsitterfinder.datamodel.Pet;

public class LoginActivity extends Activity {

	EditText username;
	EditText password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_login);
		setupView();
	}

	private void setupView() {
		username = (EditText) findViewById(R.id.etUsername);
		password = (EditText) findViewById(R.id.etPassword);
	}

	public void login(View v) {
		showProgressBar();
		ParseUser.logInInBackground(username.getText().toString(), password
				.getText().toString(), new LogInCallback() {

			@Override
			public void done(ParseUser user, ParseException e) {
				if (user != null) {
					setupSubscriptionChannel(user);
					findPetForUser(user);
				} else {
					Toast.makeText(getApplicationContext(),
							"Login Failure " + e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void findPetForUser(ParseUser pUser) {
		/* get pet id associated with the user */
		ParseQuery<Pet> query = ParseQuery.getQuery("Pet");
		query.whereEqualTo("pUser", pUser);
		query.getFirstInBackground(new GetCallback<Pet>() {

			@Override
			public void done(Pet pet, ParseException pe) {
				if (pet != null) {
					showPetProfile(pet.getObjectId());
				} else {
					Log.d("Error",
							"Error finding pet for user => " + pe.getMessage());
				}

			}
		});

	}

	private void setupSubscriptionChannel(ParseUser user) {
		Set<String> subscriptionChannels = PushService
				.getSubscriptions(getApplicationContext());
		/* If user's channel is not added, add it */
		String userChannel = user.getObjectId();
		if (!subscriptionChannels.contains(userChannel)) {
			PushService.subscribe(getApplicationContext(), userChannel,
					NotificationActivity.class);
		}
	}

	private void showPetProfile(String petId) {
		hideProgressBar();
		Intent i = new Intent(this, ProfileActivity.class);
		i.putExtra("petId", petId);
		i.putExtra("mode", "View");
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

	public void showProgressBar() {
		setProgressBarIndeterminateVisibility(true);
	}

	public void hideProgressBar() {
		setProgressBarIndeterminateVisibility(false);
	}
}
