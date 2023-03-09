package com.example.healthyheart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private com.example.healthyheart.DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public com.example.healthyheart.DBManager open() throws SQLException {
        dbHelper = new com.example.healthyheart.DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(com.example.healthyheart.DatabaseHelper.SUBJECT, name);
        contentValue.put(com.example.healthyheart.DatabaseHelper.DESC, desc);
        database.insert(com.example.healthyheart.DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { com.example.healthyheart.DatabaseHelper._ID, com.example.healthyheart.DatabaseHelper.SUBJECT, com.example.healthyheart.DatabaseHelper.DESC };
        Cursor cursor = database.query(com.example.healthyheart.DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(com.example.healthyheart.DatabaseHelper.DESC, desc);
        int i = database.update(com.example.healthyheart.DatabaseHelper.TABLE_NAME, contentValues, com.example.healthyheart.DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(com.example.healthyheart.DatabaseHelper.TABLE_NAME, com.example.healthyheart.DatabaseHelper._ID + "=" + _id, null);
    }

    public Cursor getListContents(){
        dbHelper = new com.example.healthyheart.DatabaseHelper(context);
        //database = dbHelper.getWritableDatabase();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + com.example.healthyheart.DatabaseHelper.TABLE_NAME, null);
        return data;
    }
}
