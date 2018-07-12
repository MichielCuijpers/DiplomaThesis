package com.icsd.game.thesis.game5;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.game1.Game1Activity;
import com.icsd.game.thesis.game1.Question;

public class Object {
    public static class ObjectDBEntry implements BaseColumns {
        public static final String TABLE_NAME = "object";
        public static final String NAME = "name";
        public static final String ANSWER1 = "answer1";
        public static final String ANSWER2 = "answer2";
        public static final String ANSWER3 = "answer3";
        public static final String ANSWER4 = "answer4";
        static final DatabaseHandler dh = new DatabaseHandler(Game1Activity.getMyCont());
        static SQLiteDatabase db;

        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " TEXT, "
                + ANSWER1 + " TEXT, "
                + ANSWER2 + " TEXT, "
                + ANSWER3 + " TEXT, "
                + ANSWER4 + " TEXT)";

        protected static void addTestQuestionToDB() {

            db = dh.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + Question.QuestionDBEntry.TABLE_NAME);
            db.execSQL(Question.QuestionDBEntry.SQL_CREATE_ENTRIES);
            ContentValues values = new ContentValues();

            values.put(NAME, "hummer");
            values.put(ANSWER1, "geography");
            values.put(ANSWER2, "mississippi");
            values.put(ANSWER3, "niger");
            values.put(ANSWER4, "Amur–Argun");
            db.insert(Question.QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

        }
    }
}
