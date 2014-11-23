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
import android.os.AsyncTask;


public class LoginActivity extends Activity 
{
	private class LoginAsyncTask extends AsyncTask<Profile, Void, JSONObject>
	{
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
