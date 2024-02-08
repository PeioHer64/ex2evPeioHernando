package com.example.ex2evpeiohernando;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapaRealEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_real_ex);

        Button btnFragMapa = findViewById(R.id.buttonFragMapa);
        Button btnFragInfo = findViewById(R.id.buttonFragInfo);







        getSupportFragmentManager().beginTransaction()
                .replace(R.id.idFragmentMap, new MapaReal7Fragment())
                .commit();

        //fragmentTransaction.commit();



        btnFragInfo.setVisibility(View.VISIBLE);
        btnFragMapa.setVisibility(View.INVISIBLE);





        btnFragInfo.setOnClickListener(v -> {
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            Fragment fragment = fragmentManager.findFragmentById(R.id.idFragmentMap);


            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment fragment = fragmentManager.findFragmentById(R.id.idFragmentMap);

            Fragment nuevoFragment = null;
            if (fragment instanceof InfoFragment1) {
                nuevoFragment = new InfoFragment1();
            } else if (fragment instanceof MapaReal7Fragment) {
                nuevoFragment = new InfoFragment1();
            }

            assert nuevoFragment != null;
            fragmentTransaction.replace(R.id.idFragmentMap, nuevoFragment);
            fragmentTransaction.commit();

            btnFragInfo.setVisibility(View.INVISIBLE);
            btnFragMapa.setVisibility(View.VISIBLE);
        });


        btnFragMapa.setOnClickListener(v -> {
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            Fragment fragment = fragmentManager.findFragmentById(R.id.idFragmentMap);


            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment fragment = fragmentManager.findFragmentById(R.id.idFragmentMap);

            Fragment nuevoFragment = null;
            if (fragment instanceof InfoFragment1) {
                nuevoFragment = new MapaReal7Fragment();
            } else if (fragment instanceof MapaReal7Fragment) {
                nuevoFragment = new MapaReal7Fragment();
            }

            assert nuevoFragment != null;
            fragmentTransaction.replace(R.id.idFragmentMap, nuevoFragment);
            fragmentTransaction.commit();

            btnFragMapa.setVisibility(View.INVISIBLE);
            btnFragInfo.setVisibility(View.VISIBLE);
        });





    }
}