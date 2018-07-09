package com.icsd.game.thesis.database;

import android.provider.BaseColumns;

public class User {
    private User() {
    }

    public static class UserDBEntry implements BaseColumns {

        public static final String TABLE_NAME = "user";
        public static final String NICKNAME = "nickname";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + User.UserDBEntry.TABLE_NAME + " (" +
                        User.UserDBEntry._ID + " INTEGER PRIMARY KEY,"
                        + User.UserDBEntry.NICKNAME + " TEXT)";

    }
}
