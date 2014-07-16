package com.petsitterfinder.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.petsitterfinder.R;
import com.petsitterfinder.datamodel.PetSitter;

public class SitterSearchResult extends Activity {

	List<PetSitter> sitters;
	SearchResultArrayAdapter aaSearchResults;
	ListView lvResults;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sitter_search_result);
		
		lvResults = (ListView) findViewById(R.id.lvResults);
		
		sitters = new ArrayList<PetSitter>();
		aaSearchResults = new SearchResultArrayAdapter(this, sitters);
		lvResults.setAdapter(aaSearchResults);
		
		ParseQuery <PetSitter> query = ParseQuery.getQuery(PetSitter.class);
		if("true".equals(getIntent().getStringExtra("houseCalls"))) {
			query.whereEqualTo("houseCalls", true);
		}
		
		PetSitter.getFilteredSitters(query, new FindCallback<PetSitter>() {

			@Override
			public void done(List<PetSitter> list, ParseException e) {
				if(e == null) {
					sitters.addAll(list);
					aaSearchResults.notifyDataSetChanged();
				}
			}
		});
	}
}
