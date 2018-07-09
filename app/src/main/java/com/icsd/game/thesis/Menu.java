package com.icsd.game.thesis;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.game4.MainActivity;
import com.icsd.game.thesis.game8.Game8;

import java.util.ArrayList;


public class Menu extends AppCompatActivity {
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void goToMenu2(View view) {
        Intent c = new Intent(Menu.this, Menu2.class);
        DatabaseHandler dbh = new DatabaseHandler(getApplicationContext());
        SQLiteDatabase db = dbh.getReadableDatabase();
        ArrayList<String> todoItems = new ArrayList<>();
        Cursor cu = DatabaseHandler.showAllTables(db);
        if (cu.moveToFirst()) {
            do {
                todoItems.add(cu.getString(0));

            } while (cu.moveToNext());
        }
        if (todoItems.size() >= 0) {
            for (int i = 0; i < todoItems.size(); i++) {
                Log.d("TODOItems(" + i + ")", todoItems.get(i) + "");

            }

        }

        startActivity(c);
    }


    public void game8(View view) {
        Intent c = new Intent(this, Game8.class);
        startActivity(c);
    }

    public void game4(View view) {
        Intent c = new Intent(this, MainActivity.class);
        startActivity(c);
    }
}
