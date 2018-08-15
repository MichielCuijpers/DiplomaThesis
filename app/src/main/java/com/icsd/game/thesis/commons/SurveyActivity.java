package com.icsd.game.thesis.commons;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Survey;
import com.icsd.game.thesis.game1.Game1Activity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SurveyActivity extends AppCompatActivity {
    private static int questionType;
    private int counter;
    private ArrayList<String> questions;

    public static void setQuestionType(int questionTyp) {
        questionType = questionTyp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        counter = 0;

    }

    public void button1OnCl(View view) {
    }

    public void button2OnCl(View view) {
    }

    public void button3OnCl(View view) {
    }

    public void button4OnCl(View view) {
    }

    public void button5OnCl(View view) {
    }

    private void takeQuestionsFromDB() {

        DatabaseHandler dh = new DatabaseHandler(Game1Activity.getMyCont());
        ArrayList<String> queryResultsList = new ArrayList<>();
        SQLiteDatabase db = dh.getWritableDatabase();
        String question;
        String selectQuery = "SELECT * FROM " + Survey.SurveyQuestionDBEntry.TABLE_NAME + " WHERE " + Survey.SurveyQuestionDBEntry.TYPE + " = " + questionType;

        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            questions.add(cursor.getString(cursor.getColumnIndexOrThrow(Survey.SurveyQuestionDBEntry.QUESTION)));
            cursor.moveToNext();
        }
        cursor.close();

    }

    private void saveResultsToDB() {

    }
}
