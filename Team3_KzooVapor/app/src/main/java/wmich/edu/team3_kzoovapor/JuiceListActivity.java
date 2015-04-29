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
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class JuiceListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // links to juice list layout
        setContentView(R.layout.activity_juice_list);
        // links to premium image view
        ImageView imageButtonPrem = (ImageView) findViewById(R.id.imageViewPremButton);
        // links to house image view
        ImageView imageButtonHouse = (ImageView) findViewById(R.id.imageViewHouseButton);


        // on touch listener for premiumjuice
        imageButtonPrem.setOnTouchListener(premiumJuice);
        // on touch listener for housejuice
        imageButtonHouse.setOnTouchListener(houseJuice);
    }

    // builds ontouchlistener for premium juice
    View.OnTouchListener premiumJuice = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            // create intent to send user to premiumjuice
            Intent senseIntent = new Intent(JuiceListActivity.this, PremiumJuiceActivity.class);
            startActivity(senseIntent);
            return false;
        }
    };

    // ontouchlistener for house juice
    View.OnTouchListener houseJuice = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            // intent to send user to housejuicelist
            Intent senseIntent = new Intent(JuiceListActivity.this, HouseJuiceActivity.class);
            startActivity(senseIntent);
            return false;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juice_list, menu);
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
