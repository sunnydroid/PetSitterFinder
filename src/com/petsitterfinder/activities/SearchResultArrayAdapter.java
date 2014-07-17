package com.petsitterfinder.activities;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.petsitterfinder.R;
import com.petsitterfinder.SitterProfileActivity;
import com.petsitterfinder.datamodel.PetSitter;

public class SearchResultArrayAdapter extends ArrayAdapter<PetSitter> {

	ImageView ivProfileImage;
	TextView tvName, tvDescription;
	RatingBar rbResultRating;
	
	PetSitter petSitter;
	
	public SearchResultArrayAdapter(Context context,
			List<PetSitter> objects) {
		super(context, 0, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		if(convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			v = inflater.inflate(R.layout.search_result, parent, false);
		}
		else {
			v = convertView;
		}
		
		ivProfileImage = (ImageView) v.findViewById(R.id.ivProfileImage);
		tvName = (TextView) v.findViewById(R.id.tvName);
		tvDescription = (TextView) v.findViewById(R.id.tvDescription);	
		rbResultRating = (RatingBar) v.findViewById(R.id.rbResultRating);
		
		ivProfileImage.setImageBitmap(null);
		tvName.setText("");
		tvDescription.setText("");
		rbResultRating.setRating(0);
		
		petSitter = getItem(position);
		if(petSitter.getProfileImgUrl() != null && petSitter.getProfileImgUrl() != "") {
			ImageLoader imgLoader = ImageLoader.getInstance();
			imgLoader.displayImage(petSitter.getProfileImgUrl(), ivProfileImage);
		}
		
		tvName.setText(petSitter.getName());
		tvDescription.setText(petSitter.getDescription());
		rbResultRating.setRating(petSitter.getRating());
		
		v.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(getContext(), SitterProfileActivity.class);
				i.putExtra("sitterId", petSitter.getId());
				getContext().startActivity(i);
			}
		});
		
		return v;
	}

}
