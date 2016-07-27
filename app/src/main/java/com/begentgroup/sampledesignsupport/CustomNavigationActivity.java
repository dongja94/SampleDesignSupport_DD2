package com.begentgroup.sampledesignsupport;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CustomNavigationActivity extends AppCompatActivity implements
        MenuFragment.OnMenuSelectListener {

    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_dialog_info);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, MessageFragment.newInstance("Main"))
                    .commit();
        }
    }

    @Override
    public void onMenuSelected(int menuId) {
        switch (menuId) {
            case MenuFragment.MENU_MAIN : {
                changeFragment(MessageFragment.newInstance("Main"));
                break;
            }
            case MenuFragment.MENU_PROFILE: {
                changeFragment(MessageFragment.newInstance("Profile"));
                break;
            }
            case MenuFragment.MENU_LOGOUT: {
                changeFragment(MessageFragment.newInstance("Logout"));
                break;
            }
            case MenuFragment.MENU_KEYWORD: {
                changeFragment(MessageFragment.newInstance("Keyword search"));
                break;
            }
            case MenuFragment.MENU_DATE: {
                changeFragment(MessageFragment.newInstance("date search"));
                break;
            }
            case MenuFragment.MENU_PUSH: {
                changeFragment(MessageFragment.newInstance("push setting"));
                break;
            }
            case MenuFragment.MENU_ABOUT: {
                changeFragment(MessageFragment.newInstance("about"));
                break;
            }
            default:
                return;
        }
        drawer.closeDrawer(GravityCompat.START);
    }

    private void changeFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f)
                .commit();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
