package com.jtc.aprendemates;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Juego extends AppCompatActivity {
    Bundle b;
    Jugador j;
    ImageView imgNum1, imgNum2, imgVidas;
    Button btComprobar;
    TextView txtOperacion, txtScore;
    EditText edTxtNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        b = getIntent().getExtras();
        j = new Jugador(b.getString("nombre"), b.getString("dificultad"));

        imgNum1 = findViewById(R.id.imgNum1);
        imgNum2 = findViewById(R.id.imgNum2);
        imgVidas = findViewById(R.id.imgVidas);
        btComprobar = findViewById(R.id.btComprobar);
        txtOperacion = findViewById(R.id.txtOperacion);
        txtScore = findViewById(R.id.txtScore);
        edTxtNum = findViewById(R.id.edTxtNum);

    }

    void dificultad(Nivel n) {
        if (n == Nivel.FACIL) facil();
        if (n == Nivel.MEDIO) medio();
        if (n == Nivel.DIFICIL) dificil();
    }

    void setImgVidas() {

    }

    void facil() {
    }

    void medio() {
    }

    void dificil() {
    }


}