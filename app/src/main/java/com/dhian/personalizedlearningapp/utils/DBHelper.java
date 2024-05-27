package com.dhian.personalizedlearningapp.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "interests.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_INTERESTS = "interests";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_INTEREST = "interest";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_INTERESTS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_INTEREST + " TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

