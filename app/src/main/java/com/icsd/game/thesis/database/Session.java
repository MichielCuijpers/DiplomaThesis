package com.icsd.game.thesis.database;

import android.provider.BaseColumns;

public class Session {
    private final String userId;
    private final int gameID;
    private int score;
    private int stage;
    private int fails;
    private double timeStart;
    private double timeEnd;
    private int helpUsed;

    public Session(String userid, int gameId) {

        userId = userid;
        score = 0;
        gameID = gameId;
        stage = 0;
        helpUsed = 0;
        timeEnd = 0;
        timeStart = 0;
        fails = 0;
    }

    public class GameSessionDBEntry implements BaseColumns {
        public static final String TABLE_NAME = "gameSession";
        public static final String USER_ID = "userId";
        public static final String GAME_ID = "gameId";
        public static final String SCORE = "score";
        public static final String STAGES_COMPLETED = "stagesCompleted";
        public static final String FAILS = "fails";
        public static final String TIME__PLAYED = "timePlayed";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + SCORE + " INTEGER, "
                        + STAGES_COMPLETED + " INTEGER, "
                        + FAILS + " INTEGER, "
                        + TIME__PLAYED + " DOUBLE, "
                        + USER_ID + " TEXT, "
                        + GAME_ID + " INTEGER, "
                        + "FOREIGN KEY(" + USER_ID + ") REFERENCES user(" + User.UserDBEntry._ID + "),"
                        + "FOREIGN KEY(" + GAME_ID + ") REFERENCES user(" + GameDBEntry._ID + ")) ";
    }

    public String getUserId() {
        return userId;
    }

    public int getGameID() {
        return gameID;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }

    public void setTimeStart(double timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(double timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setHelpUsed(int helpUsed) {
        this.helpUsed = helpUsed;
    }

    public int getScore() {
        return score;
    }

    public int getStage() {
        return stage;
    }

    public int getFails() {
        return fails;
    }

    public double getTimeStart() {
        return timeStart;
    }

    public double getTimeEnd() {
        return timeEnd;
    }

    public int getHelpUsed() {
        return helpUsed;
    }

}