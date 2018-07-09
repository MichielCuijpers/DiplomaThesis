package com.icsd.game.thesis.game1;

import android.provider.BaseColumns;

import com.icsd.game.thesis.database.User;

public class QuestionDBEntry implements BaseColumns {
    public static final String TABLE_NAME = "question";
    public static final String QUESTION = "question";
    public static final String CATEGORY = "category";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    QUESTION + " TEXT, "
                    + CATEGORY + " TEXT)";
}
