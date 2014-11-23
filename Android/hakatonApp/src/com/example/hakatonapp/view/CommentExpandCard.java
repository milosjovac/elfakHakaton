package com.example.hakatonapp.view;

import it.gmariotti.cardslib.library.internal.CardExpand;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hakatonapp.R;
import com.example.hakatonapp.data.adapters.CommentAdapter;
import com.example.hakatonapp.model.Comment;

public class CommentExpandCard extends CardExpand {

	CommentAdapter adapter;
	public ListView list;
	Context ctx;
	private CommentListView parentList;

	public CommentExpandCard(Context context, CommentListView parentList) {
		super(context, R.layout.card_comment);
		ctx = context;
		this.parentList = parentList;
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		adapter = new CommentAdapter(ctx);
		list = (ListView) parent.findViewById(R.id.comment_list);

		parentList.addViewThatWantTouch(list);
		list.setAdapter(adapter);

		// set dummy data for now
		ArrayList<Comment> comments = new ArrayList<Comment>();

		for (int i = 0; i < 10; i++) {
			comments.add(new Comment("username", "", "comment comment aslkdj laksjd aslj "));
		}

		adapter.setData(comments);

	}

}
