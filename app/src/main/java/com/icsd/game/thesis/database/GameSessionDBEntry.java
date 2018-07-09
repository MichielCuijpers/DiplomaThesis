package com.icsd.game.thesis.database;

import android.provider.BaseColumns;

public class GameSessionDBEntry implements BaseColumns {
    public static final String TABLE_NAME = "gameSession";
    public static final String USER_ID = "userId";
    public static final String GAME_ID = "gameId";
    public static final String SCORE = "score";
    public static final String STAGES_COMPLETED = "stagesCompleted";
    public static final String FAILS = "fails";
    public static final String TIME__PLAYED = "timePlayed";
    public static final String HELP_USED = "helpUsed";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY,"
                    + SCORE + "INTEGER, "
                    + STAGES_COMPLETED + "INTEGER, "
                    + FAILS + "INTEGER, "
                    + TIME__PLAYED + "DOUBLE, "
                    + USER_ID + "INTEGER, "
                    + GAME_ID + "INTEGER, "
                    + "FOREIGN KEY(" + USER_ID + ") REFERENCES user(" + User.UserDBEntry._ID + "),"
                    + "FOREIGN KEY(" + GAME_ID + ") REFERENCES user(" + GameDBEntry._ID + ")) ";
}
