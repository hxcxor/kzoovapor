package wmich.edu.team3_kzoovapor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    // Variables for each button
    private Button btnJuiceList;
    private Button btnPromotions;
    private Button btnAdvancedUsers;
    private Button btnInformation;
    private Button btnMoneySaver;
    private Button btnLocations;
    private Button btnWhatDidIGet;
    private Button btnJuiceTour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link button variables to button id's
        btnJuiceList = (Button) findViewById(R.id.btnJuiceList);
        btnPromotions = (Button) findViewById(R.id.buttonPromotions);
        btnAdvancedUsers = (Button) findViewById(R.id.buttonAdvancedUsers);
        btnInformation = (Button) findViewById(R.id.buttonInformation);
        btnMoneySaver = (Button) findViewById(R.id.buttonMoneySaver);
        btnLocations = (Button) findViewById(R.id.buttonLocations);
        btnWhatDidIGet = (Button) findViewById(R.id.buttonWhatDidIGet);
        btnJuiceTour = (Button) findViewById(R.id.buttonJuiceTour);


        // buttonJuiceList onClickListener
        btnJuiceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, JuiceListActivity.class));
            }
        });

        // buttonPromotions onClickListener
        btnPromotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, PromotionsActivity.class));
            }
        });

        // buttonAdvancedUsers onClickListener
        btnAdvancedUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AdvancedUsersActivity.class));
            }
        });

        // buttonInformation onClickListener
        btnInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, InformationActivity.class));
            }
        });

        // buttonMoneySaver onClickListener
        btnMoneySaver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, MoneySaverActivity.class));
            }
        });

        // buttonLocations onClickListener
        btnLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, LocationsActivity.class));
            }
        });

        // buttonWhatDidIGet onClickListener
        btnWhatDidIGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, WhatDidIGetActivity.class));
            }
        });

        // buttonJuiceTour onClickListener
        btnJuiceTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, JuiceTourActivity.class));
            }
        });

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
