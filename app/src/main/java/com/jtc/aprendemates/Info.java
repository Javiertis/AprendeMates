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
        String text = getResources().getString(R.string.info_easy_title)
                + System.lineSeparator()
                + getResources().getString(R.string.info_easy)
                + System.lineSeparator()
                + System.lineSeparator()
                + getResources().getString(R.string.info_medium_title)
                + System.lineSeparator()
                + getResources().getString(R.string.info_medium)
                + System.lineSeparator()
                + System.lineSeparator()
                + getResources().getString(R.string.info_hard_title)
                + System.lineSeparator()
                + getResources().getString(R.string.info_hard);
        tv.setText(text);
    }
}