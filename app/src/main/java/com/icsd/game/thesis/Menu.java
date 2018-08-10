package com.icsd.game.thesis;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.GestureDetectorCompat;
import android.os.Bundle;
import android.view.View;

import com.icsd.game.thesis.Game6.Game6;
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
        testUser = LoginActivity.getUser();

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
        Intent c = new Intent(this, Game4Activity.class);
        startActivity(c);
    }

    public void game1(View view) {
        Intent c = new Intent(this, Game1Activity.class);
        startActivity(c);
    }

    public void game5(View view) {
        Intent c = new Intent(this, Game5.class);
        startActivity(c);
    }

    public void game2(View view) {
        Intent c = new Intent(this, Game2Activity.class);
        startActivity(c);
    }

    public void game6(View view) {
        Intent c = new Intent(this, Game6.class);
        startActivity(c);
    }

    public void game3(View view) {
        Intent c = new Intent(this, Game3.class);
        startActivity(c);
    }

}
