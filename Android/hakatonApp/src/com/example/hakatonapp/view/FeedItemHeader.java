package com.example.hakatonapp.view;

import it.gmariotti.cardslib.library.internal.CardHeader;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hakatonapp.R;

public class FeedItemHeader extends CardHeader {

	public FeedItemHeader(Context context) {
		super(context, R.layout.item_header);

	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		if (view!=null){
            TextView t1 = (TextView) view.findViewById(R.id.item_header_title);
//            if (t1!=null)
//                t1.setText(getContext().getString(R.string.ite));

            TextView t2 = (TextView) view.findViewById(R.id.item_header_tags);
			// if (t2!=null)
			//     t2.setText(getContext().getString(R.string.demo_header_exampletitle2));
        }
	}
}
