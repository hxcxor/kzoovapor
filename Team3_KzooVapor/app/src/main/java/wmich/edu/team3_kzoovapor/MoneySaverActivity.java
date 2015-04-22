package wmich.edu.team3_kzoovapor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

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

        packsPerWeekEdit.addTextChangedListener(editTextWatcher);






    }


    private TextWatcher editTextWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {


            packsPerW = Double.parseDouble(s.toString());
            costPerP = Double.parseDouble(s.toString());
            eJuicePerW = Double.parseDouble(s.toString());
            costPerM = Double.parseDouble(s.toString());

            savingsPerWeek.setText(currencyFormater.format(amountSaved));
                    calcTotalSaved();

        }
        //starts tracking when the seek bar is touched
        public void afterTextChanged(Editable s)
        {
        }

        //stops tracking when the seek bar is no longer touched
        public void beforeTextChanged(CharSequence s, int start, int count,int after)
        {
        }
    };

    private void calcTotalSaved(){

        double cigTotal = (packsPerW * costPerP);
        double juiceTotal = (eJuicePerW * costPerM);

        amountSaved = ((juiceTotal - cigTotal) * -1);

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
