package com.jtc.aprendemates;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.txtName);
        startButton = findViewById(R.id.btStart);
        startButton.setOnClickListener(v -> onClickBotonEmpezar());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.rank) {
            Intent i = new Intent(this, com.jtc.aprendemates.Ranking.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    void onClickBotonEmpezar() {
        Intent intent = new Intent(this, LevelChooser.class);
        Bundle b = new Bundle();
        String nameStr = this.name.getText().toString();
        b.putString("name", nameStr.equals("") ? getString(R.string.default_name) : nameStr);
        intent.putExtras(b);
        startActivity(intent);
    }
}