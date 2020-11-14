package com.jtc.aprendemates;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dificultad extends AppCompatActivity {

    String nombre;
    Bundle bundle;
    Button facil,medio,dificil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad);
        bundle=getIntent().getExtras();
        nombre = bundle.getString("nombre");

        facil=findViewById(R.id.button2);
        medio=findViewById(R.id.button3);
        dificil=findViewById(R.id.button4);

        facil.setOnClickListener(v -> onClickDificulad(Nivel.FACIL));
        medio.setOnClickListener(v -> onClickDificulad(Nivel.MEDIO));
        dificil.setOnClickListener(v -> onClickDificulad(Nivel.DIFICIL));
    }
    void onClickDificulad(Nivel i){
        Intent intent =new Intent(this, Juego.class);
        Bundle b=new Bundle();
        b.putString("nombre", nombre);
        b.putString("dificultad", i.name());
        intent.putExtras(b);
        startActivity(intent);
    }
}