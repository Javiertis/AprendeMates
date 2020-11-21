package com.jtc.aprendemates;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView tv = findViewById(R.id.infoText);
        String text = getResources().getString(R.string.info_facil_titulo)
                + System.lineSeparator()
                + getResources().getString(R.string.info_facil)
                + System.lineSeparator()
                + System.lineSeparator()
                + getResources().getString(R.string.info_medio_titulo)
                + System.lineSeparator()
                + getResources().getString(R.string.info_medio)
                + System.lineSeparator()
                + System.lineSeparator()
                + getResources().getString(R.string.info_dificil_titulo)
                + System.lineSeparator()
                + getResources().getString(R.string.info_dificil);
        tv.setText(text);
    }
}