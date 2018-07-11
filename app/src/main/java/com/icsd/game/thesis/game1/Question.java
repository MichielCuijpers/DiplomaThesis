package com.icsd.game.thesis.game1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.icsd.game.thesis.database.DatabaseHandler;

import java.util.ArrayList;

public class Question {
    ArrayList<String> answers;
    private String question;


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
        static DatabaseHandler dh = new DatabaseHandler(Game1Activity.getMyCont());
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

            db = dh.getWritableDatabase()
            db.execSQL("DROP TABLE IF EXISTS " + Question.QuestionDBEntry.TABLE_NAME);
            db.execSQL(Question.QuestionDBEntry.SQL_CREATE_ENTRIES);
            ContentValues values = new ContentValues();

            values.put(QuestionDBEntry.QUESTION, "QUESTION 1");
            values.put(QuestionDBEntry.CATEGORY, "Category 1");
            values.put(QuestionDBEntry.ANSWER1, "Answer 1");
            values.put(QuestionDBEntry.ANSWER2, "Answer 2");
            values.put(QuestionDBEntry.ANSWER3, "Answer 3");
            values.put(QuestionDBEntry.ANSWER4, "Answer 4");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "QUESTION 2");
            values.put(QuestionDBEntry.CATEGORY, "Category 2");
            values.put(QuestionDBEntry.ANSWER1, "Answer 1");
            values.put(QuestionDBEntry.ANSWER2, "Answer 2");
            values.put(QuestionDBEntry.ANSWER3, "Answer 3");
            values.put(QuestionDBEntry.ANSWER4, "Answer 4");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "QUESTION 3");
            values.put(QuestionDBEntry.CATEGORY, "Category 4");
            values.put(QuestionDBEntry.ANSWER1, "Answer 1");
            values.put(QuestionDBEntry.ANSWER2, "Answer 2");
            values.put(QuestionDBEntry.ANSWER3, "Answer 3");
            values.put(QuestionDBEntry.ANSWER4, "Answer 4");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "QUESTION 4");
            values.put(QuestionDBEntry.CATEGORY, "Category 4");
            values.put(QuestionDBEntry.ANSWER1, "Answer 1");
            values.put(QuestionDBEntry.ANSWER2, "Answer 2");
            values.put(QuestionDBEntry.ANSWER3, "Answer 3");
            values.put(QuestionDBEntry.ANSWER4, "Answer 4");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);

            db.close();
        }

        private static ArrayList<String> takeQuestionFromDB(String category) {
            //Query from db
            ArrayList<String> queryResultsList = new ArrayList<>();
            db = dh.getWritableDatabase();
            String[] projection = {
                    QUESTION,
                    CATEGORY,
                    ANSWER1,
                    ANSWER2,
                    ANSWER3,
                    ANSWER4

            };
            String selection = CATEGORY + " = ?";
            String[] selectionArgs = {category};
            Cursor cursor = db.query(
                    TABLE_NAME,   // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    selection,              // The columns for the WHERE clause
                    selectionArgs,          // The values for the WHERE clause
                    null,                   // don't group the rows
                    null,                   // don't filter by row groups
                    null               // The sort order
            );
            while (cursor.moveToNext()) {
                String question = cursor.getString(
                        cursor.getColumnIndexOrThrow(_ID));
                queryResultsList.add(question);


            }
            cursor.close();
        return queryResultsList;
        }
        //END INNER CLASS
    }


}