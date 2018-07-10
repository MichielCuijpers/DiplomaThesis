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
import com.icsd.game.thesis.database.User;
import com.icsd.game.thesis.game4.MainActivity;
import com.icsd.game.thesis.game8.Game8;

import java.util.ArrayList;


public class Menu extends AppCompatActivity {
    private GestureDetectorCompat mDetector;
    public static User testUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        testUser = new User(1);

    }

    public void goToMenu2(View view) {
        Intent c = new Intent(Menu.this, Menu2.class);
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
