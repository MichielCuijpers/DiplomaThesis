package com.icsd.game.thesis.game5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.icsd.game.thesis.AppLan;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;

import java.util.ArrayList;

public class ObjectT {
    private String name;
    private ArrayList<String> answers;


    protected ObjectT() {
        answers = new ArrayList<>();

    }


    public static class ObjectDBEntry implements BaseColumns {
        public static final String TABLE_NAME = "object";
        public static final String NAME = "name";
        public static final String ANSWER1 = "answer1";
        public static final String ANSWER2 = "answer2";
        public static final String ANSWER3 = "answer3";
        public static final String ANSWER4 = "answer4";
        static DatabaseHandler dh;
        static SQLiteDatabase db;

        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " TEXT, "
                + ANSWER1 + " TEXT, "
                + ANSWER2 + " TEXT, "
                + ANSWER3 + " TEXT, "
                + ANSWER4 + " TEXT)";

        public static void addTestObjectToDB(SQLiteDatabase db) {
            db = db;

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL(SQL_CREATE_ENTRIES);
            ContentValues values = new ContentValues();

            values.put(NAME, AppLan.getAppContext().getResources().getString(R.string.hummer));
            values.put(ANSWER1, AppLan.getAppContext().getResources().getString(R.string.smash));
            values.put(ANSWER2, AppLan.getAppContext().getResources().getString(R.string.screw));
            values.put(ANSWER3, AppLan.getAppContext().getResources().getString(R.string.openB));
            values.put(ANSWER4, AppLan.getAppContext().getResources().getString(R.string.opeLap));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(NAME, AppLan.getAppContext().getResources().getString(R.string.glass));
            values.put(ANSWER1, AppLan.getAppContext().getResources().getString(R.string.drink));
            values.put(ANSWER2, AppLan.getAppContext().getResources().getString(R.string.eat));
            values.put(ANSWER3, AppLan.getAppContext().getResources().getString(R.string.goldfish));
            values.put(ANSWER4, AppLan.getAppContext().getResources().getString(R.string.pot));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(NAME, AppLan.getAppContext().getResources().getString(R.string.toaster));
            values.put(ANSWER1, AppLan.getAppContext().getResources().getString(R.string.make_toasts));
            values.put(ANSWER2, AppLan.getAppContext().getResources().getString(R.string.roast));
            values.put(ANSWER3, AppLan.getAppContext().getResources().getString(R.string.make_tea));
            values.put(ANSWER4, AppLan.getAppContext().getResources().getString(R.string.call));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(NAME, AppLan.getAppContext().getResources().getString(R.string.fireex));
            values.put(ANSWER1, AppLan.getAppContext().getResources().getString(R.string.exti));
            values.put(ANSWER2, AppLan.getAppContext().getResources().getString(R.string.make_fire));
            values.put(ANSWER3, AppLan.getAppContext().getResources().getString(R.string.blow));
            values.put(ANSWER4, AppLan.getAppContext().getResources().getString(R.string.smash2));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(NAME, AppLan.getAppContext().getResources().getString(R.string.usb_game5));
            values.put(ANSWER1, AppLan.getAppContext().getResources().getString(R.string.save));
            values.put(ANSWER2, AppLan.getAppContext().getResources().getString(R.string.open_b));
            values.put(ANSWER3, AppLan.getAppContext().getResources().getString(R.string.make_f));
            values.put(ANSWER4, AppLan.getAppContext().getResources().getString(R.string.open_door));
            db.insert(TABLE_NAME, null, values);
            values.clear();
            values.put(NAME, AppLan.getAppContext().getResources().getString(R.string.tablet_game5));
            values.put(ANSWER1, AppLan.getAppContext().getResources().getString(R.string.tablet));
            values.put(ANSWER2, AppLan.getAppContext().getResources().getString(R.string.photo_frame));
            values.put(ANSWER3, AppLan.getAppContext().getResources().getString(R.string.placemats));
            values.put(ANSWER4, AppLan.getAppContext().getResources().getString(R.string.book));
            db.insert(TABLE_NAME, null, values);
            values.clear();


            // db.close();

        }

        static ArrayList<ObjectT> takeObjectsFromDB() {

            //Query from db
            ArrayList<ObjectT> queryResultsList = new ArrayList<>();
            dh = new DatabaseHandler(Game5.getMyCont());
            db = dh.getWritableDatabase();
            String data;

            String selectQuery = "SELECT * FROM " + TABLE_NAME;

            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ObjectT tempObjectT = new ObjectT();
                data = cursor.getString(cursor.getColumnIndexOrThrow(NAME));
                tempObjectT.name = data;
                data = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER1));
                tempObjectT.answers.add(data);
                data = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER2));
                tempObjectT.answers.add(data);
                data = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER3));
                tempObjectT.answers.add(data);
                data = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER4));
                tempObjectT.answers.add(data);
                queryResultsList.add(tempObjectT);
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
