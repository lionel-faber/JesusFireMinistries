package me.lionelfaber.jfm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.bumptech.glide.Glide.with;
import static me.lionelfaber.jfm.R.id.imageView;


/**
 * Created by lionel on 31/5/17.
 */

public class AboutFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.aboutframe, parent, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {

        ((MainActivity) getActivity()).setActionBarTitle("About Us");
        TextViewEx textViewEx1 = (TextViewEx)view.findViewById(R.id.about_content);
        textViewEx1.setText(getResources().getString(R.string.content), true);

        TextViewEx textViewEx2 = (TextViewEx)view.findViewById(R.id.vision_content);
        textViewEx2.setText(getResources().getString(R.string.vision), true);

        TextViewEx textViewEx3 = (TextViewEx)view.findViewById(R.id.mission_content);
        textViewEx3.setText(getResources().getString(R.string.mission), true);

        ImageView pastor = (ImageView) view.findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.pastorr).override(200, 200).into(pastor);
    }


}
