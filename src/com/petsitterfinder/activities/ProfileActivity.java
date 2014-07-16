package com.petsitterfinder.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.petsitterfinder.R;
import com.petsitterfinder.SearchActivity;

public class ProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
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
