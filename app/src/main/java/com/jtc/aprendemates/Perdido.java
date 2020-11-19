package com.jtc.aprendemates;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Perdido extends AppCompatActivity {

    TextView mensaje;
    Button salir, reset;
    Bundle b;
    Jugador j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdido);
        b = getIntent().getExtras();
        j = (Jugador) b.getSerializable("jugador");
        salir = findViewById(R.id.btSalir);
        reset = findViewById(R.id.btReset);
        salir.setOnClickListener(v -> this.finishAffinity());
        reset.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
            this.finishAffinity();
        });
        mensaje = findViewById(R.id.txtMensaje);
        mensaje.setText(String.format("%s%s%s%d",
                j.getNombre(), System.lineSeparator(), getResources().getString(R.string.puntuacion), j.getScore()));
        setFinishOnTouchOutside(true);
    }

    @Override
    protected void onPause() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finishAffinity();
        super.onPause();
    }
}