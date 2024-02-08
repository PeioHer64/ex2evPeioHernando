package com.example.ex2evpeiohernando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pageMapaRealButton = findViewById(R.id.buttonIrAMapa);

        Intent PageMapaReal = new Intent(this, MapaRealEx.class);

        //boton de inicio para ir a al activity principal de la applicacion
        pageMapaRealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(PageMapaReal);
            }
        });













    }
}