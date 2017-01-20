package com.josip.acer.pulaplusaplikacija;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class znam extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map2;
    private LatLng currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_znam);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map2 = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng pula = new LatLng(44.870138, 13.841865);
        LatLng pula1 = new LatLng(44.873192, 13.850203);

        LatLng pula2 = new LatLng(44.872398, 13.847282);
        LatLng pula3 = new LatLng(44.870107, 13.846993);
        LatLng pula4 = new LatLng(44.870367, 13.847587);
        map2.addMarker(new MarkerOptions().position(pula).title("AUGUSTOV HRAM, HRVATSKA")).showInfoWindow();
        map2.addMarker(new MarkerOptions().position(pula1).title("ARENA PULA, HRVATSKA")).showInfoWindow();
        map2.addMarker(new MarkerOptions().position(pula2).title("TITOV PARK, HRVATSKA")).showInfoWindow();
        map2.addMarker(new MarkerOptions().position(pula3).title("RIMSKO KAZALISTE, HRVATSKA")).showInfoWindow();
        map2.addMarker(new MarkerOptions().position(pula4).title("ARHEOLOSKI MUZEJ ISTRE, HRVATSKA")).showInfoWindow();
        float zoomLevel = (float) 15.0; //This goes up to 21
        map2.moveCamera(CameraUpdateFactory.newLatLngZoom(pula, zoomLevel));
  
    }


}
