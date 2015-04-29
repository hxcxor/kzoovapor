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
import android.widget.ListView;

import java.sql.SQLException;
import java.util.List;

public class WhatDidIGetActivity extends ListActivity
{

    private JuiceDataSource datasource;

    ListView lv1;
    JuiceAdapter jus;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_did_iget);

        datasource = new JuiceDataSource(this);
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Juice> values = datasource.getAllJuice();

        // use simplecursoradapter to show listview elements

/*        lv1 = (ListView) findViewById(R.id.list);
        JuiceAdapter jus = new JuiceAdapter(this);
        lv1.setAdapter(jus);           */



        ArrayAdapter<Juice> adapter = new ArrayAdapter<Juice>(this,
                R.layout.simple_list_item_1,values);
        setListAdapter(adapter);

    }

    // Called with onclick attribute in activity_what_did_iget
    public void onClick (View view)
    {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Juice> adapter = (ArrayAdapter<Juice>) getListAdapter();

        Juice juice = null;

        switch (view.getId())
        {
            case R.id.buttonAdd:

                EditText editTextJuiceName = (EditText) findViewById(R.id.nameEditText);
                EditText editTextManufacturer = (EditText) findViewById(R.id.manufacturerEditText);
                editTextManufacturer.setVisibility(View.INVISIBLE);

                String name = editTextJuiceName.getText().toString();
                String manufacturer = editTextManufacturer.getText().toString();

                // save juice to db
                juice = datasource.createJuice(name, manufacturer);
                adapter.add(juice);
                break;

            case R.id.buttonDelete:
                if (getListAdapter().getCount() > 0)
                {
                    juice = (Juice) getListAdapter().getItem(0);
                    datasource.deleteJuice(juice);
                    adapter.remove(juice);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    protected void onResume ()
    {
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    protected void onPause ()
    {
        datasource.close();
        super.onPause();
    }

}
