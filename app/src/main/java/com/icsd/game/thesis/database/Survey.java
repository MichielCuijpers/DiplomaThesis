package com.icsd.game.thesis.database;

import android.provider.BaseColumns;

public class Survey {
    public class SurveyResultsDBEntry implements BaseColumns {

        public static final String TABLE_NAME = "survey";
        public static final String QUESTION = "question";
        public static final String ANSWER = "answer";
        public static final String GAME_ID = "game_id";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + QUESTION + " TEXT, "
                        + ANSWER + " INTEGER, "
                        + GAME_ID + " INTEGER) ";

    }

    public class SurveyQuestionDBEntry implements BaseColumns {

        public static final String TABLE_NAME = "survey_question";
        public static final String QUESTION = "question";
        public static final String TYPE = "type";


        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + QUESTION + " TEXT, "
                        + TYPE + " INTEGER)";

    }
}
