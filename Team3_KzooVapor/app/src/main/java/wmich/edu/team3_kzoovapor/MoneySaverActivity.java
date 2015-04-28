package wmich.edu.team3_kzoovapor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class MoneySaverActivity extends ActionBarActivity {

    private static final NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
    private double packsPerW, costPerP, eJuicePerW, costPerM;
    private EditText packsPerWeekEdit, costPerPackEdit, eJuicePerWeekEdit, costPerMiliEdit;
    private TextView savingsPerWeek;

    private double amountSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_saver);

        //instantiate the edit texts
        packsPerWeekEdit = (EditText) findViewById(R.id.editTextPacksPerWeek);
        costPerPackEdit = (EditText) findViewById(R.id.editTextCostPerPack);
        eJuicePerWeekEdit = (EditText) findViewById(R.id.editTextJuicePerWeek);
        costPerMiliEdit = (EditText) findViewById(R.id.editTextCostPerMillileter);

        //instantiate the text view
        savingsPerWeek = (TextView) findViewById(R.id.textViewSavedTotal);

        packsPerWeekEdit.addTextChangedListener(editTextPacksPerWWatcher);
        costPerPackEdit.addTextChangedListener(editTextCostPerPWatcher);
        eJuicePerWeekEdit.addTextChangedListener(editTextEJuicePerWeekWatcher);
        costPerMiliEdit.addTextChangedListener(editTextCostPerMWatcher);
        calcTotalSaved();





    }


    private TextWatcher editTextPacksPerWWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                packsPerW = Double.parseDouble(s.toString());
            }
            catch(NumberFormatException e)
            {
                packsPerW = 0;
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

    private TextWatcher editTextCostPerPWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                costPerP = Double.parseDouble(s.toString());
            }
            catch(NumberFormatException e)
            {
                costPerP = 0;
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

    private TextWatcher editTextEJuicePerWeekWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                eJuicePerW = Double.parseDouble(s.toString());
            }
            catch(NumberFormatException e)
            {
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

    private TextWatcher editTextCostPerMWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                costPerM = Double.parseDouble(s.toString());
            }
            catch(NumberFormatException e)
            {
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

    private void calcTotalSaved(){

        double cigTotal = (packsPerW * costPerP);
        double juiceTotal = (eJuicePerW * costPerM);

        amountSaved = (cigTotal - juiceTotal);
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
