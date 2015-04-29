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
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    // declare listview
    ListView mainListView;
    // declare context to pass
    Context context;

    // array for prgmname
    ArrayList prgmName;
    // array for images
    public static int[] arrayImages = {};
    // array for main activity list
    public static String[] arrayListMain = {"Juice list", "Promotions", "Resistance Calculator", "Money Saver",
            "Information", "Locations", "What did I Get?", "Juice Tour!",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // links to main activity
        setContentView(R.layout.activity_main);

        // declares context as this
        context = this;

        // links mainlistview to listview
        mainListView = (ListView) findViewById(R.id.list);
        // sets custom adapter for list view
        mainListView.setAdapter(new CustomAdapter(this, arrayListMain, arrayImages));

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
