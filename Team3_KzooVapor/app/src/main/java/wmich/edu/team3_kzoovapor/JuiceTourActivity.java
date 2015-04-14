package wmich.edu.team3_kzoovapor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


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

        //Open the juice tour
        juiceTourWebView.loadUrl("http://kalamazoovaporjuicetour.com/#!leaderboards/caue");


        juiceTourWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


    }
    //allows the back button to return to the app
    @Override
    public void onBackPressed() {
        if(juiceTourWebView.canGoBack()) {
            juiceTourWebView.goBack();
        } else {
            super.onBackPressed();
        }
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
