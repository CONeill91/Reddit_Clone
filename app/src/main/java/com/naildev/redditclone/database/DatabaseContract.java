package com.naildev.redditclone.database;

/**
 * Created by coneill on 25/06/2015.
 */
public class DatabaseContract  {

    public static final String DB_NAME = "reddit_database.db";

    public abstract class postTable{
        public static final String TABLE_NAME = "post_table";

        public static final String TITLE = "title";
        public static final String LINK = "link";
        public static final String IMAGELINK = "imagelink";

    }
}
