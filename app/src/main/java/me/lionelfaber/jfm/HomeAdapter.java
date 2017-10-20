package me.lionelfaber.jfm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lionel on 18/10/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private ArrayList<ImageLink> links;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img_android;

        public ViewHolder(View view) {
            super(view);
            img_android = (ImageView)view.findViewById(R.id.home_row_image);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(getAdapterPosition() != 0) {
                Uri uri = Uri.parse(links.get(getAdapterPosition()).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

        }
    }

    public HomeAdapter(Context context,ArrayList<ImageLink> links) {
        this.context = context;
        this.links = links;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_row, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        if(i == 0)
            Picasso.with(context).load(links.get(i).getLink()).resize(650, 650).into(holder.img_android);
        else
            Glide.with(context).load(getImage(links.get(i).getLink())).override(500, 100).into(holder.img_android);
    }


    public int getImage(String imageName) {
        return context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
    }


    @Override
    public int getItemCount() {
        return links.size();
    }



}
