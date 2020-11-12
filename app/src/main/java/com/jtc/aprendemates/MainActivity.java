package com.jtc.aprendemates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    Button boton_empezar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=findViewById(R.id.txtNombre);
        boton_empezar=findViewById(R.id.btEmpezar);
        boton_empezar.setOnClickListener(v -> onClickBotonEmpezar());
    }
    void onClickBotonEmpezar(){
        Intent i =new Intent(this, Dificultad.class);
        Bundle b=new Bundle();
        b.putString("nombre", nombre.getText().toString());
        startActivity(i,b);
    }
}