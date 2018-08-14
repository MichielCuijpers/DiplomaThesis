package com.icsd.game.thesis.database;

import android.provider.BaseColumns;

public class Highscore {


    public class HighscoreDBEntry implements BaseColumns {

        public static final String TABLE_NAME = "highscore";
        public static final String USER_ID = "userId";
        public static final String GAME_ID = "gameId";
        public static final String HIGHSCORE = "highscore";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + HIGHSCORE + " INTEGER, "
                        + USER_ID + " TEXT, "
                        + GAME_ID + " INTEGER, "
                        + "FOREIGN KEY(" + USER_ID + ") REFERENCES user(" + User.UserDBEntry._ID + "),"
                        + "FOREIGN KEY(" + GAME_ID + ") REFERENCES user(" + GameDBEntry._ID + ")) ";
    }
}