package com.ategan.sampleespresso;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ategan on 8/28/16.
 */

public class ActivityUtil {
    public static boolean hasValidValue(EditText editText) {
        return editText != null && !TextUtils.isEmpty(editText.getText());
    }

    public static void setupNavigationDrawer(AppCompatActivity activity, Toolbar toolbar, int drawerLayoutID, NavigationView.OnNavigationItemSelectedListener listner) {
        DrawerLayout drawer = (DrawerLayout) activity.findViewById(drawerLayoutID);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) activity.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(listner);
    }

    public static boolean onNavigationItemSelected(AppCompatActivity activity, int drawerLayoutID, MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            activity.startActivity(new Intent(activity, WebViewActivity.class));
        } else if (id == R.id.nav_manage) {
            activity.startActivity(new Intent(activity, OthersActivity.class));
        }
        DrawerLayout drawer = (DrawerLayout) activity.findViewById(drawerLayoutID);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void initToolbar(final AppCompatActivity appCompatActivity, int resourceID) {
        Toolbar toolbar = (Toolbar) appCompatActivity.findViewById(resourceID);
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        appCompatActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appCompatActivity.finish();
            }
        });
    }
}
