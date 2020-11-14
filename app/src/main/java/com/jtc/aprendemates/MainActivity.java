package com.jtc.aprendemates;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent =new Intent(this, Dificultad.class);
        Bundle b=new Bundle();
        b.putString("nombre", nombre.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }
}