package com.azimolabs.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class TesterActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);

        webView = (WebView) findViewById(R.id.wvSample);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new TesterWebViewClient());

        webView.loadUrl("file:///android_asset/index.html");

    }

}