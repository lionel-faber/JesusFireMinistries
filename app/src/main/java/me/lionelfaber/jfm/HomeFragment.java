package me.lionelfaber.jfm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static me.lionelfaber.jfm.R.id.imageView;


/**
 * Created by lionel on 31/5/17.
 */

public class HomeFragment extends Fragment {

    String url;
    RecyclerView recyclerView;
    ArrayList<ImageLink> linkList;
    LinearLayoutManager layoutManager;
    HomeAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.homeframe, parent, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setActionBarTitle("Jesus Fire Ministries");
        url = "http://jfm.pythonanywhere.com/api/get/images";
        linkList = new ArrayList<>();

        recyclerView = (RecyclerView)view.findViewById(R.id.home_recycler_view);
//        adapter = new HomeAdapter(getActivity(),linkList);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        if(isNetworkAvailable())
            sendRequest();
        loadStaticContent();

    }

    public void loadStaticContent()
    {
        ImageLink offline = new ImageLink("sample");
        linkList.add(offline);
        ImageLink imageLink = new ImageLink("livestream", "http://www.jesusfireministries.tv");
        linkList.add(imageLink);
        imageLink = new ImageLink("youtube", "https://www.youtube.com/channel/UCr38nJ4G8vDlyWSn_LWTZGg");
        linkList.add(imageLink);
        imageLink = new ImageLink("facebook", "https://www.facebook.com/jfm.jesusfireministries/");
        linkList.add(imageLink);
        adapter = new HomeAdapter(getActivity(), linkList);
        recyclerView.setAdapter(adapter);
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

                                String link = l.getString("link");
                                ImageLink imageLink = new ImageLink(link);
                                linkList.set(0, imageLink);
                            }

                            adapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

//                        hidepDialog();
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

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
