package me.lionelfaber.jfm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static me.lionelfaber.jfm.R.id.imageView;


/**
 * Created by lionel on 31/5/17.
 */

public class PrayerRequests extends Fragment {

    EditText name, phone, message;
    String sName, sPhone, sMessage, url;
    Button send;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.prayerrequests, parent, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {


        ((MainActivity)getActivity()).setActionBarTitle("Prayer Requests");
        name = (EditText) view.findViewById(R.id.name);
        phone = (EditText) view.findViewById(R.id.phone_number);
        message = (EditText) view.findViewById(R.id.message);
        send = (Button) view.findViewById(R.id.sendrequest);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sName = name.getText().toString();
                sPhone = phone.getText().toString();
                sMessage = message.getText().toString();

                url = "http://192.168.43.231:8000/api/requestprayer";
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                                Log.d("Response", response);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Log.d("Error.Response", error.toString());
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("sender_name", sName);
                        params.put("prayer_request", sMessage);
                        params.put("phone_no", sPhone);

                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(postRequest);
            }
        });

    }
}
