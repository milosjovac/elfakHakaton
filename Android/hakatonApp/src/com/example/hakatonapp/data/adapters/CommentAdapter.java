package com.example.hakatonapp.data.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hakatonapp.R;
import com.example.hakatonapp.model.Comment;

public class CommentAdapter extends BaseAdapter {

	ArrayList<Comment> data;
	private LayoutInflater inflater;

	public CommentAdapter(Context ctx) {
		data = new ArrayList<Comment>();
		inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = inflater.inflate(R.layout.comment_item, parent, false);

		return convertView;
	}

	public void setData(ArrayList<Comment> data) {
		this.data = data;
		notifyDataSetChanged();
	}

	@Override
	public boolean isEnabled(int position) {

		// ne zelim da se bilo sta klikce. Lista nije selekcija samo prezentacija.
		return false;
	}

}
