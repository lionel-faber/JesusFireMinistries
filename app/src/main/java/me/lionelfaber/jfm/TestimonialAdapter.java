package me.lionelfaber.jfm;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by lionel on 20/10/17.
 */

public class TestimonialAdapter extends RecyclerView.Adapter<TestimonialAdapter.ViewHolder> {

    private ArrayList<Testimonial> testimonials;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, location, story;
        ImageView icon;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tname);
            location = (TextView) view.findViewById(R.id.tcity);
            story = (TextView) view.findViewById(R.id.tstory);
            icon = (ImageView) view.findViewById(R.id.test_icon);
        }
    }

    public TestimonialAdapter(Context context, ArrayList<Testimonial> testimonials) {
        this.context = context;
        this.testimonials = testimonials;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.test_row, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        holder.name.setText(testimonials.get(i).getName());
        holder.location.setText(testimonials.get(i).getCity());
        holder.story.setText(testimonials.get(i).getTestimonial());
        if(testimonials.get(i).getGender().equals("female"))
            Glide.with(context).load(R.drawable.female).into(holder.icon);
        else
            Glide.with(context).load(R.drawable.male).into(holder.icon);

    }


    @Override
    public int getItemCount() {
        return testimonials.size();
    }

}
