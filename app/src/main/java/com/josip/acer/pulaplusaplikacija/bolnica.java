package com.josip.acer.pulaplusaplikacija;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class bolnica extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolnica);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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
        map = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng pula = new LatLng(44.868056, 13.852942);
        LatLng pula1 = new LatLng(44.859491, 13.836893);
        map.addMarker(new MarkerOptions().position(pula1).title("MORNARIČKA BOLNICA, HRVATSKA"));
        map.addMarker(new MarkerOptions().position(pula).title("OPĆA BOLNICA PULA, HRVATSKA"));
        float zoomLevel = (float) 13.0; //This goes up to 21
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pula, zoomLevel));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pula1, zoomLevel));
    }


}


