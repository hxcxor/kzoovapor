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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JuiceDataSource
{
    // Database fields

    private SQLiteDatabase database;

    private MySQLiteHelper dbHelper;

    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
    MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_MANUFACTURER};

    public JuiceDataSource(Context context)
    {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException
    {
        database = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        dbHelper.close();
    }

    public Juice createJuice(String name, String manufacturer)
    {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NAME, name);
        values.put(MySQLiteHelper.COLUMN_MANUFACTURER, manufacturer);

        long insertId = database.insert(MySQLiteHelper.TABLE_JUICE, null, values);

        Cursor cursor = database.query(MySQLiteHelper.TABLE_JUICE,
                allColumns, MySQLiteHelper.COLUMN_ID + " = "
                + insertId, null, null, null, null);
        cursor.moveToFirst();
        Juice newJuice = cursorToJuice(cursor);
        cursor.close();
        return newJuice;
    }

    public void deleteJuice(Juice juice)
    {
        long id = juice.getId();

        System.out.println("Juice deleted with id: " + id);

        database.delete(MySQLiteHelper.TABLE_JUICE, MySQLiteHelper.COLUMN_ID
        + " = " + id, null);
    }

    public List<Juice> getAllJuice()
    {
        List<Juice> juices = new ArrayList<Juice>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_JUICE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            Juice juice = cursorToJuice(cursor);
            juices.add(juice);
            cursor.moveToNext();
        }

        // close cursor
        cursor.close();
        return juices;
    }

    private Juice cursorToJuice(Cursor cursor)
    {
        Juice juice = new Juice();
        juice.setId(cursor.getLong(0));
        juice.setName(cursor.getString(1));
        juice.setManufacturer(cursor.getString(2));
        return juice;
    }
}
