package com.example.rahoolfood;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class LocationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_location, container, false);

        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_maps);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(@NonNull LatLng latLng) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title(latLng.latitude + " : " + latLng.longitude);
//                        googleMap.clear();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                latLng, 20
                        ));
                        googleMap.addMarker(markerOptions);
                    }
                });

                LatLng restoBambuDesa = new LatLng(-7.779997233468782, 110.3770220685589);
                googleMap.addMarker(new MarkerOptions().position(restoBambuDesa).title("Resto Bambu Desa"));

                LatLng BimosaurusCafe = new LatLng(-7.778657841421702, 110.37534837004678);
                googleMap.addMarker(new MarkerOptions().position(BimosaurusCafe).title("Bimosaurus Cafe"));

                LatLng MasayoshiResto = new LatLng(-7.778891703833384, 110.37979010840584);
                googleMap.addMarker(new MarkerOptions().position(MasayoshiResto).title("Masayoshi Resto"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(MasayoshiResto));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MasayoshiResto, 16));



//                LatLng sydney = new LatLng(-33.852, 151.211);
//                googleMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));
//                googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));
            }

        });
        return view;
    }
}