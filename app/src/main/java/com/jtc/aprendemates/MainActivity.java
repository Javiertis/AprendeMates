package com.jtc.aprendemates;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.txtNombre);
        startButton = findViewById(R.id.btEmpezar);
        startButton.setOnClickListener(v -> onClickBotonEmpezar());
    }

    void onClickBotonEmpezar() {
        Intent intent = new Intent(this, LevelChooser.class);
        Bundle b = new Bundle();
        String nameStr = this.name.getText().toString();
        b.putString("name", nameStr.equals("") ? "Player" : nameStr);
        intent.putExtras(b);
        startActivity(intent);
    }
}