package me.lionelfaber.jfm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static me.lionelfaber.jfm.R.id.imageView;


/**
 * Created by lionel on 31/5/17.
 */

public class ContactFragment extends Fragment implements OnMapReadyCallback{

    MapView mapView;
    GoogleMap map;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.contactframe, parent, false);

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setActionBarTitle("Connect with us");

        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        MapsInitializer.initialize(getActivity());


    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(12.920290, 80.251283))
                .title("Jesus Fire Minitries"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(12.920290, 80.251283), 15));
    }
}
