package com.icsd.game.thesis.game1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.icsd.game.thesis.database.DatabaseHandler;

public class Question {

    protected static void addTestQuestionToDB() {
        DatabaseHandler dh = new DatabaseHandler(Game1Activity.getMyCont());
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QuestionDBEntry.QUESTION,"QUESTION 1");
        values.put(QuestionDBEntry.CATEGORY,"Category 1");
        db.insert(QuestionDBEntry.TABLE_NAME, null, values);
        values.clear();
        values.put(QuestionDBEntry.QUESTION,"QUESTION 2");
        values.put(QuestionDBEntry.CATEGORY,"Category 2");
        db.insert(QuestionDBEntry.TABLE_NAME, null, values);

        db.close();
    }

    public class QuestionDBEntry implements BaseColumns {
        public static final String TABLE_NAME = "question";
        public static final String QUESTION = "question";
        public static final String CATEGORY = "category";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        QUESTION + " TEXT, "
                        + CATEGORY + " TEXT)";
    }
}