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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper
{
    // database version
    private static final int DATABASE_VERSION = 1;
    // database name
    private static final String DATABASE_NAME = "JuiceDB";

    // juice table name
    private static final String TABLE_JUICE = "juices";

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
        String CREATE_JUICE_TABLE = "CREATE TABLE juices ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "manufacturer TEXT, "+
                "flavor TEXT )";

        // create juice table
        db.execSQL(CREATE_JUICE_TABLE);
    }

    // method to add juice to list
    public void addJuice(Juice juice)
    {
        // log juice add
        Log.d("addJuice", juice.toString());

        // get reference to db
        SQLiteDatabase db = this.getWritableDatabase();

        // create contentvalues to add values
        ContentValues values = new ContentValues();
        // get name
        values.put(KEY_NAME, juice.getName());
        // get manufacturer
        values.put(KEY_MANUFACTURER, juice.getManufacturer());
        // get flavor
        values.put(KEY_FLAVOR, juice.getFlavor());

        // insert values
        db.insert(TABLE_JUICE, null, values);

        // close db
        db.close();
    }

    // method to get juice
    public Juice getJuice(int id)
    {
        // get reference to readable db
        SQLiteDatabase db = this.getReadableDatabase();

        // build query
        Cursor cursor =
                db.query(TABLE_JUICE, //table
                COLUMNS, // column names
                " id = ?", // selections
                new String[] {String.valueOf(id)}, // id string
                null, null, null, null); // group, having, order, limit

        // if results, get the first
        if (cursor != null)
            cursor.moveToFirst();

        // build juice object
        Juice juice = new Juice();
        juice.setId(Integer.parseInt(cursor.getString(0)));
        juice.setName(cursor.getString(1));
        juice.setManufacturer(cursor.getString(2));
        juice.setFlavor(cursor.getString(3));

        // log
        Log.d("getJuice("+id+")", juice.toString());

        // return juice
        return juice;
    }

    // method to getalljuice
    public List<Juice> getAllJuice()
    {
        List<Juice> juices = new LinkedList<Juice>();

        // build query
        String query = "SELECT  * FROM " + TABLE_JUICE;

        // get reference to writable db
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // go through rows, build juice
        Juice juice = null;
        if (cursor.moveToFirst())
        {
            do {
                juice = new Juice();
                juice.setId(Integer.parseInt(cursor.getString(0)));
                juice.setName(cursor.getString(1));
                juice.setManufacturer(cursor.getString(2));
                juice.setFlavor(cursor.getString(3));

                // add juice to juices
                juices.add(juice);
            }
            while (cursor.moveToNext());
        }

        // log
        Log.d("getAllJuices()", juices.toString());

        // return
        return juices;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // drop older juice table, if exists
        db.execSQL("DROP TABLE IF EXISTS juices");

        // create new juice table
        this.onCreate(db);
    }


}
