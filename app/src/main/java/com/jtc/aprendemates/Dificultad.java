package com.jtc.aprendemates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Dificultad extends AppCompatActivity {

    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad);
        nombre = savedInstanceState.getString("Nombre", "Tú");
    }
}