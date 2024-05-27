package com.dhian.personalizedlearningapp.activities.interest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.dhian.personalizedlearningapp.utils.DBHelper;

public class InterestDataSource {

    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public InterestDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addInterest(String interest) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_INTEREST, interest);
        return database.insert(DBHelper.TABLE_INTERESTS, null, values);
    }

    public String getSelectedInterest() {
        String selectedInterest = null;
        Cursor cursor = database.query(DBHelper.TABLE_INTERESTS,
                new String[]{DBHelper.COLUMN_INTEREST},
                null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            selectedInterest = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_INTEREST));
            cursor.close();
        }
        return selectedInterest;
    }
}

