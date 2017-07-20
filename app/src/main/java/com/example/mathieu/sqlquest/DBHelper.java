package com.example.mathieu.sqlquest;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.mathieu.sqlquest.DatabaseContract.SQL_CREATE_BELONG_ENTRY;
import static com.example.mathieu.sqlquest.DatabaseContract.SQL_CREATE_ORGANIZATION;
import static com.example.mathieu.sqlquest.DatabaseContract.SQL_CREATE_TWEET;
import static com.example.mathieu.sqlquest.DatabaseContract.SQL_CREATE_USER;
import static com.example.mathieu.sqlquest.DatabaseContract.SQL_DELETE_BELONG_ENTRY;
import static com.example.mathieu.sqlquest.DatabaseContract.SQL_DELETE_TWEET;


/**
 * Created by apprenti on 10/07/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USER);
        db.execSQL(SQL_CREATE_TWEET);
        db.execSQL(SQL_CREATE_ORGANIZATION);
        db.execSQL(SQL_CREATE_BELONG_ENTRY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TWEET);
        db.execSQL(SQL_CREATE_USER);
        db.execSQL(SQL_CREATE_ORGANIZATION);
        db.execSQL(SQL_DELETE_BELONG_ENTRY);
        onCreate(db);

    }
}