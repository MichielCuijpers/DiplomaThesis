package com.icsd.game.thesis.game4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.icsd.game.thesis.commons.AppLan;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;


import java.util.ArrayList;

public class Word {
    private ArrayList<Character> letters;


    public Word() {

    }

    //START INNER CLASS
    public static class WordDBEntry implements BaseColumns {
        static DatabaseHandler dh;
        static SQLiteDatabase db;
        public static final String TABLE_NAME = "word";
        public static final String WORD = "word";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        WORD + " TEXT)";
        ;

        public static void addTestWordsToDB(SQLiteDatabase db) {

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL(SQL_CREATE_ENTRIES);
            ContentValues values = new ContentValues();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.happy));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.action));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.desk));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.jazz));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.quiz));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.computer));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.chair));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.benefit));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.science));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.secretary));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.security));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(WORD, AppLan.getAppContext().getResources().getString(R.string.zero));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            // db.close();
        }

        protected static ArrayList<String> takeWorldsFromDB() {
            ArrayList<String> queryResultsList = new ArrayList<>();
            dh = new DatabaseHandler(Game4Activity.getContext());
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
