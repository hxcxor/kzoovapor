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

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.sql.SQLException;
import java.util.List;

public class WhatDidIGetActivity extends ListActivity
{

    // instantiate datasource
    private JuiceDataSource datasource;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // links to what did i get activity
        setContentView(R.layout.activity_what_did_iget);

        // link datasource
        datasource = new JuiceDataSource(this);
        // try statement for sqlexception
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // list Juice contains all data values
        // via getAllJuice method
        List<Juice> values = datasource.getAllJuice();

        // Could not get custom juice adapter to display properly.

/*        lv1 = (ListView) findViewById(R.id.list);
        JuiceAdapter jus = new JuiceAdapter(this);
        lv1.setAdapter(jus);           */


        // Array adapter to display juice from db. Linked to
        // simple list item 1. Tried to link to different
        // layouts via JuiceAdapter to get both name and
        // manufacturer to display but was unsuccessful.

        ArrayAdapter<Juice> adapter = new ArrayAdapter<Juice>(this,
                R.layout.simple_list_item_1,values);
        setListAdapter(adapter);

    }

    // Called with onclick attribute in activity_what_did_iget
    public void onClick (View view)
    {
        @SuppressWarnings("unchecked")
        // Arrayadapter for juice array. Gets list adapter.
        ArrayAdapter<Juice> adapter = (ArrayAdapter<Juice>) getListAdapter();

        // Juice class juice declared null
        Juice juice = null;

        // switch statement to get id
        switch (view.getId())
        {
            // if button add is clciked
            case R.id.buttonAdd:

                // link edittexts
                EditText editTextJuiceName = (EditText) findViewById(R.id.nameEditText);
                EditText editTextManufacturer = (EditText) findViewById(R.id.manufacturerEditText);
                // make manufacturer edittext invisible due to lack of proper functioning
                editTextManufacturer.setVisibility(View.INVISIBLE);

                // get strings from name/manufacturer
                String name = editTextJuiceName.getText().toString();
                String manufacturer = editTextManufacturer.getText().toString();

                // save juice to db
                juice = datasource.createJuice(name, manufacturer);
                adapter.add(juice);
                break;

            // on button delete click
            case R.id.buttonDelete:
                // if count is greater than 0
                if (getListAdapter().getCount() > 0)
                {
                    // delete the first juice
                    juice = (Juice) getListAdapter().getItem(0);
                    datasource.deleteJuice(juice);
                    adapter.remove(juice);
                }
                break;
        }
        // update adapter
        adapter.notifyDataSetChanged();
    }

    // on resume
    protected void onResume ()
    {
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    // on pause
    protected void onPause ()
    {
        datasource.close();
        super.onPause();
    }

}
