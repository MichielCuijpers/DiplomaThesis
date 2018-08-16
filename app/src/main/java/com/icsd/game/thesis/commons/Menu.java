package com.icsd.game.thesis.commons;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.GestureDetectorCompat;
import android.os.Bundle;
import android.view.View;

import com.icsd.game.thesis.Game6.Game6;
import com.icsd.game.thesis.Game7.Game7;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.User;
import com.icsd.game.thesis.game1.Game1Activity;
import com.icsd.game.thesis.game2.Game2Activity;
import com.icsd.game.thesis.game3.Game3;
import com.icsd.game.thesis.game4.Game4Activity;
import com.icsd.game.thesis.game5.Game5;
import com.icsd.game.thesis.game8.Game8;


public class Menu extends Activity {
    private GestureDetectorCompat mDetector;
    private static User testUser;
    DatabaseHandler dh;
    private static SQLiteDatabase db;

    public static SQLiteDatabase getDb() {
        return db;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);


    }


    public void goToMenu2(View view) {
        Intent c = new Intent(Menu.this, Menu2.class);
        startActivity(c);
    }



    public void c1OnCLick(View view) {
        Intent c = new Intent(Menu.this, Μenu3.class);
        Μenu3.setWichCate(1);
        Μenu3.setWichCate(1);
        startActivity(c);
    }

    public void c2OnCLick(View view) {
        Intent c = new Intent(Menu.this, Μenu3.class);
        Μenu3.setWichCate(2);
        startActivity(c);
    }

    public void c3OnCLick(View view) {
        Intent c = new Intent(Menu.this, Μenu3.class);
        Μenu3.setWichCate(3);
        startActivity(c);
    }

    public void c4nCLick(View view) {
        Intent c = new Intent(Menu.this, Μenu3.class);
        Μenu3.setWichCate(4);
        startActivity(c);
    }
}
