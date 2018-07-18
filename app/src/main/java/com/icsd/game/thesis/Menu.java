package com.icsd.game.thesis;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.os.Bundle;
import android.view.View;

import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.User;
import com.icsd.game.thesis.game1.Game1Activity;
import com.icsd.game.thesis.game4.Game4Activity;
import com.icsd.game.thesis.game5.Game5;
import com.icsd.game.thesis.game8.Game8;


public class Menu extends Activity {
    private GestureDetectorCompat mDetector;
    public static User testUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        testUser = new User(1);
        DatabaseHandler dbUsertest = new DatabaseHandler(this);
        dbUsertest.addUserToDB(testUser);

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
}
