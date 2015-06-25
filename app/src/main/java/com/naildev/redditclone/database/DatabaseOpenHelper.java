package com.naildev.redditclone.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by coneill on 25/06/2015.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String COMMA = ", ";


    /*DB CREATE TABLE SENTENCE*/
    private static final String CREATE_POST_TABLE = "CREATE TABLE IF NOT EXISTS "
            + DatabaseContract.postTable.TABLE_NAME + " ("
            + DatabaseContract.postTable.TITLE + TEXT_TYPE + COMMA
            + DatabaseContract.postTable.LINK + TEXT_TYPE + COMMA
            + DatabaseContract.postTable.IMAGELINK + TEXT_TYPE + ")";

    /*DB DROP SENTENCE*/
    private static final String DROP_POST_TABLE = "DROP TABLE IF EXISTS " + DatabaseContract.postTable.TABLE_NAME;

    public DatabaseOpenHelper(Context context){
        super(context, DatabaseContract.DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_POST_TABLE);
    }

    @Override // Used to add / remove tables
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_POST_TABLE);
        onCreate(db);
    }
}
