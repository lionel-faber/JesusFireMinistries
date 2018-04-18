package me.lionelfaber.jfm;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by lionel on 4/12/17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private ArrayList<Album> albums;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView cover;
        AppCompatTextView title, date, location;

        public ViewHolder(View view) {
            super(view);
            cover = view.findViewById(R.id.albumCover);
            title = view.findViewById(R.id.albumTitle);
            date = view.findViewById(R.id.albumDate);
            location = view.findViewById(R.id.albumLocaiton);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // open gallery activity
            context.startActivity(new Intent(context, GalleryActivity.class));
            }

        }

    public GalleryAdapter(Context context,ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_row, viewGroup, false);
        return new GalleryAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(GalleryAdapter.ViewHolder holder, int i) {
            Picasso.with(context).load(albums.get(i).getCover()).into(holder.cover);
            holder.title.setText(albums.get(i).getTitle());
            holder.date.setText(albums.get(i).getDate());
            holder.location.setText(albums.get(i).getLocation());
    }


    @Override
    public int getItemCount() {
        return albums.size();
    }

}
