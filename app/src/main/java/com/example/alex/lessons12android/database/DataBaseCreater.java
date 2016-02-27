package com.example.alex.lessons12android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


public class DataBaseCreater extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_name";
    public static final int DB_VERSION = 1;

    public static class User implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String NAME = "name";
    }

    private static String CREATE_TABLE_USER = "CREATE TABLE " + User.TABLE_NAME + "(" + User._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            User.NAME + " TEXT" + ");";

    public DataBaseCreater(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
