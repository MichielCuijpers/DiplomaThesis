package com.icsd.game.thesis.database;

import android.provider.BaseColumns;

public class GameDBEntry implements BaseColumns {
    public static final String TABLE_NAME = "game";
    public static final String DESCRIPTION = "description";
    public static final String CATEGORY = "category";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +DESCRIPTION + " TEXT,"
                    + CATEGORY + " TEXT)";


}