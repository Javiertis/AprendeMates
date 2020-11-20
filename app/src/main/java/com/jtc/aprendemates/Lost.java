package com.jtc.aprendemates;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jtc.aprendemates.db.AdminSQLiteOpenHelper;

import java.text.DateFormat;

public class Lost extends AppCompatActivity {

    TextView mensaje;
    Button salir, reset;
    Bundle b;
    Player j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        b = getIntent().getExtras();
        j = (Player) b.getSerializable("player");
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
                j.getName(), System.lineSeparator(), getResources().getString(R.string.puntuacion), j.getScore()));
        setFinishOnTouchOutside(true);
        saveScore();
    }

    @Override
    protected void onPause() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finishAffinity();
        super.onPause();
    }

    void saveScore() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase dataBase = admin.getWritableDatabase();
        ContentValues insertion = new ContentValues();

        insertion.put("game_date", DateFormat.getDateInstance().toString());
        insertion.put("player", j.getName());
        insertion.put("init_level", j.getInitLevel().levelValue() + 1);
        insertion.put("actual_level", j.getActualLevel().levelValue() + 1);
        insertion.put("score", j.getScore());
        dataBase.insert("ranking", null, insertion);
        insertion.clear();
        dataBase.close();
    }
}