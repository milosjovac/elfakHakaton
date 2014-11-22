package com.example.hakatonapp.model;

public class Feed {

	public Feed() {

	}

	/** Get current size of feed elements. Is expended by lazy load */
	public int size() {
		return 1;
	}

	public FeedItem getFeedItem(int position) {
		return null;
	}
}
