package com.luxoft.training.dev018.androidexamples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by kelag on 7/7/2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    static final String LOG_TAG = "MyApp";
    static final String TABLE_VARIABLE_NAME = "variable";
    static final String TABLE_VARIABLE_COLUMN_KEY = "key";
    static final String TABLE_VARIABLE_COLUMN_VALUE = "value";

    public DbHelper(Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table " +  TABLE_VARIABLE_NAME + "("
                 + TABLE_VARIABLE_COLUMN_KEY +" text,"
                + TABLE_VARIABLE_COLUMN_VALUE + " text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void deleteVariables(String[] variables) {
        SQLiteDatabase db = getWritableDatabase();
        for (String variable: variables) {
            db.delete(TABLE_VARIABLE_NAME, TABLE_VARIABLE_COLUMN_KEY + "= ?", new String[]{variable} );
        }
        db.close();
    }

    public void insertVariable(String key, String value) {
        ContentValues cv = new ContentValues();
        cv.put(TABLE_VARIABLE_COLUMN_KEY, key);
        cv.put(TABLE_VARIABLE_COLUMN_VALUE, value);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_VARIABLE_NAME, null, cv);
        db.close();
    }

    public String getVariable(String key) {
        SQLiteDatabase db = getReadableDatabase();
        try {
            Cursor c = db.query(TABLE_VARIABLE_NAME,new String[]{TABLE_VARIABLE_COLUMN_VALUE}, TABLE_VARIABLE_COLUMN_KEY + "=?", new String[]{key},null,null, null);
            if(c.moveToFirst()){
                return c.getString(0);
            }
            return "";
        }finally {
            if(null != db)
                db.close();
        }
    }
}
