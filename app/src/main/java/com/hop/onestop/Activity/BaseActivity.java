package com.hop.onestop.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;

import com.arpaul.utilitieslib.UnCaughtException;
import com.hop.onestop.R;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar baseToolbar;
    public FloatingActionButton baseFab;
    public DrawerLayout baseDrawer;
    public NavigationView baseNavView;
    public ActionBarDrawerToggle baseToggle;
    public LayoutInflater inflater;
    public LinearLayout llBodyBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Thread.setDefaultUncaughtExceptionHandler(new UnCaughtException(BaseActivity.this,getString(R.string.reporting_mailid)));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initializeControls();

        bindControls();

        initialize();
    }

    public abstract void initialize();

    private void bindControls(){
        baseFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initializeControls() {
        inflater            = getLayoutInflater();
        llBodyBase          = (LinearLayout) findViewById(R.id.llBodyBase);

        baseToolbar         = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(baseToolbar);

        baseFab             = (FloatingActionButton) findViewById(R.id.fab);

        baseDrawer          = (DrawerLayout) findViewById(R.id.drawer_layout);
        baseToggle          = new ActionBarDrawerToggle(this, baseDrawer, baseToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        baseDrawer.addDrawerListener(baseToggle);
        baseToggle.syncState();

        baseNavView         = (NavigationView) findViewById(R.id.nav_view);
        baseNavView.setNavigationItemSelectedListener(this);
    }
}
