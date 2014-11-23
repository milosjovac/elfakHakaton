package com.example.hakatonapp.view;

import com.example.hakatonapp.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import it.gmariotti.cardslib.library.internal.Card;

public class ItemCard extends Card {

	public ItemCard(Context context) {
		this(context, R.layout.item_card);
	}

	public ItemCard(Context context, int innerLayout) {
		super(context, innerLayout);
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		super.setupInnerViewElements(parent, view);
	}

}
