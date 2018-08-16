package com.icsd.game.thesis.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.AppLan;
import com.icsd.game.thesis.game1.Question;

import java.util.Locale;

public class Survey {
    public class SurveyResultsDBEntry implements BaseColumns {

        public static final String TABLE_NAME = "survey_result";
        public static final String QUESTION = "question";
        public static final String ANSWER = "answer";
        public static final String GAME_ID = "game_id";
        public static final String USER = "user";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + QUESTION + " TEXT, "
                        + ANSWER + " INTEGER, "
                        + USER + " TEXT, "
                        + GAME_ID + " INTEGER) ";

    }

    public static class SurveyQuestionDBEntry implements BaseColumns {

        public static final String TABLE_NAME = "survey_question";
        public static final String QUESTION = "question";
        public static final String TYPE = "type";



        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + QUESTION + " TEXT, "
                        + TYPE + " INTEGER)";

        public static void addSurvQuestionsToDB(SQLiteDatabase db) {
            ContentValues values = new ContentValues();

            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q1s0));
            values.put(SurveyQuestionDBEntry.TYPE, 0);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q2s0));
            values.put(SurveyQuestionDBEntry.TYPE, 0);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q3s0));
            values.put(SurveyQuestionDBEntry.TYPE, 0);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q1s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q2s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q3s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q4s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q5s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q6s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q7s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q8s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q9s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();
            values.put(SurveyQuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q10s1));
            values.put(SurveyQuestionDBEntry.TYPE, 1);
            db.insert(SurveyQuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

        }

    }


}
