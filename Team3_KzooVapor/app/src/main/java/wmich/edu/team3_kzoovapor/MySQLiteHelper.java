package wmich.edu.team3_kzoovapor;/*
*************************************
* Programmer: Jonathan Trapane
* Class ID: jtrapa4027
* Lab #3: Interactive Design-o-Rama
* CIS 4700: Mobile Commerce Development
* Spring 2015
* Due date: 4/28/15
* Date completed: 4/28/15
*************************************
* Program Explanation
* 
*
*
*************************************
*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper
{
    // string for juices table
    public static final String TABLE_JUICE = "juices";

    public static final String COLUMN_ID = "_id";

    public static final String COLUMN_NAME = "name";

    public static final String COLUMN_MANUFACTURER = "manufacturer";

    private static final String DATABASE_NAME = "juice.db";

    private static final int DATABASE_VERSION = 1;

    // Database creation sql statements
    private static final String DATABASE_CREATE = "create table "
            + TABLE_JUICE + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_NAME
            + " text not null, "
            + COLUMN_MANUFACTURER
            + " text not null);";

    public MySQLiteHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion
        + " to "
        + newVersion
        + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JUICE);

        onCreate(db);
    }
}
