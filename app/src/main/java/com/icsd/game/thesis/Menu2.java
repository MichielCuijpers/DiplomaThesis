package com.icsd.game.thesis;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.icsd.game.thesis.Game12.Game12;
import com.icsd.game.thesis.Game14.Game14;
import com.icsd.game.thesis.Game9.Game9;
import com.icsd.game.thesis.database.AndroidDatabaseManager;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.game13.Game13;
import com.icsd.game.thesis.game15.Game15Menou;


public class Menu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);


    }

    public void goToMenu1(View view) {
        Intent c = new Intent(Menu2.this, Menu.class);
        startActivity(c);
    }
    public void Game14(View view){
        Intent c = new Intent(this,Game14.class);
        startActivity(c);
    }
    public void game13(View view) {
        Intent c = new Intent(this, Game13.class);
        startActivity(c);
    }
    public void Game12(View view){
        Intent c = new Intent(this, Game12.class);
        startActivity(c);
    }
    public void Game9(View view){
        Intent c = new Intent(this, Game9.class);
        startActivity(c);
    }

    public void dbTest(View view) {
        Intent dbmanager = new Intent(this, AndroidDatabaseManager.class);

        startActivity(dbmanager);
    }

    public void game15(View view) {
        Intent c = new Intent(this, Game15Menou.class);
        startActivity(c);
    }

    public void game16(View view) {
        Intent c = new Intent(this,LoginActivity.class);
        startActivity(c);
    }
}
