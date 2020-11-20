package com.jtc.aprendemates;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LevelChooser extends AppCompatActivity {

    String name;
    Bundle bundle;
    Button btEasy, btMedium, btHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        bundle = getIntent().getExtras();
        name = bundle.getString("name");

        btEasy = findViewById(R.id.btFacil);
        btMedium = findViewById(R.id.btMedio);
        btHard = findViewById(R.id.btDificl);

        btEasy.setOnClickListener(v -> onClickLevel(Level.EASY));
        btMedium.setOnClickListener(v -> onClickLevel(Level.MEDIUM));
        btHard.setOnClickListener(v -> onClickLevel(Level.HARD));
    }

    void onClickLevel(Level level) {
        Intent intent = new Intent(this, Game.class);
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putString("level", level.name());
        intent.putExtras(b);
        startActivity(intent);
    }
}