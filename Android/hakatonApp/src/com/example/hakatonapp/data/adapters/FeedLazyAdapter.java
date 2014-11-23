package com.example.hakatonapp.data.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hakatonapp.StudyApplication;
import com.example.hakatonapp.model.Feed;

public class FeedLazyAdapter extends BaseAdapter {

	@Override
	public int getCount() {
		return StudyApplication.globalBank.getFeed().size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

	public Feed getData() {
		return StudyApplication.globalBank.getFeed();
	}
}
