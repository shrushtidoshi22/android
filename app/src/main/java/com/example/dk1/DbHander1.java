package com.example.dk1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHander1 extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "usersdb";
    private static final String TABLE_NAME = "userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_MOBILEE = "mobilee";
    private static final String KEY_PASSWORD = "password";
    public DbHander1(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            String CREATE_TABLE = "create table " + TABLE_NAME + "("
                    + KEY_ID + " Integer PRIMARY KEY AUTOINCREMENT,"
                    + KEY_MOBILEE + " NUMBER,"
                    + KEY_PASSWORD + " TEXT" + ")";
            sqLiteDatabase.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Log.d("msg1", e.getMessage());
        }
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if exist
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(sqLiteDatabase);
    }

    void insertloginDetails(String mobilee, String password) {
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_MOBILEE, mobilee);
        cValues.put(KEY_PASSWORD, password);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_NAME,null, cValues);
        db.close();
    }
}
