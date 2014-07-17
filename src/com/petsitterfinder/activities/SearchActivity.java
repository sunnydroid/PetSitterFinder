package com.petsitterfinder.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.parse.ParseException;
import com.parse.ParseQuery;
import com.petsitterfinder.R;
import com.petsitterfinder.datamodel.PetSitter;

public class SearchActivity extends Activity {

	EditText zip;
	RadioButton radius;
	DatePicker startDate;
	DatePicker endDate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
	}
	
	public void onSearch(View v) {
		Intent i = new Intent(this, SitterSearchResult.class);
		startActivity(i);
 	}
	
	private void setupViews() {
		zip = (EditText) findViewById(R.id.etZipSearch);
		RadioGroup rg = (RadioGroup) findViewById(R.id.rgSearchRadius);
		radius = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
		startDate = (DatePicker) findViewById(R.id.dpStartDate);
		endDate = (DatePicker) findViewById(R.id.dpEndDate);
	}
	
	private void executeSearch() throws ParseException {
		ParseQuery<PetSitter> parseQuery = ParseQuery.getQuery(PetSitter.class);
		List<PetSitter> petSitters = parseQuery.find();
		for(PetSitter sitter : petSitters) {			
			Log.d("info" , sitter.toString());
		}
	}
}
