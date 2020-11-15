package com.jtc.aprendemates;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Juego extends AppCompatActivity {
    static int[] imagenesNum = {
            R.drawable.ic_num1,
            R.drawable.ic_num2,
            R.drawable.ic_num3,
            R.drawable.ic_num4,
            R.drawable.ic_num5,
            R.drawable.ic_num6,
            R.drawable.ic_num7,
            R.drawable.ic_num8,
            R.drawable.ic_num9
    };
    static int[] imagenesVida = {
            R.drawable.ic_vida1,
            R.drawable.ic_vida2,
            R.drawable.ic_vida3,
    };
    static String[] operaciones = {
            "+",
            "-",
            "x"
    };
    Bundle bundle;
    Jugador jugador;
    ImageView imgNum1, imgNum2, imgVidas;
    Button btComprobar;
    TextView txtOperacion, txtScore, txtNum1, txtNum2;
    EditText edTxtNum;
    int resultadoEsperado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        bundle = getIntent().getExtras();
        jugador = new Jugador(bundle.getString("nombre"), bundle.getString("dificultad"));


        imgNum1 = findViewById(R.id.imgNum1);
        imgNum2 = findViewById(R.id.imgNum2);
        imgVidas = findViewById(R.id.imgVidas);
        btComprobar = findViewById(R.id.btComprobar);

        txtOperacion = findViewById(R.id.txtOperacion);
        txtScore = findViewById(R.id.txtScore);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        edTxtNum = findViewById(R.id.edTxtNum);
        rellenarOperacion(jugador.getDificultad());
        txtScore.setText(String.format("%d", jugador.getScore()));
        setImgVidas();
        btComprobar.setOnClickListener(v -> comprobar());
    }

    void rellenarOperacion(Nivel n) {
        Random r = new Random();
        String op = n == Nivel.FACIL ? operaciones[n.getNivel()] : operaciones[r.nextInt(n.getNivel())];
        int n1 = r.nextInt(imagenesNum.length);
        int n2 = op.equals("-") ? r.nextInt(n1) : r.nextInt(imagenesNum.length);
        imgNum1.setImageDrawable(getDrawable(imagenesNum[n1]));
        imgNum2.setImageDrawable(getDrawable(imagenesNum[n2]));
        resultadoEsperado = operacion(op, n1 + 1, n2 + 1);
    }

    void setImgVidas() {
        if (jugador.getVidas() >= 1)
            imgVidas.setImageDrawable(getDrawable(imagenesVida[jugador.getVidas() - 1]));
    }

    int operacion(String op, int x, int y) {
        txtNum1.setText(String.format("%d", x));
        txtNum2.setText(String.format("%d", y));
        if (op.equals("+")) {
            txtOperacion.setText("+");
            return x + y;
        } else if (op.equals("-")) {
            txtOperacion.setText("-");
            return x - y;
        } else {
            txtOperacion.setText("x");
            return x * y;
        }
    }

    void comprobar() {
        String numStr = edTxtNum.getText().toString();
        if (!numStr.equals("")) {
            int resultado = Integer.parseInt(numStr);
            if (resultado == resultadoEsperado) {
                rellenarOperacion(jugador.getDificultad());
                jugador.setScore(jugador.getScore() + 5);
                txtScore.setText(String.format("%d", jugador.getScore()));
            } else if (jugador.getVidas() >= 1) {
                jugador.reducirVidas();
                setImgVidas();
                rellenarOperacion(jugador.getDificultad());
            }
            rellenarOperacion(jugador.getDificultad());

        }
        edTxtNum.setText("");
    }
    //TODO ponerlo bonito y actividad de puntuacion
}