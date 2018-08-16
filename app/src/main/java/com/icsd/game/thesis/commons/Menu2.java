package com.icsd.game.thesis.commons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.icsd.game.thesis.Game10.Game10;
import com.icsd.game.thesis.Game11.Game11;
import com.icsd.game.thesis.Game12.Game12;
import com.icsd.game.thesis.Game14.Game14;
import com.icsd.game.thesis.Game9.Game9;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.AndroidDatabaseManager;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.game13.Game13;
import com.icsd.game.thesis.game15.Game15;

import com.icsd.game.thesis.pet.PetActivity;


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




    public void writeDataCSVonclick(View view) {
    }

    public void highscoreOnClick(View view) {
    }

    public void finalSurOnClick(View view) {
        Intent surv = new Intent(this, SurveyActivity.class);
        SurveyActivity.setQuestionType(1);
        SurveyActivity.setGameID(0);
        startActivity(surv);
    }

    public void dbTest(View view) {
        DatabaseHandler.exportDBtoCsv();
        Intent dbmanager = new Intent(this, AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }
}
