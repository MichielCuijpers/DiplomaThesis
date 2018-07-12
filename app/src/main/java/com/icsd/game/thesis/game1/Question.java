package com.icsd.game.thesis.game1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.icsd.game.thesis.database.DatabaseHandler;

import java.util.ArrayList;

public class Question {
    final ArrayList<String> answers;
    private final String question;


    protected Question(String category) {
        answers = new ArrayList<>();
        ArrayList<String> temp = QuestionDBEntry.takeQuestionFromDB(category);
        this.question = temp.get(0);
        this.answers.add(temp.get(1));
        this.answers.add(temp.get(2));
        this.answers.add(temp.get(3));
        this.answers.add(temp.get(4));
    }

    public String getQuestion() {
        return question;
    }


    public ArrayList<String> getAnswers() {
        return answers;
    }

    //START INNER CLASS
    public static class QuestionDBEntry implements BaseColumns {
        static final DatabaseHandler dh = new DatabaseHandler(Game1Activity.getMyCont());
        static SQLiteDatabase db;
        public static final String TABLE_NAME = "question";
        public static final String QUESTION = "question";
        public static final String CATEGORY = "category";
        public static final String ANSWER1 = "answer1";
        public static final String ANSWER2 = "answer2";
        public static final String ANSWER3 = "answer3";
        public static final String ANSWER4 = "ansewr4";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        QUESTION + " TEXT, "
                        + CATEGORY + " TEXT, "
                        + ANSWER1 + " TEXT, "
                        + ANSWER2 + " TEXT, "
                        + ANSWER3 + " TEXT, "
                        + ANSWER4 + " TEXT)";


        protected static void addTestQuestionToDB() {

            db = dh.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + Question.QuestionDBEntry.TABLE_NAME);
            db.execSQL(Question.QuestionDBEntry.SQL_CREATE_ENTRIES);
            ContentValues values = new ContentValues();

            values.put(QuestionDBEntry.QUESTION, "what is the world's longest river?");
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, "amazon");
            values.put(QuestionDBEntry.ANSWER2, "mississippi");
            values.put(QuestionDBEntry.ANSWER3, "niger");
            values.put(QuestionDBEntry.ANSWER4, "Amur–Argun");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, " When did the World War II begin?");
            values.put(QuestionDBEntry.CATEGORY, "history");
            values.put(QuestionDBEntry.ANSWER1, "1939");
            values.put(QuestionDBEntry.ANSWER2, "1914");
            values.put(QuestionDBEntry.ANSWER3, "1945");
            values.put(QuestionDBEntry.ANSWER4, "1950");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "What is the painting 'La Gioconda' more usually known as?");
            values.put(QuestionDBEntry.CATEGORY, "art");
            values.put(QuestionDBEntry.ANSWER1, "mona lisa");
            values.put(QuestionDBEntry.ANSWER2, "Picaso's wife");
            values.put(QuestionDBEntry.ANSWER3, "lisa");
            values.put(QuestionDBEntry.ANSWER4, "enigmatic woman");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "Why did people use to salt meat taken on ships?");
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, "So it would stay good longer");
            values.put(QuestionDBEntry.ANSWER2, "For taste reasons");
            values.put(QuestionDBEntry.ANSWER3, "to consume fewer");
            values.put(QuestionDBEntry.ANSWER4, "Answer 4");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);

            values.put(QuestionDBEntry.QUESTION, "Which of these words is the antonym of 'old'?");
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, "newt ");
            values.put(QuestionDBEntry.ANSWER2, "brillant");
            values.put(QuestionDBEntry.ANSWER4, "raw");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);

            values.put(QuestionDBEntry.QUESTION, " Who invented airplanes?");
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, "Wright brothers");
            values.put(QuestionDBEntry.ANSWER2, "Isaac Newton");
            values.put(QuestionDBEntry.ANSWER3, "Benjamin Franklin");
            values.put(QuestionDBEntry.ANSWER4, "Patrick Alexander");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);

            db.close();
        }

        private static ArrayList<String> takeQuestionFromDB(String category) {
            Log.e("DEBUGMY", "AAA");
            //Query from db
            ArrayList<String> queryResultsList = new ArrayList<>();
            db = dh.getWritableDatabase();
            String question = "AAF";
            String[] projection = {
                    _ID,
                    QUESTION,
                    CATEGORY,
                    ANSWER1,
                    ANSWER2,
                    ANSWER3,
                    ANSWER4

            };
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + CATEGORY + " = " + "'" + category + "'";

            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                question = cursor.getString(cursor.getColumnIndexOrThrow(QUESTION));
                queryResultsList.add(question);
                question = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER1));
                queryResultsList.add(question);
                question = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER2));
                queryResultsList.add(question);
                question = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER3));
                queryResultsList.add(question);
                question = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER4));
                queryResultsList.add(question);
                cursor.moveToNext();


            }
            cursor.close();

            return queryResultsList;
        }

    }
    //END INNER CLASS
}


