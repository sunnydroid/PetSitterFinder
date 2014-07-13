package com.petsitterfinder;
import com.parse.Parse;

import android.app.Application;

public class PetSitterFinderApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		initializeParseKeys();
		registerParseClasses();

	}

	private void registerParseClasses() {

	}

	private void initializeParseKeys() {
		Parse.initialize(
				this, 
				"ZHEazyg0WNgacD1MR5X7IN4oS0UyRdAb5Ucc1ARe",
				"0KnYEVv6ogyYWuW6zTXgv5vhPO4M6Ids8vhm77jC");
	}

}
