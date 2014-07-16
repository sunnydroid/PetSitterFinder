package com.petsitterfinder;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.parse.Parse;
import com.parse.ParseObject;
import com.petsitterfinder.datamodel.Pet;
import com.petsitterfinder.datamodel.PetSitter;
import com.petsitterfinder.datamodel.User;

public class PetSitterFinderApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		registerParseClasses();
		initializeParseKeys();
		loadImageLoader();
	}

	private void loadImageLoader() {
		// Create global configuration and initialize ImageLoader with this configuration
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
        		cacheInMemory().cacheOnDisc().build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
            .defaultDisplayImageOptions(defaultOptions)
            .build();
        ImageLoader.getInstance().init(config);
		
	}

	private void registerParseClasses() {
		ParseObject.registerSubclass(User.class);
		ParseObject.registerSubclass(Pet.class);
		ParseObject.registerSubclass(PetSitter.class);
	}

	private void initializeParseKeys() {
		Parse.initialize(
				this, 
				"ZHEazyg0WNgacD1MR5X7IN4oS0UyRdAb5Ucc1ARe",
				"0KnYEVv6ogyYWuW6zTXgv5vhPO4M6Ids8vhm77jC");
	}

}
