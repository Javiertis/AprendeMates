package com.jtc.aprendemates;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jtc.aprendemates.db.AdminSQLiteOpenHelper;

import java.util.Calendar;

public class Lost extends AppCompatActivity {

    TextView txtMessage;
    Button btExit, btReset;
    Bundle bundle;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        bundle = getIntent().getExtras();
        player = (Player) bundle.getSerializable("player");
        btExit = findViewById(R.id.btExit);
        btReset = findViewById(R.id.btReset);
        btExit.setOnClickListener(v -> this.finishAffinity());
        btReset.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
            this.finishAffinity();
        });
        txtMessage = findViewById(R.id.txtMessage);
        txtMessage.setText(String.format("%s%s%s%d",
                player.getName(), System.lineSeparator(), getResources().getString(R.string.score), player.getScore()));
        setFinishOnTouchOutside(true);
        saveScore();
    }


    void saveScore() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase dataBase = admin.getWritableDatabase();
        ContentValues insertion = new ContentValues();

        insertion.put("game_date", Calendar.getInstance().getTimeInMillis());
        insertion.put("name", player.getName());
        insertion.put("init_level", player.getInitLevel().levelValue() + 1);
        insertion.put("actual_level", player.getActualLevel().levelValue() + 1);
        insertion.put("score", player.getScore());
        dataBase.insert("ranking", null, insertion);
        insertion.clear();
        dataBase.close();
    }
}