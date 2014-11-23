package com.example.hakatonapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hakatonapp.R;

public class LoginActivity extends Activity {

	View button;
	TextView txt;
	EditText username;
	EditText password;;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		button = findViewById(R.id.login);
		txt = (TextView) findViewById(R.id.login_text);
		username = (EditText) findViewById(R.id.login_email);
		password = (EditText) findViewById(R.id.login_pass);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// CIMAJ SERVER
				String user = username.getText().toString();
				String pass = password.getText().toString();

				// ZA sad samo skoci na sledeci aktiviti
				button.setBackgroundColor(Color.parseColor("#ffffff"));
				txt.setTextColor(Color.parseColor("#000000"));
				startActivity(new Intent(LoginActivity.this, MainActivity.class));
			}
		});
	}
}
