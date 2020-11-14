package com.jtc.aprendemates;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Juego extends AppCompatActivity {
    Bundle b;
    Jugador j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        b = getIntent().getExtras();
        j = new Jugador(b.getString("nombre"), b.getString("dificultad"));

    }
}