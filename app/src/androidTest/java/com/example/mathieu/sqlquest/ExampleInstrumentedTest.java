package com.example.mathieu.sqlquest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        DBHelper dbhelper = new DBHelper(appContext);
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        ContentValues user = new ContentValues();
        user.put(DatabaseContract.UserEntry.COLUMN_NAME_EMAIL, " User Name");
        user.put(DatabaseContract.UserEntry.COLUMN_NAME_EMAIL, "username@gmail.com");
        long newuserid = db.insert(DatabaseContract.UserEntry.TABLE_NAME, null, user);


        for (int i = 0 ; i < 10 ; i ++){
            ContentValues tweet = new ContentValues();
            tweet.put(DatabaseContract.TweetEntry.COLUMN_NAME_TWEET, "content" + i);
            tweet.put(DatabaseContract.TweetEntry.COLUMN_NAME_ID_USER, newuserid);
            long newtweetid = db.insert(DatabaseContract.TweetEntry.TABLE_NAME, null, tweet);
            assertNotEquals(-1, newtweetid);

        }
        String query = "SELECT "+ DatabaseContract.TweetEntry.COLUMN_NAME_TWEET+" FROM "+DatabaseContract.TweetEntry.TABLE_NAME + " WHERE "+DatabaseContract.TweetEntry.COLUMN_NAME_ID_USER + " = " + newuserid;

        Cursor cursor = db.rawQuery(query, null);

        int i = 0;
        while(cursor.moveToNext()){
            String toto = cursor.getString(0);
            assertEquals(true, toto.contains("content"));
            i++;
        }
        cursor.close();


    }

}
