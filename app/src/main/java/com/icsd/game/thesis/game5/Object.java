package com.icsd.game.thesis.game5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.game1.Game1Activity;
import com.icsd.game.thesis.game1.Question;

import java.util.ArrayList;

public class Object {
    private String name;
    private ArrayList<String> answers;


    protected Object() {
        answers = new ArrayList<>();

    }


    public static class ObjectDBEntry implements BaseColumns {
        public static final String TABLE_NAME = "object";
        public static final String NAME = "name";
        public static final String ANSWER1 = "answer1";
        public static final String ANSWER2 = "answer2";
        public static final String ANSWER3 = "answer3";
        public static final String ANSWER4 = "answer4";
        static final DatabaseHandler dh = new DatabaseHandler(Game5.getMyCont());
        static SQLiteDatabase db;

        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " TEXT, "
                + ANSWER1 + " TEXT, "
                + ANSWER2 + " TEXT, "
                + ANSWER3 + " TEXT, "
                + ANSWER4 + " TEXT)";

        protected static void addTestObjectToDB() {

            db = dh.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL(SQL_CREATE_ENTRIES);
            ContentValues values = new ContentValues();

            values.put(NAME, "hummer");
            values.put(ANSWER1, "smash a rock");
            values.put(ANSWER2, "screw");
            values.put(ANSWER3, "open a beer");
            values.put(ANSWER4, "open a laptop");
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(NAME, "glass");
            values.put(ANSWER1, "drink water");
            values.put(ANSWER2, "eat food");
            values.put(ANSWER3, "goldfish house");
            values.put(ANSWER4, "pot for flowers");
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(NAME, "toaster");
            values.put(ANSWER1, "make toasts");
            values.put(ANSWER2, "roast meat");
            values.put(ANSWER3, "make tea");
            values.put(ANSWER4, "call a friend ");
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(NAME, "fireex");
            values.put(ANSWER1, "extinguish fire");
            values.put(ANSWER2, "make fire");
            values.put(ANSWER3, "blow up leafs");
            values.put(ANSWER4, "smash rocks ");
            db.insert(TABLE_NAME, null, values);


            db.close();

        }

        static ArrayList<Object> takeObjectsFromDB() {

            //Query from db
            ArrayList<Object> queryResultsList = new ArrayList<>();
            db = dh.getWritableDatabase();
            String data;

            String selectQuery = "SELECT * FROM " + TABLE_NAME;

            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Object tempObject = new Object();
                data = cursor.getString(cursor.getColumnIndexOrThrow(NAME));
                tempObject.name = data;
                data = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER1));
                tempObject.answers.add(data);
                data = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER2));
                tempObject.answers.add(data);
                data = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER3));
                tempObject.answers.add(data);
                data = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER4));
                tempObject.answers.add(data);
                queryResultsList.add(tempObject);
                cursor.moveToNext();


            }
            cursor.close();

            return queryResultsList;
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }


}
