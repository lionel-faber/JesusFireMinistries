package me.lionelfaber.jfm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by lionel on 6/12/17.
 */

public class AlbumListFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    String url;
    GalleryAdapter adapter;
    ArrayList<Album> albumList;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.albumlistfragment, parent, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        albumList = new ArrayList<>();
        recyclerView = (RecyclerView)view.findViewById(R.id.gallery_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        url = "http://192.168.43.231:8000/api/get/albums";
        sendRequest();
    }

    public void sendRequest()
    {
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                       Log.d("Response : ", response.toString());

                        try {
                            // Parsing json array response
                            // loop through each json object
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject l = (JSONObject) response.get(i);


                                String title = l.getString("title");
                                String date = l.getString("date");
                                String location = l.getString("location");
                                String cover = l.getString("cover");

                                //add condition to exclude main image
                                Album album = new Album(title, location, date, cover);
                                albumList.add(album);

                            }
                            adapter = new GalleryAdapter(getActivity(), albumList);
                            recyclerView.setAdapter(adapter);

                            adapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("VolleyError", "Error: " + error.getMessage());
                Toast.makeText(getActivity(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Adding request to request queue
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(req);
    }

}
