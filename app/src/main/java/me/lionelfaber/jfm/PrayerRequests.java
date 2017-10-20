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

import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static me.lionelfaber.jfm.R.id.imageView;


/**
 * Created by lionel on 31/5/17.
 */

public class PrayerRequests extends Fragment {

    EditText name, phone, message;
    String sName, sPhone, sMessage;
    Button send;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.prayerrequests, parent, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {

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

                try {
                    GMailSender sender = new GMailSender("lionel1704@mail.com", "passwordhere");
                    sender.sendMail(sName + " - " + sPhone,
                            sMessage,
                            "lionel1704@gmail.com",
                            "14itsjit@gmail.com");
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });

    }
}
