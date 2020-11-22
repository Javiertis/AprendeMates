package com.jtc.aprendemates;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jtc.aprendemates.db.AdminSQLiteOpenHelper;

import java.util.Locale;

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
        Cursor row = db.rawQuery("select *,actual_level-init_level from ranking order by score desc, actual_level-init_level desc limit 10", null);
        int i = 1;
        while (row.moveToNext()) {
            txt = new TextView(this, null);
            String str = String.format(Locale.ENGLISH, "%2d.- %4d %21s %10d %td/%5$tm/%5$ty", i, row.getInt(4), row.getString(1), row.getInt(5), row.getLong(0));
            txt.setText(str);
            txt.setTextAppearance(R.style.txtGame);
            txt.setTextSize(20f);
            rank.addView(txt);
            i++;
        }
        row.close();
        db.close();
    }
}