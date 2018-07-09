package com.icsd.game.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.icsd.game.thesis.database.AndroidDatabaseManager;
import com.icsd.game.thesis.game13.Game13;


public class Menu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);


    }
    public void goToMenu1(View view) {
        Intent c = new Intent(Menu2.this,Menu.class);
        startActivity(c);
    }
    public void game13(View view) {
        Intent c = new Intent(this,Game13.class);
        startActivity(c);
    }

    public void dbTest(View view) {
        Intent dbmanager = new Intent(this,AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }
}
