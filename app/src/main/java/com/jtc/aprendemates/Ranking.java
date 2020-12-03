package com.jtc.aprendemates;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.jtc.aprendemates.db.AdminSQLiteOpenHelper;

import java.util.Locale;

public class Ranking extends AppCompatActivity {

    LinearLayout rank;
    TextView txt;

    @RequiresApi(api = Build.VERSION_CODES.M)
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
            txt = new TextView(this);
            String str = String.format(Locale.ENGLISH, "%s %td/%2$tm/%2$ty", row.getInt(5), row.getLong(0));
            str = String.format(Locale.ENGLISH, "%02d.- %-4.4s%-15.14s%s", i, row.getInt(4), row.getString(1), str);

            txt.setText(str);
            txt.setTextAppearance(R.style.txtGame);
            txt.setTextSize(17f);
            txt.setTypeface(Typeface.MONOSPACE);
            rank.addView(txt);
            i++;
        }
        row.close();
        db.close();
    }
}