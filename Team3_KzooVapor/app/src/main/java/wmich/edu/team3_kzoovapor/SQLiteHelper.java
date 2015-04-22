package wmich.edu.team3_kzoovapor;/*
*************************************
* Programmer: Jonathan Trapane
* Class ID: jtrapa4027
* Lab #3: Interactive Design-o-Rama
* CIS 4700: Mobile Commerce Development
* Spring 2015
* Due date: 4/21/15
* Date completed: 4/21/15
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

public class SQLiteHelper extends SQLiteOpenHelper
{
    // database version
    private static final int DATABASE_VERSION = 1;
    // database name
    private static final String DATABASE_NAME = "JuiceDB";

    // juice table name
    private static final String TABLE_JUICE = "juice";

    // juice table column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MANUFACTURER = "manufacturer";
    private static final String KEY_FLAVOR = "flavor";

    private static final String[] COLUMNS = {
            KEY_ID, KEY_NAME, KEY_MANUFACTURER, KEY_FLAVOR
    };

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_JUICE_TABLE = "CREATE TABLE juice ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, " +
                        "manufacturer TEXT, "+
                        "flavor TEXT )";

        // create juice table
        db.execSQL(CREATE_JUICE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // drop older juice table, if exists
        db.execSQL("DROP TABLE IF EXISTS juice");

        // create new juice table
        this.onCreate(db);
    }


}
