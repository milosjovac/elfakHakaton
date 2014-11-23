package com.example.hakatonapp.fragments;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.Card.OnSwipeListener;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hakatonapp.R;
import com.example.hakatonapp.StudyApplication;
import com.example.hakatonapp.activities.MainActivity;
import com.example.hakatonapp.view.CommentExpandCard;
import com.example.hakatonapp.view.CommentListView;

public class TeacherFragment extends Fragment {

	public static final String ARG_SECTION_NUMBER = "selection_number";
	ArrayList<Card> cards = new ArrayList<Card>();
	CardArrayAdapter mCardArrayAdapter;
	Card card;
	CommentListView list;

	CardHeader header;

	public static TeacherFragment newInstance(int position) {
		TeacherFragment fragment = new TeacherFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, position);
		fragment.setArguments(args);
		return fragment;
	}

	public TeacherFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_teach, container, false);
		list = (CommentListView) rootView;
		// Create a Card
		card = new Card(getActivity());

		// Create a CardHeader
		header = new CardHeader(getActivity());

		// Set the header title
		header.setTitle("#java #oop #gof");

		// Set visible the expand/collapse button
		header.setButtonExpandVisible(true);

		// Add Header to card
		card.addCardHeader(header);

		// This provides a simple (and useless) expand area
		CommentExpandCard expand = new CommentExpandCard(getActivity(), list);
		

		// Set inner title in Expand Area
		expand.setTitle("23 komentara");

		card.addCardExpand(expand);

		cards.add(card);
		mCardArrayAdapter = new CardArrayAdapter(getActivity(), cards);

		if (list != null) {
			list.setAdapter(mCardArrayAdapter);
		}

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));

	}

	public static CharSequence getTitle() {
		return StudyApplication.getContext().getString(R.string.title_section1);
	}
}
