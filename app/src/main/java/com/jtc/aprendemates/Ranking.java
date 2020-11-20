package com.jtc.aprendemates;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.jtc.aprendemates.db.AdminSQLiteOpenHelper;

public class Ranking extends AppCompatActivity {

    LinearLayout rank;
    TextView tw;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        rank = findViewById(R.id.rank);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor row = db.rawQuery("select * from ranking order by score, actual_level-init_level", null);

        while (row.moveToNext()) {
            tw = new TextView(this, null);
            String str = row.getInt(4) + " " + row.getString(1) + " " + row.getInt(2) + " " + row.getInt(3);
            tw.setText(str);
            tw.setGravity(Gravity.CENTER);
            tw.setTextAppearance(R.style.txt_juego);
            rank.addView(tw);
        }

        row.close();
        db.close();
    }
}