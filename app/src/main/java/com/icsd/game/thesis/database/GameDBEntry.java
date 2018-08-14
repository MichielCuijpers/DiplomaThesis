package com.icsd.game.thesis.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.icsd.game.thesis.R;

public class GameDBEntry implements BaseColumns {
    public static final String TABLE_NAME = "game";
    private static final String DESCRIPTION = "description";
    private static final String CATEGORY = "category";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DESCRIPTION + " TEXT,"
                    + CATEGORY + " TEXT)";

    public static void addGamesToDB(SQLiteDatabase db, Context context) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(SQL_CREATE_ENTRIES);

        ContentValues values = new ContentValues();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game1Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();

        values.put(DESCRIPTION, context.getResources().getString(R.string.game2Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();

        values.put(DESCRIPTION, context.getResources().getString(R.string.game3Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();

        values.put(DESCRIPTION, context.getResources().getString(R.string.game4Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game5Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game6Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game7Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game8Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game9Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game10Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game11Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game12Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game13Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game14Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();
        values.put(DESCRIPTION, context.getResources().getString(R.string.game15Des));
        values.put(CATEGORY, context.getResources().getString(R.string.categoryG1));
        db.insert(TABLE_NAME, null, values);
        values.clear();


    }

}