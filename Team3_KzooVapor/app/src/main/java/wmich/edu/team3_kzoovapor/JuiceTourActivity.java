package wmich.edu.team3_kzoovapor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class JuiceTourActivity extends Activity {

    private WebView juiceTourWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_tour);

        //initialize the webview
        juiceTourWebView = (WebView) findViewById(R.id.activity_juice_tour_webview);


        // Enable Javascript for the page
        WebSettings webSettings = juiceTourWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        //Need to add juice tour url
        juiceTourWebView.loadUrl("http://beta.html5test.com/");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juice_tour, menu);
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
