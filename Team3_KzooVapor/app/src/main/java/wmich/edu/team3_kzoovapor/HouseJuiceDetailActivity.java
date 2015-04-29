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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class HouseJuiceDetailActivity extends ActionBarActivity {

    String title;
    String description;
    int image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housedetail);

        TextView tvTitleLabel = (TextView)findViewById(R.id.textViewHJTitle);
        TextView tvDescLabel = (TextView)findViewById(R.id.textViewHJDisc);
        ImageView ivPrImage = (ImageView)findViewById(R.id.imageViewJuice);



        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            title = extras.getString("juiceName");
            tvTitleLabel.setText(title);


            image = extras.getInt("juiceImg");
            ivPrImage.setImageResource(image);

            description = extras.getString("juiceDiscLabel");
            tvDescLabel.setText(description);

        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_housejuice_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final SharedPreferences sharedPrefFavorites = PreferenceManager.getDefaultSharedPreferences(this);

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_favorite) {

            return true;
        }

        // Starting the shared preference manager to write the input information



        return super.onOptionsItemSelected(item);
    }

}