package com.kalkulator.lukasz.androidsqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kalkulator.lukasz.androidsqlite.db.tables.Notes;

/**
 * Created by Lukasz on 2017-01-02.
 */

class DBHelper extends SQLiteOpenHelper {
    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "AppDB.db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table "
                        + Notes.TABLE_NAME
                        + " ( "
                        + Notes.Columns.NOTE_ID
                        + " integer primary key, "
                        + Notes.Columns.NOTE_TEXT
                        + " text )"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // kasujemy bazę
        db.execSQL("DROP TABLE IF EXISTS " + Notes.TABLE_NAME);
        // tworzymy nową bazę
        onCreate(db);
    }
}
