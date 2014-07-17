package com.petsitterfinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParsePush;
import com.petsitterfinder.R;

public class MessageActivity extends Activity {

	EditText messageBox;
	TextView recipient;
	String userChannel;
	String userName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		userChannel = getIntent().getStringExtra("userId");
		userName = getIntent().getStringExtra("userName");
		initView();
	}
	
	public void onSendMessage(View view) {
		String message = messageBox.getText().toString();
		sendMessage(userChannel, message);
		Intent i = new Intent();
		setResult(RESULT_OK, i);
		Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
		finish();
	}
	
	private void sendMessage(String channel, String message) {
		ParsePush push = new ParsePush();
		push.setChannel(channel);
		push.setMessage(message);
		push.sendInBackground();
	}
	
	private void initView() {
		messageBox = (EditText) findViewById(R.id.etMessage);
		recipient = (TextView) findViewById(R.id.tvRecipent);
		recipient.setText(userName);
	}
}
