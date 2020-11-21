package com.jtc.aprendemates;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jtc.aprendemates.db.AdminSQLiteOpenHelper;

public class Ranking extends AppCompatActivity {

    LinearLayout rank;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        rank = findViewById(R.id.rank);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor row = db.rawQuery("select * from ranking order by score desc, actual_level-init_level desc", null);
        int i = 1;
        while (row.moveToNext()) {
            txt = new TextView(this, null);
            String str = i + ".- " + row.getInt(4) + " " + row.getString(1) + " " + row.getInt(2) + " " + row.getInt(3);
            txt.setText(str);
            txt.setGravity(Gravity.CENTER);
            txt.setTextAppearance(R.style.txt_juego);
            rank.addView(txt);
            i++;
        }

        row.close();
        db.close();
    }
}