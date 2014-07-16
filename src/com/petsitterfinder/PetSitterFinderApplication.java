package com.petsitterfinder;
import com.parse.Parse;
import com.parse.ParseObject;
import com.petsitterfinder.datamodel.PetSitter;
import com.petsitterfinder.datamodel.User;

import android.app.Application;

public class PetSitterFinderApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		initializeParseKeys();
		registerParseClasses();

	}

	private void registerParseClasses() {
		ParseObject.registerSubclass(User.class);
		ParseObject.registerSubclass(PetSitter.class);
	}

	private void initializeParseKeys() {
		Parse.initialize(
				this, 
				"ZHEazyg0WNgacD1MR5X7IN4oS0UyRdAb5Ucc1ARe",
				"0KnYEVv6ogyYWuW6zTXgv5vhPO4M6Ids8vhm77jC");
	}

}
