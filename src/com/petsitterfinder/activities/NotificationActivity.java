package com.petsitterfinder.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.petsitterfinder.R;

public class NotificationActivity extends Activity {

	TextView notification;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		initView();
		String jsonNotification = getIntent().getExtras().getString("com.parse.Data");
		notification.setText(jsonNotification);
	}
	
	public void onAccept(View v) {
		
	}
	
	public void onReject(View v) {
		
	}
	
	private void initView() {
		notification = (TextView) findViewById(R.id.tvNotificationMessage);
	}
}
