package com.example.dk1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "usersdb";
    private static final String TABLE_NAME = "userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MOBILE = "mobileno";
    private static final String KEY_EMAIL = "emailid";

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            String CREATE_TABLE = "create table " + TABLE_NAME + "("
                    + KEY_ID + " Integer PRIMARY KEY AUTOINCREMENT,"
                    + KEY_NAME + " TEXT,"
                    + KEY_MOBILE + " NUMBER,"
                    + KEY_EMAIL + " TEXT" + ")";
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

    void insertUserDetails(String name, String location,String designation) {
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_MOBILE, location);
        cValues.put(KEY_EMAIL, designation);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_NAME,null, cValues);
        db.close();
    }
}
