package com.petsitterfinder.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.petsitterfinder.R;
import com.petsitterfinder.adapter.SearchResultArrayAdapter;
import com.petsitterfinder.datamodel.PetSitter;

public class SitterSearchResult extends Activity {

	ArrayList<PetSitter> sitters;
	SearchResultArrayAdapter aaSearchResults;
	ListView lvResults;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_sitter_search_result);
		lvResults = (ListView) findViewById(R.id.lvResults);
		
		sitters = new ArrayList<PetSitter>();
		aaSearchResults = new SearchResultArrayAdapter(this, sitters);
		lvResults.setAdapter(aaSearchResults);
		
		PetSitter.getFilteredSitters(buildQuery(getIntent()), new FindCallback<PetSitter>() {
			
			@Override
			public void done(List<PetSitter> list, ParseException e) {
				if(e == null) {
					sitters.addAll(list);
					aaSearchResults.notifyDataSetChanged();
				}
			}
		});
		
		
		lvResults.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				Intent i = new Intent(SitterSearchResult.this, SitterProfileActivity.class);
				String sitterId = sitters.get(position).getId();
				i.putExtra("sitterId", sitterId);
				startActivity(i);
			}
		});
	}
	
	private ParseQuery<PetSitter> buildQuery(Intent i) {
		ParseQuery<PetSitter> query = ParseQuery.getQuery(PetSitter.class);
		if("true".equals(i.getStringExtra("houseCalls"))) {
			query.whereEqualTo("houseCalls", true);
		}
		return query;
	}
	
    public void showProgressBar() {
        setProgressBarIndeterminateVisibility(true); 
    }
    
    public void hideProgressBar() {
    	setProgressBarIndeterminateVisibility(false); 
    }
}
