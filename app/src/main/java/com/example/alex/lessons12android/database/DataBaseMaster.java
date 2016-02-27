package com.example.alex.lessons12android.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.alex.lessons12android.models.User;

import java.util.ArrayList;
import java.util.List;


public class DataBaseMaster {
    private SQLiteDatabase database;
    private static DataBaseCreater dbCreator;

    private static DataBaseMaster instance;

    private DataBaseMaster(Context context) {
        dbCreator = new DataBaseCreater(context);
        if (database == null || !database.isOpen()) {
            database = dbCreator.getWritableDatabase();
        }
    }

    public static DataBaseMaster getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseMaster(context);
        }
        return instance;

    }

    public void addUser(User user) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseCreater.UserColumns.NAME, user.name);
        //Log.d("addUser")
        database.insert(DataBaseCreater.UserColumns.TABLE_NAME, null, cv);
    }

    public List<User> getAllUsersRAW() {
        String query = " SELECT " + DataBaseCreater.UserColumns.NAME + " FROM " + DataBaseCreater.UserColumns.TABLE_NAME;
        Log.d("getAllUser", "query: " + query);
        Cursor cursor = database.rawQuery(query, null);

        List<User> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = new User();
            user.name = cursor.getString(0);
            // user.name = cursor.getString(cursor.getColumnIndex(DataBaseCreater.UserColumns.NAME));
            Log.d("getAllUsers", "name: " + user.name);
            list.add(user);
            cursor.moveToNext();
            Log.d("yed", "getUsers");
        }
        cursor.close();
        return list;
    }

    public List<User> getAllUsersQuery() {
        Cursor cursor = database.query(DataBaseCreater.UserColumns.TABLE_NAME, new String[]{DataBaseCreater.UserColumns.NAME}, null, null, null, null, null);
        List<User> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = new User();
            user.name = cursor.getString(0);
            // user.name = cursor.getString(cursor.getColumnIndex(DataBaseCreater.UserColumns.NAME));
            Log.d("getAllUsers", "name: " + user.name);
            list.add(user);
            cursor.moveToNext();
            Log.d("yed", "getUsers");
        }
        cursor.close();
        return list;
    }
}
