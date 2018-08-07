package com.icsd.game.thesis.database;

import android.provider.BaseColumns;

public class User {
    private String username;
    public User(String i) {
        this.username = i;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    public static class UserDBEntry implements BaseColumns {

        public static final String TABLE_NAME = "user";
        public static final String NICKNAME = "nickname";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + User.UserDBEntry.TABLE_NAME + " (" +
                        User.UserDBEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + User.UserDBEntry.NICKNAME + " TEXT)";

    }

}
