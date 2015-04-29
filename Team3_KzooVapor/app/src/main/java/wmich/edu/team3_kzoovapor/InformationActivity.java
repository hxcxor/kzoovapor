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
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class InformationActivity extends Activity {

    private WebView informationWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

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
