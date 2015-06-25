package com.naildev.redditclone.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.naildev.redditclone.model.Post;

import java.util.List;

/**
 * Created by coneill on 25/06/2015.
 */
public class DatabaseAccessObject {

    /*
    * Singleton Pattern
    */
    private static DatabaseAccessObject sInstance = null;

    /*
    *   Get an instance of the DBO
    *
    *   @return instance
    */
    public static DatabaseAccessObject getInstance(){
        if(sInstance == null){
            sInstance = new DatabaseAccessObject();
        }
        return sInstance;
    }

    public boolean storePosts(Context context,List<Post> postList){
        try{
            SQLiteDatabase db = new DatabaseOpenHelper(context).getWritableDatabase();
            db.beginTransaction();

            for(Post post: postList){
                // Key Value Pair
                ContentValues cv = new ContentValues();
                cv.put(DatabaseContract.postTable.TITLE, post.getTitle());
                cv.put(DatabaseContract.postTable.LINK, post.getPermalink());
                cv.put(DatabaseContract.postTable.IMAGELINK, post.getThumbnail());

                db.insert(DatabaseContract.postTable.TABLE_NAME, null, cv);
            }
            db.setTransactionSuccessful();
            db.endTransaction();

            db.close();
        }catch (Exception e){
            Log.d("DB ERROR", e.toString());
            return false;
        }

        return true;
    }



}
