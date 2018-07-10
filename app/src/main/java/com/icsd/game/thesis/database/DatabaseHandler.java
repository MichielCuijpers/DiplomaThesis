package com.icsd.game.thesis.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.icsd.game.thesis.game1.QuestionDBEntry;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionDBEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + User.UserDBEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GameDBEntry.TABLE_NAME);

        db.execSQL("DROP TABLE IF EXISTS " + Session.GameSessionDBEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + HighscoreDBEntry.TABLE_NAME);

        db.execSQL(QuestionDBEntry.SQL_CREATE_ENTRIES);
        db.execSQL(GameDBEntry.SQL_CREATE_ENTRIES);
        db.execSQL(User.UserDBEntry.SQL_CREATE_ENTRIES);

        db.execSQL(Session.GameSessionDBEntry.SQL_CREATE_ENTRIES);
        db.execSQL(HighscoreDBEntry.SQL_CREATE_ENTRIES);
        Log.e("MYDEBUG", "TABLES CREATED");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addSessionToDB(Session session) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Session.GameSessionDBEntry.SCORE, session.getScore());
        values.put(Session.GameSessionDBEntry.STAGES_COMPLETED, session.getStage());
        values.put(Session.GameSessionDBEntry.FAILS, session.getFails());
        values.put(Session.GameSessionDBEntry.TIME__PLAYED, (session.getTimeEnd()-session.getTimeStart()));
        values.put(Session.GameSessionDBEntry.HELP_USED, session.getHelpUsed());
        values.put(Session.GameSessionDBEntry.USER_ID, session.getUserId());
        values.put(Session.GameSessionDBEntry.GAME_ID, session.getGameID());
        db.insert(Session.GameSessionDBEntry.TABLE_NAME, null, values);
        Log.e("DEBUGMY", "Session save to db");

    }

    public  void addUserToDB(User user) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.UserDBEntry.NICKNAME, user.getUsername());
        db.insert(User.UserDBEntry.TABLE_NAME, null, values);
        db.close();
    }


    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }


}