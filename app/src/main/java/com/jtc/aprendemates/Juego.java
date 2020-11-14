package com.jtc.aprendemates;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Juego extends AppCompatActivity {
    Bundle b;
    Jugador j;
    ImageView imgNum1, imgNum2, imgVidas;
    Button btComprobar;
    TextView txtOperacion, txtScore;
    EditText edTxtNum;
    static int[] imagenesNum = {
            R.drawable.ic_num1,
            R.drawable.ic_num2,
            R.drawable.ic_num3,
            R.drawable.ic_num4,
            R.drawable.ic_num5,
            R.drawable.ic_num6,
            R.drawable.ic_num7,
            R.drawable.ic_num8,
            R.drawable.ic_num9};
    int resultadoEsperado;

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
        dificultad(j.getDificultad());
    }

    void dificultad(Nivel n) {
        if (n == Nivel.FACIL) facil();
        if (n == Nivel.MEDIO) medio();
        if (n == Nivel.DIFICIL) dificil();
    }

    void setImgVidas() {

    }

    void facil() {
        txtOperacion.setText("+");
        Random r = new Random();
        int n1 = r.nextInt(8);
        int n2 = r.nextInt(8);
        imgNum1.setImageDrawable(getDrawable(imagenesNum[n1]));
        imgNum2.setImageDrawable(getDrawable(imagenesNum[n2]));
        resultadoEsperado = n2 + n1 + 2;

    }

    void medio() {
    }

    void dificil() {
    }

}