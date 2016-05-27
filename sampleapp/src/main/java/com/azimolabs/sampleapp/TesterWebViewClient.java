package com.azimolabs.sampleapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.azimolabs.webviewtester.WebViewTester;

/**
 * Created by maciek on 27.05.2016.
 */
public class TesterWebViewClient extends WebViewClient {

    private static final String LOCAL_URL = "file:///android_asset/index.html";
    private static final String BING_PREFIX = "http://www.bing.com";

    private WebViewTester tester;

    public TesterWebViewClient() {
        tester = new WebViewTester();

    }

    @Override
    public void onPageFinished(final WebView view, String url) {
        tester.init(view);
        if (LOCAL_URL.equals(url)) {
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showActionsOnLocalPage();
                }
            }, 1000);
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    goToGoogle();
                }
            }, 3000);
        } else if (url.startsWith(BING_PREFIX)) {
            tester.setValueForItemWithId("sb_form_q", "funny cats");
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    searchOnBing();
                }
            }, 1000);
        }
    }

    private void showActionsOnLocalPage() {
        tester.checkItemWithId("input_check", true);
        tester.getCheckedStateOfItemWithId("input_check", new WebViewTester.ValueGetListener() {
            @Override
            public void valueObtained(String value) {
                tester.setValueForItemWithClassName("input_text_class", "Checkbox checked: " + value);
            }
        });
    }

    private void goToGoogle() {
        tester.clickOnItemWithName("google_button");
    }

    private void searchOnBing() {
        tester.clickOnItemWithId("sbBtn");
    }

}