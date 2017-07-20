package com.example.mathieu.sqlquest;

import android.provider.BaseColumns;

/**
 * Created by mathieu on 20/07/17.

 import android.provider.BaseColumns;

 /**
 * Created by apprenti on 10/07/17.
 */

public class DatabaseContract {


    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_USER_ID = "iduser";
        public static final String COLUMN_NAME_EMAIL = "email";
    }

    public static class TweetEntry implements BaseColumns {
        public static final String TABLE_NAME = "content";
        public static final String COLUMN_NAME_ID = "idcontent";
        public static final String COLUMN_NAME_TWEET = "tweet";
        public static final String COLUMN_NAME_ID_USER = "user_iduser";

    }

    public static class OrganizationEntry implements BaseColumns {
        public static final String TABLE_NAME = "organization";
        public static final String COLUMN_NAME_ID = "idorganization";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_URL = "website_url";

    }

    public static class BelongEntry implements BaseColumns {
        public static final String TABLE_NAME = "user_has_organization";
        public static final String COLUMN_NAME_ID_USER = "user_iduser";
        public static final String COLUMN_NAME_ID_ORGANIZATION = "organization_idorganization";
    }

    public static final String SQL_CREATE_USER =
            "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                    UserEntry.COLUMN_NAME_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    UserEntry.COLUMN_NAME_NAME + " VARCHAR(45)," +
                    UserEntry.COLUMN_NAME_EMAIL + " VARCHAR(45));";

    public static final String SQL_CREATE_ORGANIZATION =
            "CREATE TABLE " + OrganizationEntry.TABLE_NAME + " (" +
                    OrganizationEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    OrganizationEntry.COLUMN_NAME_NAME + " VARCHAR(45)," +
                    OrganizationEntry.COLUMN_NAME_URL + " TEXT);";

    public static final String SQL_CREATE_TWEET =
            "CREATE TABLE " + TweetEntry.TABLE_NAME + " (" +
                    TweetEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TweetEntry.COLUMN_NAME_TWEET + " TEXT," +
                    TweetEntry.COLUMN_NAME_ID_USER + " INTEGER);";

    public static final String SQL_CREATE_BELONG_ENTRY =
            "CREATE TABLE " + BelongEntry.TABLE_NAME + " (" +
                    BelongEntry.COLUMN_NAME_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    BelongEntry.COLUMN_NAME_ID_ORGANIZATION + " TEXT);";

    public static final String SQL_DELETE_USER =
            "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;

    public static final String SQL_DELETE_TWEET =
            "DROP TABLE IF EXISTS " + TweetEntry.TABLE_NAME;

    public static final String SQL_DELETE_ORGANIZATION =
            "DROP TABLE IF EXISTS " + OrganizationEntry.TABLE_NAME;

    public static final String SQL_DELETE_BELONG_ENTRY =
            "DROP TABLE IF EXISTS " + BelongEntry.TABLE_NAME;

}