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

import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static me.lionelfaber.jfm.R.id.imageView;


/**
 * Created by lionel on 31/5/17.
 */

public class TestimonialFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Testimonial> testimonials;
    LinearLayoutManager layoutManager;
    TestimonialAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.testimonialframe, parent, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setActionBarTitle("Testimonials");

        testimonials = new ArrayList<>();

        recyclerView = (RecyclerView)view.findViewById(R.id.test_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        Testimonial testimonial = new Testimonial("Sister Jaya Ravi", "Chennai", "I was troubled with lung cancer for a long period. I had taken a lot of treatments but it did not give me " +
                "any relief from the agony of disease. I prayed with Pastor Robinson with faith in the name of Jesus and " +
                "the Lord rewarded my faith as now I am fully healed from cancer. All glory to God alone!", "female");

        testimonials.add(testimonial);

        testimonial = new Testimonial("Sister Anita Minz", "Jharkhand", "I had two children who were crippled and bed ridden; they could not talk nor walk. I had attended the " +
                "healing crusade of Pastor Robinson in Ranchi, and I beleived God had healed my children. When I went " +
                "back hom from the meeting my both children were walking and talking. All Praise and glory to our Lord " +
                "Jesus Christ!", "female");

        testimonials.add(testimonial);

        testimonial = new Testimonial("Brother Don Bosco", "Chennai", "Me and my wife were married in the year 1993. Since then we did not have children. We spoke to " +
                "Pastor about our problem and Pastor prayed for us and prophesized that God will surely bless us with a " +
                "child. We had faith and believed the word of the Lord. Now after 18 years of marriage God has blessed " +
                "us with a Boy and he has made his word come to pass. All glory to God!", "male");

        testimonials.add(testimonial);

        testimonial = new Testimonial("Brother Sasi", "Chennai", "I was suffering from mental depression for the past 5 years. I got separated from my wife and lived in " +
                "darkness. In this condition people brought to the church and God has healed me completely and " +
                "miraculously. Today God has restored my health, job and family. Praise be to God!", "male");

        testimonials.add(testimonial);

        adapter = new TestimonialAdapter(getActivity(), testimonials);
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
