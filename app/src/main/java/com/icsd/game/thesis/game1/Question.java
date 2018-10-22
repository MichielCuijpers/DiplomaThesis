package com.icsd.game.thesis.game1;

import android.content.ContentValues;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.AppLan;
import com.icsd.game.thesis.database.DatabaseHandler;

import java.util.ArrayList;

public class Question {
    private final ArrayList<String> answers;
    private String question;


    protected Question(ArrayList<String> temp) {
        answers = new ArrayList<>();

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
        private static DatabaseHandler dh;
        private static SQLiteDatabase db;
        public static final String TABLE_NAME = "question";
        public static final String TABLE_NAME2 = "question_gr";
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


        public static void addQuestionsToDB(SQLiteDatabase db) {


            db.execSQL("DROP TABLE IF EXISTS " + Question.QuestionDBEntry.TABLE_NAME);
            db.execSQL(Question.QuestionDBEntry.SQL_CREATE_ENTRIES);
            ContentValues values = new ContentValues();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q1));
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q1));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q1));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q1));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q1));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q2));
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q2));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q2));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q2));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q2));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q3));
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q3));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q3));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q3));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q3));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q4));
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q4));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q4));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q4));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q4));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q5));
            values.put(QuestionDBEntry.CATEGORY, "history");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q5));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q5));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q5));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q5));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q6));
            values.put(QuestionDBEntry.CATEGORY, "history");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q6));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q6));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q6));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q6));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q7));
            values.put(QuestionDBEntry.CATEGORY, "history");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q7));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q7));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q7));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q7));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q8));
            values.put(QuestionDBEntry.CATEGORY, "history");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q8));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q8));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q8));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q8));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q9));
            values.put(QuestionDBEntry.CATEGORY, "art");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q9));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q9));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q9));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q9));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q10));
            values.put(QuestionDBEntry.CATEGORY, "art");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q10));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q10));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q10));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q10));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q11));
            values.put(QuestionDBEntry.CATEGORY, "art");
            values.put(QuestionDBEntry.ANSWER1, "1");
            values.put(QuestionDBEntry.ANSWER2, "27");
            values.put(QuestionDBEntry.ANSWER3, "193");
            values.put(QuestionDBEntry.ANSWER4, "842");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);

            values.clear();
            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q12));
            values.put(QuestionDBEntry.CATEGORY, "art");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q12));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q12));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q12));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q12));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q13));
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q13));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q13));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q13));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q13));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q14));
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q14));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q14));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q14));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q14));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q15));
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q15));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q15));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q15));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q15));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q16));
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q16));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q16));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q16));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q16));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q17));
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q17));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q17));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q17));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q17));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q18));
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q18));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q18));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q18));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q18));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q19));
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q19));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q19));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q19));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q19));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q20));
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q20));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q20));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q20));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q20));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q21));
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q21));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q21));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q21));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q21));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q22));
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q22));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q22));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q22));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q22));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q23));
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q23));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q23));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q23));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q23));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, AppLan.getAppContext().getResources().getString(R.string.q24));
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, AppLan.getAppContext().getResources().getString(R.string.an1q24));
            values.put(QuestionDBEntry.ANSWER2, AppLan.getAppContext().getResources().getString(R.string.an2q24));
            values.put(QuestionDBEntry.ANSWER3, AppLan.getAppContext().getResources().getString(R.string.an3q24));
            values.put(QuestionDBEntry.ANSWER4, AppLan.getAppContext().getResources().getString(R.string.an4q24));
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);


            // db.close();
        }

        protected static ArrayList<String> takeQuestionFromDB(String category) {
            Log.e("DEBUGMY", "AAA");
            //Query from db
            dh = new DatabaseHandler(Game1Activity.getMyCont());
            ArrayList<String> queryResultsList = new ArrayList<>();
            db = dh.getWritableDatabase();
            String question;
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


