package com.icsd.game.thesis.commons;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.GetChars;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Survey;
import com.icsd.game.thesis.game1.Game1Activity;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SurveyActivity extends AppCompatActivity {
    private static int questionType;
    private int counter;
    private ArrayList<String> questions;
    private TextView questionView;
    private PopUpWindow popUpWindow;
    private ArrayList<Integer> answers;
    private static int gameID;

    public static void setGameID(int gameID) {
        SurveyActivity.gameID = gameID;
    }

    public static void setQuestionType(int questionTyp) {
        questionType = questionTyp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        init();
        takeQuestionsFromDB();
        setQuestion();


    }

    private void init() {
        counter = 0;
        questionView = findViewById(R.id.surveyQ);
        questions = new ArrayList<>();
        popUpWindow = new PopUpWindow(this, this);
        answers = new ArrayList<>();

    }

    private void setQuestion() {
        Log.e("MYDEBUG",counter+"");
        if (counter == 9 && questionType == 1) {
            Log.e("MYDEBUG",counter+"");
            endSurv();

        }

        if (counter == 2 && questionType == 0) {
            endSurv();
        }
        questionView.setText(questions.get(counter));


    }

    private void endSurv() {

        DatabaseHandler.saveSurveyResultsToDB(this.answers, this.questions, this.questionType, this.gameID);
        Intent end = new Intent(getApplicationContext(), Menu.class);
        startActivity(end);


    }


    public void button1OnCl(View view) {

        answers.add(1);
        counter++;
        setQuestion();

    }

    public void button2OnCl(View view) {

        answers.add(2);

        counter++;
        setQuestion();
    }

    public void button3OnCl(View view) {

        answers.add(3);

        counter++;
        setQuestion();
    }

    public void button4OnCl(View view) {

        answers.add(4);

        counter++;
        setQuestion();
    }

    public void button5OnCl(View view) {

        answers.add(5);
        counter++;
        setQuestion();
    }

    private void takeQuestionsFromDB() {

        DatabaseHandler dh = new DatabaseHandler(AppLan.getAppContext());
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


}
