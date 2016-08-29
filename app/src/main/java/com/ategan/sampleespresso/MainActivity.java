package com.ategan.sampleespresso;

import android.os.Bundle;
import android.text.TextUtils;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActivityUtil.setupNavigationDrawer(this, toolbar, R.id.drawer_layout, this);
        welcomeTextView = (TextView) findViewById(R.id.main_welcome_label);
        String label = getIntent().getStringExtra(Library.USER_NAME);
        label = TextUtils.isEmpty(label) ? getString(R.string.guest) : label;
        label = String.format(getString(R.string.welcome_msg), label);
        welcomeTextView.setText(label);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return ActivityUtil.onNavigationItemSelected(this, R.id.drawer_layout, item);
    }
}
