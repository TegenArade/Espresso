package com.ategan.sampleespresso;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        intiView();
    }

    private void intiView() {
        ActivityUtil.initToolbar(this, R.id.toolbar);
        WebView browser = (WebView) findViewById(R.id.web_view);
        browser.loadUrl(getString(R.string.web_url));
    }
}
