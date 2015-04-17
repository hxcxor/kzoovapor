package wmich.edu.team3_kzoovapor;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class InformationActivity extends Activity {

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

}
