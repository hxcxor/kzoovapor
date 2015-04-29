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
* The Money saver activity allows the user
* to enter the amount of packs of cigarettes
* they are or were buying per week, as well
* as the price of their brand. Then compares
* that cost to the cost of their e-liquid per week
* to give a general idea of how much money they will
* or are saving per week.
* The data will update on the fly thanks to custom edit
* text watchers for each field, then that data will be
* entered in the CalcTotal saved method and output
* into a text view.
*/
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class MoneySaverActivity extends ActionBarActivity {

    // currency formatting
    private static final NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
    // doubles for variable
    private double packsPerW, costPerP, eJuicePerW, costPerM;
    // edittexts for user input
    private EditText packsPerWeekEdit, costPerPackEdit, eJuicePerWeekEdit, costPerMiliEdit;
    // textview to display user savings
    private TextView savingsPerWeek;
    // double for savings
    private double amountSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // link to money saver activity
        setContentView(R.layout.activity_money_saver);

        //instantiate the edit texts
        packsPerWeekEdit = (EditText) findViewById(R.id.editTextPacksPerWeek);
        costPerPackEdit = (EditText) findViewById(R.id.editTextCostPerPack);
        eJuicePerWeekEdit = (EditText) findViewById(R.id.editTextJuicePerWeek);
        costPerMiliEdit = (EditText) findViewById(R.id.editTextCostPerMillileter);

        //instantiate the text view
        savingsPerWeek = (TextView) findViewById(R.id.textViewSavedTotal);

        // textchanged listeners for edittexts
        packsPerWeekEdit.addTextChangedListener(editTextPacksPerWWatcher);
        costPerPackEdit.addTextChangedListener(editTextCostPerPWatcher);
        eJuicePerWeekEdit.addTextChangedListener(editTextEJuicePerWeekWatcher);
        costPerMiliEdit.addTextChangedListener(editTextCostPerMWatcher);
        // run method calctotalsaved
        calcTotalSaved();

    }


    // textwatcher for packs per week
    private TextWatcher editTextPacksPerWWatcher = new TextWatcher() {

        // update on textchanged
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                packsPerW = Double.parseDouble(s.toString());
            }
            catch(NumberFormatException e)
            {
                packsPerW = 0;
            }
            // run total saved method
            calcTotalSaved();
        }

        public void afterTextChanged(Editable s)
        {
        }


        public void beforeTextChanged(CharSequence s, int start, int count,int after)
        {
        }
    };

    // textwatcher for cost per pack
    private TextWatcher editTextCostPerPWatcher = new TextWatcher() {

        // update ontextchanged
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                // parse double to string
                costPerP = Double.parseDouble(s.toString());
            }
            catch(NumberFormatException e)
            {
                // must have input over 0
                costPerP = 0;
            }
            // run calctotalsaved method
            calcTotalSaved();
        }

        public void afterTextChanged(Editable s)
        {
        }


        public void beforeTextChanged(CharSequence s, int start, int count,int after)
        {
        }
    };

    // textwatcher for ejuiceperweek
    private TextWatcher editTextEJuicePerWeekWatcher = new TextWatcher() {

        // update on text changed
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                // parse double to string
                eJuicePerW = Double.parseDouble(s.toString());
            }
            catch(NumberFormatException e)
            {
                // input greater than 0
                eJuicePerW = 0;
            }
            calcTotalSaved();
        }

        public void afterTextChanged(Editable s)
        {
        }


        public void beforeTextChanged(CharSequence s, int start, int count,int after)
        {
        }
    };

    // watcher for cost per month
    private TextWatcher editTextCostPerMWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                // parse double to string
                costPerM = Double.parseDouble(s.toString());
            }
            catch(NumberFormatException e)
            {
                // cost per month greater than 0
                costPerM = 0;
            }
            calcTotalSaved();
        }

        public void afterTextChanged(Editable s)
        {
        }


        public void beforeTextChanged(CharSequence s, int start, int count,int after)
        {
        }
    };

    // method to calculate total saved
    private void calcTotalSaved(){

        // cigtotal is packsperweek * costperweek
        double cigTotal = (packsPerW * costPerP);
        // juicetotal is ejuiceperweek * cost per month
        double juiceTotal = (eJuicePerW * costPerM);

        // amountsaved cigtotal minus juicetotal
        amountSaved = (cigTotal - juiceTotal);
        // set text and format to savings per week
        savingsPerWeek.setText(currencyFormater.format(amountSaved) + " per week!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_money_saver, menu);
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
