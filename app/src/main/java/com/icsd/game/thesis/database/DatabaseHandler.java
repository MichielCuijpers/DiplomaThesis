package com.icsd.game.thesis.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;

import com.icsd.game.thesis.commons.AppLan;
import com.icsd.game.thesis.commons.LoginActivity;
import com.icsd.game.thesis.game1.Question;
import com.icsd.game.thesis.game4.Word;
import com.icsd.game.thesis.game5.ObjectT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";

    private SQLiteDatabase dba = getWritableDatabase();

    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Context myCont = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        Log.e("MYDEBUG", "onCreate Start DB");
//        db.execSQL("DROP TABLE IF EXISTS " + User.UserDBEntry.TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS " + GameDBEntry.TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS " + Session.GameSessionDBEntry.TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS " + Highscore.HighscoreDBEntry.TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS " + Survey.SurveyResultsDBEntry.TABLE_NAME);
//        db.execSQL(GameDBEntry.SQL_CREATE_ENTRIES);
//        db.execSQL(User.UserDBEntry.SQL_CREATE_ENTRIES);
//        db.execSQL(Session.GameSessionDBEntry.SQL_CREATE_ENTRIES);
//        db.execSQL(Highscore.HighscoreDBEntry.SQL_CREATE_ENTRIES);
//        db.execSQL(Survey.SurveyResultsDBEntry.SQL_CREATE_ENTRIES);
        db.execSQL("DROP TABLE IF EXISTS " + Question.QuestionDBEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Survey.SurveyQuestionDBEntry.TABLE_NAME);
        db.execSQL(Question.QuestionDBEntry.SQL_CREATE_ENTRIES);
        db.execSQL(Survey.SurveyQuestionDBEntry.SQL_CREATE_ENTRIES);
        Survey.SurveyQuestionDBEntry.addSurvQuestionsToDB(db);
        Question.QuestionDBEntry.addQuestionsToDB(db);
        Word.WordDBEntry.addTestWordsToDB(db);
        ObjectT.ObjectDBEntry.addTestObjectToDB(db);
        Log.e("MYDEBUG", "onCreate END DB");




    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean addUserToDB(User user, SQLiteDatabase db) {
        if (checkIfUserExists(db, user.getUsername())) {
            //SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(User.UserDBEntry.NICKNAME, user.getUsername());

            db.insert(User.UserDBEntry.TABLE_NAME, null, values);
            Log.e("MYDEBUG", "user saved to dbn");
            // db.close();
            return true;
        }
        return false;
    }

    public Boolean checkIfUserExists(SQLiteDatabase db, String user) {
        String Query = "Select * from " + User.UserDBEntry.TABLE_NAME + " where " + User.UserDBEntry.NICKNAME + " ='" + user + "' ";
        Log.e("MYDEBUG", Query);

        Cursor cursor = db.rawQuery(Query, null);
        Log.e("MYDEBUG", "IN check is already " + cursor.getCount());
        if (cursor.getCount() <= 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    public void addSessionToDB(Session session) {

        ContentValues values = new ContentValues();
        SQLiteDatabase db = LoginActivity.getDb();
        values.put(Session.GameSessionDBEntry.SCORE, session.getScore());
        values.put(Session.GameSessionDBEntry.STAGES_COMPLETED, session.getStage());
        values.put(Session.GameSessionDBEntry.FAILS, session.getFails());
        values.put(Session.GameSessionDBEntry.TIME__PLAYED, (session.getTimeEnd() - session.getTimeStart()));
        values.put(Session.GameSessionDBEntry.USER_ID, session.getUserId());
        values.put(Session.GameSessionDBEntry.GAME_ID, session.getGameID());
        db.insert(Session.GameSessionDBEntry.TABLE_NAME, null, values);
        // db.close();
        addHighscoreToDB(session.getScore(), session.getUserId(), session.getGameID());
        Log.e("DEBUGMY", "Session saved to db");

    }

    public void addHighscoreToDB(int highscore, String user, int gameID) {
        SQLiteDatabase db = LoginActivity.getDb();
        if (!checkIsDataAlreadyInDBorNot(user, db)) {
            ContentValues values = new ContentValues();
            values.put(Highscore.HighscoreDBEntry.HIGHSCORE, highscore);
            values.put(Highscore.HighscoreDBEntry.USER_ID, user);
            values.put(Highscore.HighscoreDBEntry.GAME_ID, gameID);
            db.insert(Highscore.HighscoreDBEntry.TABLE_NAME, null, values);
            Log.e("MYDEBUG", "HighScore saved to db");
            Log.e("MYDEBUG", "First High");
        } else {

            if (checkIfHighScore(highscore, gameID, user, db)) {
                String where = Highscore.HighscoreDBEntry.GAME_ID + " = " + gameID + " AND " + Highscore.HighscoreDBEntry.USER_ID + " ='" + user + "' ";
                ContentValues values = new ContentValues();
                values.put(Highscore.HighscoreDBEntry.HIGHSCORE, highscore);
                db.update(Highscore.HighscoreDBEntry.TABLE_NAME, values, where, null);
                Log.e("MYDEBUG", "HighUpdated");
            } else {
                Log.e("MYDEBUG", "High to need to update");
            }
        }


    }

    public static void saveSurveyResultsToDB(ArrayList<Integer> answers, ArrayList<String> questions, int type, int gameID) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = LoginActivity.getDb();
        String username = LoginActivity.getUser().getUsername();
        for (int i = 0; i < answers.size(); i++) {
            values.put(Survey.SurveyResultsDBEntry.QUESTION, questions.get(i));
            values.put(Survey.SurveyResultsDBEntry.ANSWER, answers.get(i));
            values.put(Survey.SurveyResultsDBEntry.USER, username);
            values.put(Survey.SurveyResultsDBEntry.GAME_ID, gameID);
            db.insert(Survey.SurveyResultsDBEntry.TABLE_NAME, null, values);
            values.clear();
        }


    }

    private static boolean checkIfHighScore(int newScore, int gameID, String user, SQLiteDatabase db) {
        String Query = "Select * from " + Highscore.HighscoreDBEntry.TABLE_NAME + " where " + Highscore.HighscoreDBEntry.USER_ID + " ='" + user + "' AND " + Highscore.HighscoreDBEntry.GAME_ID + " = " + gameID;
        Cursor cursor = db.rawQuery(Query, null);
        //while (!cursor.isAfterLast()) {
        if (cursor.getColumnIndex(Highscore.HighscoreDBEntry.HIGHSCORE) < newScore) {
            return true;
        }
        // cursor.moveToNext();
        //}
        return false;
    }

    public static boolean checkIsDataAlreadyInDBorNot(String user, SQLiteDatabase db) {

        String Query = "Select * from " + Highscore.HighscoreDBEntry.TABLE_NAME + " where " + Highscore.HighscoreDBEntry.USER_ID + " ='" + user + "' ";
        Log.e("MYDEBUG", Query);

        Cursor cursor = db.rawQuery(Query, null);
        Log.e("MYDEBUG", "IN check is already " + cursor.getCount());
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception ex) {
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public static HashMap<Integer, Integer> getHighscoresFromDB() {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        String question;
        String selectQuery = "SELECT * FROM " + Highscore.HighscoreDBEntry.TABLE_NAME;

        Cursor cursor = LoginActivity.getDb().rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            hmap.put(cursor.getInt(cursor.getColumnIndexOrThrow(Highscore.HighscoreDBEntry.GAME_ID)), cursor.getInt(cursor.getColumnIndexOrThrow(Highscore.HighscoreDBEntry.HIGHSCORE)));
            cursor.moveToNext();


        }
        cursor.close();

        return hmap;
    }

    public static void exportDBtoCsv() {
        DatabaseHandler dh = new DatabaseHandler(AppLan.getAppContext());
        File exportDir = new File(Environment.getExternalStorageDirectory(), "");

        if (!exportDir.exists()) {
            exportDir.mkdirs();
        }
        File file = new File(exportDir, "game_ses.csv");

        try {
            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
            SQLiteDatabase db = dh.getReadableDatabase();
            Cursor curCSV = db.rawQuery("SELECT * FROM gameSession", null);
            csvWrite.writeNext(curCSV.getColumnNames());
            while (curCSV.moveToNext()) {
                //Which column you want to exprort
                String arrStr[] = {curCSV.getString(0), curCSV.getString(1), curCSV.getString(2), curCSV.getString(3), curCSV.getString(4), curCSV.getString(5), curCSV.getString(6)};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
        } catch (Exception sqlEx) {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }

        File file2 = new File(exportDir, "survey_results.csv");
        try {
            file2.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file2));
            SQLiteDatabase db = dh.getReadableDatabase();
            Cursor curCSV = db.rawQuery("SELECT * FROM  survey_result", null);
            csvWrite.writeNext(curCSV.getColumnNames());
            while (curCSV.moveToNext()) {
                //Which column you want to exprort
                String arrStr[] = {curCSV.getString(0), curCSV.getString(1), curCSV.getString(2), curCSV.getString(3), curCSV.getString(4)};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
        } catch (Exception sqlEx) {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }


    }

}
