package com.jtc.aprendemates;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dificultad extends AppCompatActivity {

    String nombre;
    Bundle bundle;
    Button facil, medio, dificil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        bundle = getIntent().getExtras();
        nombre = bundle.getString("nombre");

        facil = findViewById(R.id.btFacil);
        medio = findViewById(R.id.btMedio);
        dificil = findViewById(R.id.btDificl);

        facil.setOnClickListener(v -> onClickDificulad(Level.EASY));
        medio.setOnClickListener(v -> onClickDificulad(Level.MEDIUM));
        dificil.setOnClickListener(v -> onClickDificulad(Level.HARD));
    }

    void onClickDificulad(Level i) {
        Intent intent = new Intent(this, Game.class);
        Bundle b = new Bundle();
        b.putString("nombre", nombre);
        b.putString("dificultad", i.name());
        intent.putExtras(b);
        startActivity(intent);
    }
}