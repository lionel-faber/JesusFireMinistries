package me.lionelfaber.jfm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static me.lionelfaber.jfm.R.id.imageView;


/**
 * Created by lionel on 31/5/17.
 */

public class ScheduleFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<Event> eventList;
    LinearLayoutManager layoutManager;
    EventAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.scheduleframe, parent, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setActionBarTitle("Schedule");
        ImageView imageView = (ImageView)view.findViewById(R.id.expandedImage);
        Glide.with(getActivity()).load(R.drawable.schedulee).into(imageView);


        eventList = new ArrayList<>();

        recyclerView = (RecyclerView)view.findViewById(R.id.schedule_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        Event event = new Event("Sunday Service", "Time : IST 08:30 am to 12:30 pm\n" +
                "Place : ACA Injambakkam, East Coast Road, Chennai.\n\n" +
                "We whole-heartedly welcome you and your family on joining us " +
                "in praising our Lord and Saviour Jesus Christ.");
        eventList.add(event);

        event = new Event("Tuesday Bible Study", "Time : IST 06:30 pm to 08:00 pm\n" +
                "Every tuesday we meditate on the word of the Lord and get " +
                "teachings and revelations on God’s word.");
        eventList.add(event);

        event = new Event("Wednesday Men’s Fellowship", "On Wednesday nights all men gather and worship the Lord and " +
                "also pray for various needs.");
        eventList.add(event);

        event = new Event("Friday Women’s Fellowship", "Time : IST 10:00 am to 01:00 pm\n" +
                "Fridays are an important day for all the women in our church as " +
                "they come to the Lord’s presence for receiving his divine touch.");
        eventList.add(event);

        event = new Event("Saturday Fasting Prayer", "Time : IST 10:00 am to 02:00 pm\n" +
                "\n" +
                "Every Saturday we gather as a church and we fast and pray " +
                "for all our needs. The Lord answers all our prayers.");
        eventList.add(event);

        event = new Event("Note", "- The Holy Communion Service will take place every 2nd sunday.\n" +
                "- The Promise Service will take place on the 1st of every month. " +
                "(IST 05:00 am - 07:00am)\n" +
                "- You can also watch our service every sunday live in Facebook, " +
                "Youtube and www.jesusfireministries.tv\n" +
                "- All the above mentioned prayers and gatherings will take place " +
                "at our church");
        eventList.add(event);

        event = new Event("Church Address: No.1/110, East Coast Road, Injambakkam, " +
                "Chennai - 600 041.", "For any information, contact 9884422235 / 9789919963");
        eventList.add(event);

        adapter = new EventAdapter(getActivity(), eventList);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        recyclerView.setAdapter(adapter);

    }

    public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;

        public SimpleDividerItemDecoration(Context context) {
            mDivider = context.getResources().getDrawable(R.drawable.divider);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }
}
