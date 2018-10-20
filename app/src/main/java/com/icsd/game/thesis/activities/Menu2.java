package com.icsd.game.thesis.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.AndroidDatabaseManager;
import com.icsd.game.thesis.database.DatabaseHandler;


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
        DatabaseHandler.exportDBtoCsv();
        Toast.makeText(this, "csvs exported!!",
                Toast.LENGTH_LONG).show();
    }

    public void highscoreOnClick(View view) {
        Intent goToHighscores = new Intent(this, HighscoresActivity.class);
        startActivity(goToHighscores);
    }

    public void finalSurOnClick(View view) {
        Intent surv = new Intent(this, SurveyActivity.class);
        SurveyActivity.setQuestionType(1);
        SurveyActivity.setGameID(0);
        startActivity(surv);
    }

    public void dbTest(View view) {

        Intent dbmanager = new Intent(this, AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }
}
