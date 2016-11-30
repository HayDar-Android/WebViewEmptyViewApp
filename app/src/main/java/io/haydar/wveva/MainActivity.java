package io.haydar.wveva;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import io.haydar.we.WebViewEmptyViewClient;

import static io.haydar.wveva.R.id.webview;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webviewEmptyView = (WebView) findViewById(webview);
        webviewEmptyView.loadUrl("https://github.com/asLody/VirtualApp32");
        webviewEmptyView.setWebViewClient(new WebViewEmptyViewClient(this) {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
        });
        webviewEmptyView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webviewEmptyView.getSettings().setJavaScriptEnabled(true);
        webviewEmptyView.getSettings().setSupportZoom(true);
        webviewEmptyView.clearCache(true);
        webviewEmptyView.clearHistory();
    }
}
