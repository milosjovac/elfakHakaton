package com.example.hakatonapp.data.adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.commonsware.cwac.endless.EndlessAdapter;
import com.example.hakatonapp.R;
import com.example.hakatonapp.data.GlobalBank;
import com.example.hakatonapp.model.Feed;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class StudyEndlessAdapter extends EndlessAdapter {

	public static final int RESULTS_PER_LOAD = 8;

	private RotateAnimation rotate = null;
	private View pendingView = null;

	public int curPageNumber = 0;
	public int resNum = 0;
	public int maxPageNumber;

	public String errorMsg = "Nema rezultata";

	private String url;
	private String toastMsg;

	Activity ctx;

	// FLAG IF ASYNC_TASK SHOULD PICK UP SOME EXTRA DATA FROM URL
	private boolean isFirstRun = true;

	public StudyEndlessAdapter(Activity ctxt, String url) {
		super(FeedLazyAdapter(ctxt));

		this.url = url;
		ctx = ctxt;

		rotate = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		rotate.setDuration(700);
		rotate.setRepeatMode(Animation.INFINITE);
		rotate.setRepeatCount(Animation.INFINITE);
	}

	private static ListAdapter FeedLazyAdapter(Activity ctxt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected View getPendingView(ViewGroup parent) {
		View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.placeholder_row, parent, false);

		pendingView = row.findViewById(R.id.throbber);
		pendingView.setVisibility(View.VISIBLE);
		startProgressAnimation();

		return (row);
	}

	@Override
	protected void appendCachedData() {
		if (resNum == 0 && curPageNumber == 0) {
			Toast.makeText(ctx, errorMsg, Toast.LENGTH_LONG).show();
			// ON NO RESULT
		}
		FeedLazyAdapter a = (FeedLazyAdapter) getWrappedAdapter();
		a.notifyDataSetChanged();
	}

	// Reads an InputStream and converts it to a String.
	public static String readIt(InputStream stream) throws IOException, UnsupportedEncodingException {

		InputStream in = stream;
		InputStreamReader is = new InputStreamReader(in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read = br.readLine();

		while (read != null) {
			sb.append(read);
			read = br.readLine();
		}

		return sb.toString();
	}

	@Override
	protected boolean cacheInBackground() throws Exception {

		// ========================================================================================================
		// INCREMENTING CUR_PAGE_NUMBER
		// ========================================================================================================

		curPageNumber += 1;

		// ========================================================================================================
		// PARSE DOCUMENT FROM WEB
		// ========================================================================================================

		FeedLazyAdapter a = (FeedLazyAdapter) getWrappedAdapter();

		InputStream is = null;
		String res = null;
		try {

			URL urlLink = new URL(url + curPageNumber);
			HttpURLConnection conn = (HttpURLConnection) urlLink.openConnection();
			conn.setReadTimeout(10000 /* milliseconds */);
			conn.setConnectTimeout(15000 /* milliseconds */);
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);

			// Starts the query
			conn.connect();
			is = conn.getInputStream();
			res = readIt(is);

		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			Log.d("Result form Keeva server", "The response is: " + "Server timeout. \nTry again.");
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("Exc: ", e.getMessage());
		} finally {
		}
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		JSONObject jObject = null;
		if (res != null && res != "")
			jObject = new JSONObject(res);
		else {
			// KeevaLogger.toast("Server je nedostupan", Toast.LENGTH_LONG);
			return false;
		}

		JSONArray jArray = jObject.getJSONArray("markers");
		for (int i = 0; i < jArray.length(); i++) {
			try {
				JSONObject oneObject = jArray.getJSONObject(i);
			} catch (Exception e) {

			}
		}

		if (curPageNumber < maxPageNumber)
			return true;
		return false;

	}

	void startProgressAnimation() {
		if (pendingView != null) {
			pendingView.startAnimation(rotate);
		}
	}

	public Feed getData() {
		FeedLazyAdapter a = (FeedLazyAdapter) getWrappedAdapter();
		return a.getData();
	}

}