package wmich.edu.team3_kzoovapor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;


public class AdvancedUsersActivity extends Activity implements OnItemSelectedListener {
    Spinner spType, spGauge, spTool;
    double selectedValueTypes, selectedValueGauge, selectedValueTool, finalCalc;
    String[] types  = { "Kanthal A1", "Nichrome", "Nickel" };
    double[] valueTypes = {1, .75, .07 };
    String[] gauges = {"32 Gauge","30 Gauge","28 Gauge","26 Gauge","24 Gauge","22 Gauge"};
    double[] valueGauges = {.244,.162,.109,.075,.052,.0365};
    String[] tools = {"18 Gauge/1.3mm"};
    double[] valueTools = {1};
    TextView displayResult;
    EditText editTextWraps;
    EditText editTextCoils;
    int wraps;
    int coils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_advanced_users);
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> AdapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, types);
        spType = (Spinner) findViewById(R.id.spinnerWireType);
        AdapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spType.setAdapter(AdapterType);
        spType.setPrompt("Select Type");
        spType.setOnItemSelectedListener(this);

        ArrayAdapter<String> AdapterGauge = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, gauges);
        spGauge = (Spinner) findViewById(R.id.spinnerWireGauge);
        AdapterGauge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGauge.setAdapter(AdapterGauge);
        spGauge.setPrompt("Select Gauge");
        spGauge.setOnItemSelectedListener(this);

        ArrayAdapter<String> AdapterTools = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tools);
        spTool = (Spinner) findViewById(R.id.spinnerWrapTool);
        AdapterTools.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTool.setAdapter(AdapterTools);
        spTool.setPrompt("Select Tool");
        spTool.setOnItemSelectedListener(this);

        editTextWraps = (EditText) findViewById(R.id.editTextWraps);
        editTextCoils = (EditText) findViewById(R.id.editTextCoils);
        Button Calc = (Button) findViewById(R.id.buttonCalc);
        displayResult = (TextView) findViewById(R.id.textViewResult);

        Calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String editTextConvertWraps = editTextWraps.getText().toString();
                String editTextConvertCoils = editTextCoils.getText().toString();
                wraps = Integer.parseInt(editTextConvertWraps);
                coils = Integer.parseInt(editTextConvertCoils);
                finalCalc = wraps*selectedValueTypes*selectedValueGauge/coils;
                String finalResult = String.valueOf(finalCalc);
                displayResult.setText("Your resistance will be approximately " + finalResult);


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // value corresponds to the selected spType
        Spinner spinner = (Spinner) parent;
        if(spinner.getId() == R.id.spinnerWireType)
        {
            selectedValueTypes = valueTypes[pos];
        }
        else if(spinner.getId() == R.id.spinnerWireGauge)
        {
            selectedValueGauge = valueGauges[pos];
        }

    }








    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_advanced_users, menu);
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
