package com.example.hakatonapp.activities;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.example.hakatonapp.model.Profile;
import com.example.hakatonapp.util.Parser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hakatonapp.R;

import android.os.AsyncTask;

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

				// skloni ovaj Activity sa back stacka
				finish();
			}
		});
	}

	public class LoginAsyncTask extends AsyncTask<Profile, Void, JSONObject> {
		String serverUrl = "";

		@Override
		protected JSONObject doInBackground(Profile... params) {

			DefaultHttpClient httpClient = new DefaultHttpClient();

			HttpPost httpPost = new HttpPost(serverUrl + "/profile/" + params[0].getUsername());

			JSONObject data = Parser.createProfileJSON(params[0]);

			try {

				StringEntity stringEntity = new StringEntity(data.toString());
				httpPost.setEntity(stringEntity);

				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-type", "application/json");

				ResponseHandler responseHandler = new BasicResponseHandler();

				return httpClient.execute(httpPost, responseHandler);

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

	}
}
