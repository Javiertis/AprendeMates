package com.jtc.aprendemates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Perdido extends AppCompatActivity {

    TextView mensaje;
    Button salir, reset;
    Bundle b;
    Jugador j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdido);
        b=getIntent().getExtras();
        j=(Jugador) b.getSerializable("jugador");
        salir=findViewById(R.id.btSalir);
        reset=findViewById(R.id.btReset);
        salir.setOnClickListener(v->this.finishAffinity());
        reset.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
            this.finishAffinity();});
        mensaje=findViewById(R.id.txtMensaje);
        mensaje.setText(j.toString());
    }
}