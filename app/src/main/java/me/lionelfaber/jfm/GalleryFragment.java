package me.lionelfaber.jfm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



/**
 * Created by lionel on 31/5/17.
 */

public class GalleryFragment extends Fragment {

    Button photo, video;
    private static final String[] YOUTUBE_PLAYLISTS = {"PL1n2XkkFRzSjFS-iLetJMVM7iK0Kf8K_g",
            "PL1n2XkkFRzShgZK6lRRc63AarhLffNHKD"
    };
    private YouTube mYoutubeDataApi;
    private final GsonFactory mJsonFactory = new GsonFactory();
    private final HttpTransport mTransport = AndroidHttp.newCompatibleTransport();


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.galleryframe, parent, false);
    }




    public void onViewCreated(View view, Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setActionBarTitle("Gallery");

        getFragmentManager().beginTransaction()
                .replace(R.id.container, new AlbumListFragment())
                .commit();


        photo = view.findViewById(R.id.imageButton);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction()
                        .replace(R.id.container, new AlbumListFragment())
                        .commit();

            }
        });

        video = view.findViewById(R.id.videoButton);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mYoutubeDataApi = new YouTube.Builder(mTransport, mJsonFactory, null)
                        .setApplicationName(getResources().getString(R.string.app_name))
                        .build();

                getFragmentManager().beginTransaction()
                        .replace(R.id.container, YouTubeRecyclerViewFragment.newInstance(mYoutubeDataApi, YOUTUBE_PLAYLISTS))
                        .commit();

            }
        });


    }
}
