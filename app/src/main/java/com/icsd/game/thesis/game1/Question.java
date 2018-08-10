package com.icsd.game.thesis.game1;

import android.content.ContentValues;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.game4.Game4Activity;

import java.util.ArrayList;

public class Question {
     final ArrayList<String> answers;
   final String question;


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
        static DatabaseHandler dh;
        static SQLiteDatabase db;
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

            values.put(QuestionDBEntry.QUESTION, "what is the world's longest river?");
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, "amazon");
            values.put(QuestionDBEntry.ANSWER2, "mississippi");
            values.put(QuestionDBEntry.ANSWER3, "niger");
            values.put(QuestionDBEntry.ANSWER4, "Amur–Argun");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "What is Earth's largest continent?");
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, "asia");
            values.put(QuestionDBEntry.ANSWER2, "europe");
            values.put(QuestionDBEntry.ANSWER3, "antartica");
            values.put(QuestionDBEntry.ANSWER4, "africa");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "In what country can you visit Machu Picchu?");
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, "peru");
            values.put(QuestionDBEntry.ANSWER2, "chile");
            values.put(QuestionDBEntry.ANSWER3, "bolivia");
            values.put(QuestionDBEntry.ANSWER4, "columbia");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "What is the oldest city in the world?");
            values.put(QuestionDBEntry.CATEGORY, "geography");
            values.put(QuestionDBEntry.ANSWER1, "damascus");
            values.put(QuestionDBEntry.ANSWER2, "athens");
            values.put(QuestionDBEntry.ANSWER3, "jericho");
            values.put(QuestionDBEntry.ANSWER4, "jerusalim");
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

            values.put(QuestionDBEntry.QUESTION, " What was the last battle of the Napoleonic Wars?");
            values.put(QuestionDBEntry.CATEGORY, "history");
            values.put(QuestionDBEntry.ANSWER1, "wavre");
            values.put(QuestionDBEntry.ANSWER2, "nile");
            values.put(QuestionDBEntry.ANSWER3, "waterloo");
            values.put(QuestionDBEntry.ANSWER4, "trafalgar");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "What was the first city to reach a population of one million?");
            values.put(QuestionDBEntry.CATEGORY, "history");
            values.put(QuestionDBEntry.ANSWER1, "rome");
            values.put(QuestionDBEntry.ANSWER2, "new york");
            values.put(QuestionDBEntry.ANSWER3, "london");
            values.put(QuestionDBEntry.ANSWER4, "beijing");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, " Which of the following empires had no written language?");
            values.put(QuestionDBEntry.CATEGORY, "history");
            values.put(QuestionDBEntry.ANSWER1, "incan empire");
            values.put(QuestionDBEntry.ANSWER2, "aztec empire");
            values.put(QuestionDBEntry.ANSWER3, "roman empire");
            values.put(QuestionDBEntry.ANSWER4, "tang dynasty");
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

            values.put(QuestionDBEntry.QUESTION, "Who is credited as the designer of the many statues which decorated the Parthenon?");
            values.put(QuestionDBEntry.CATEGORY, "art");
            values.put(QuestionDBEntry.ANSWER1, "phidias");
            values.put(QuestionDBEntry.ANSWER2, "Praxiteles");
            values.put(QuestionDBEntry.ANSWER3, "scopas");
            values.put(QuestionDBEntry.ANSWER4, "hesiod");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "How many paintings did Vincent Van Gogh sell during his lifetime?");
            values.put(QuestionDBEntry.CATEGORY, "art");
            values.put(QuestionDBEntry.ANSWER1, "1");
            values.put(QuestionDBEntry.ANSWER2, "27");
            values.put(QuestionDBEntry.ANSWER3, "193");
            values.put(QuestionDBEntry.ANSWER4, "842");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);

            values.clear();
            values.put(QuestionDBEntry.QUESTION, "Which color is vermillion");
            values.put(QuestionDBEntry.CATEGORY, "art");
            values.put(QuestionDBEntry.ANSWER1, "red");
            values.put(QuestionDBEntry.ANSWER2, "green");
            values.put(QuestionDBEntry.ANSWER3, "yellow");
            values.put(QuestionDBEntry.ANSWER4, "blue");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "What is the national dish of Italy?");
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, "pasta");
            values.put(QuestionDBEntry.ANSWER2, "mousaka");
            values.put(QuestionDBEntry.ANSWER3, "burger");
            values.put(QuestionDBEntry.ANSWER4, "fried potatoes");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "What food is the leading source of salmonella poisoning?");
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, "chicken");
            values.put(QuestionDBEntry.ANSWER2, "beef");
            values.put(QuestionDBEntry.ANSWER3, "pork");
            values.put(QuestionDBEntry.ANSWER4, "fish");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "What is the most popular spice in the world?");
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, "pepper");
            values.put(QuestionDBEntry.ANSWER2, "salt");
            values.put(QuestionDBEntry.ANSWER3, "paprika");
            values.put(QuestionDBEntry.ANSWER4, "safran");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "Which European country is credited for the invention of hot dogs?");
            values.put(QuestionDBEntry.CATEGORY, "food");
            values.put(QuestionDBEntry.ANSWER1, "germany");
            values.put(QuestionDBEntry.ANSWER2, "austria");
            values.put(QuestionDBEntry.ANSWER3, "finland");
            values.put(QuestionDBEntry.ANSWER4, "belgium");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "Which of these words is the antonym of 'old'?");
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, "new ");
            values.put(QuestionDBEntry.ANSWER2, "brillant");
            values.put(QuestionDBEntry.ANSWER3, "raw");
            values.put(QuestionDBEntry.ANSWER4, "raw");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "Thalassophobia is a fear of what?");
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, "the sea");
            values.put(QuestionDBEntry.ANSWER2, "the mountains");
            values.put(QuestionDBEntry.ANSWER3, "the crowd");
            values.put(QuestionDBEntry.ANSWER4, "the dogs");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "Which of these would, except in a figurative sense, not normally combine with 'BOOKS'?");
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, "a stack");
            values.put(QuestionDBEntry.ANSWER2, "a mountain");
            values.put(QuestionDBEntry.ANSWER3, "a heap");
            values.put(QuestionDBEntry.ANSWER4, "a stack");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "Which of the following is the meaning of \"tutti frutti\"?");
            values.put(QuestionDBEntry.CATEGORY, "directory");
            values.put(QuestionDBEntry.ANSWER1, "Flavor of many fruits combined");
            values.put(QuestionDBEntry.ANSWER2, "Ice-cream containing small pieces of candied or fresh fruit");
            values.put(QuestionDBEntry.ANSWER3, " A preserve of chopped mixed fruits");
            values.put(QuestionDBEntry.ANSWER4, "All of these meanings");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, " Who invented airplanes?");
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, "Wright brothers");
            values.put(QuestionDBEntry.ANSWER2, "Isaac Newton");
            values.put(QuestionDBEntry.ANSWER3, "Benjamin Franklin");
            values.put(QuestionDBEntry.ANSWER4, "Patrick Alexander");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "What is the unit of currency in Russia??");
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, "ruble");
            values.put(QuestionDBEntry.ANSWER2, "lira");
            values.put(QuestionDBEntry.ANSWER3, "euro");
            values.put(QuestionDBEntry.ANSWER4, "lev");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "Which planet is nearest the sun? ");
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, "mercury");
            values.put(QuestionDBEntry.ANSWER2, "poseidon");
            values.put(QuestionDBEntry.ANSWER3, "jupiter");
            values.put(QuestionDBEntry.ANSWER4, "uranu");
            db.insert(QuestionDBEntry.TABLE_NAME, null, values);
            values.clear();

            values.put(QuestionDBEntry.QUESTION, "Who said, “I think, therefore I am”? ");
            values.put(QuestionDBEntry.CATEGORY, "general");
            values.put(QuestionDBEntry.ANSWER1, "Descartes");
            values.put(QuestionDBEntry.ANSWER2, "Plato");
            values.put(QuestionDBEntry.ANSWER3, "Aristotle");
            values.put(QuestionDBEntry.ANSWER4, "Isaac Newton");
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


