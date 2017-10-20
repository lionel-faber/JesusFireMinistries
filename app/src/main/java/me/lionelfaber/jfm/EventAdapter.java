package me.lionelfaber.jfm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lionel on 20/10/17.
 */


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{

    private ArrayList<Event> events;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, content;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.event_header);
            content = (TextView) view.findViewById(R.id.event_content);
        }
    }

    public EventAdapter(Context context,ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_row, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        holder.title.setText(events.get(i).getHeader());
        holder.content.setText(events.get(i).getContent());
    }


    @Override
    public int getItemCount() {
        return events.size();
    }


}
