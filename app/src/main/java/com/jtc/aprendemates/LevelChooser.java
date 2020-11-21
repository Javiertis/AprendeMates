package com.jtc.aprendemates;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
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

        btEasy = findViewById(R.id.btEasy);
        btMedium = findViewById(R.id.btMedium);
        btHard = findViewById(R.id.btHard);

        btEasy.setOnClickListener(v -> onClickLevel(Level.EASY));
        btMedium.setOnClickListener(v -> onClickLevel(Level.MEDIUM));
        btHard.setOnClickListener(v -> onClickLevel(Level.HARD));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_level, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.info) {
            Intent i = new Intent(this, Info.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
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