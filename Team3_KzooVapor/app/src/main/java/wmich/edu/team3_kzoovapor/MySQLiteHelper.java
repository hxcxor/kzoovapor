package wmich.edu.team3_kzoovapor;
/*
*************************************
* Programmers: Bryan Minton, Jonathan Trapane,
*              Anson Richardson
* Final Project: Kalamazoo Vapor App
* CIS 4700: Mobile Commerce Development
* Spring 2015
* Due date: 4/28/15
* Date completed: 4/28/15
*************************************
*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper
{
    // strings for juices table
    public static final String TABLE_JUICE = "juices";

    // id column
    public static final String COLUMN_ID = "_id";

    // name column
    public static final String COLUMN_NAME = "name";

    // manufacturer column
    public static final String COLUMN_MANUFACTURER = "manufacturer";

    // db name
    private static final String DATABASE_NAME = "juice.db";

    // db version
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
        // build sqlitehelper
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // oncreate execute database_create
    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(DATABASE_CREATE);
    }

    // onupgrade, upgrade and log
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
