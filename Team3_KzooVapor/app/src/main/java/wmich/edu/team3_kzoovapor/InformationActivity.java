package wmich.edu.team3_kzoovapor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class InformationActivity extends ActionBarActivity {

    private WebView informationWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_tour);

        //initialize the webview
        informationWebView = (WebView) findViewById(R.id.activity_information_webview);

        // Enable Javascript for the app
        WebSettings webSettings = informationWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Open the about us page
        informationWebView.loadUrl("http://www.kalamazoovaporshop.com/store-locations/");

        informationWebView.setWebViewClient(new WebViewClient() {
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
        if(informationWebView.canGoBack()) {
            informationWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_information, menu);
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
