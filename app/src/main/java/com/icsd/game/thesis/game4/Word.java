package com.icsd.game.thesis.game4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.game1.Game1Activity;


import java.util.ArrayList;

public class Word {
    private ArrayList<Character> letters;
    ;
    public Word() {

    }

    //START INNER CLASS
    public static class WordDBEntry implements BaseColumns {
        static final DatabaseHandler dh = new DatabaseHandler(Game4Activity.getMyCont());
        static SQLiteDatabase db;
        public static final String TABLE_NAME = "word";
        public static final String WORD = "word";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        WORD + " TEXT)";
        ;

        protected static void addTestWordsToDB() {
            db = dh.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL(SQL_CREATE_ENTRIES);
            ContentValues values = new ContentValues();
            values.put(WORD, "happy");
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, "android");
            db.insert(TABLE_NAME, null, values);
            values.clear();
        }

        protected static ArrayList<String> takeWorldsFromDB() {
            ArrayList<String> queryResultsList = new ArrayList<>();
            db = dh.getWritableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String word = cursor.getString(cursor.getColumnIndexOrThrow(WORD));
                queryResultsList.add(word);
               // Log.e("MyDEb",cursor.getString(cursor.getColumnIndexOrThrow(WORD)));
                cursor.moveToNext();

            }
            cursor.close();
            return queryResultsList;
        }

    }

    //END INNER CLASS
}
