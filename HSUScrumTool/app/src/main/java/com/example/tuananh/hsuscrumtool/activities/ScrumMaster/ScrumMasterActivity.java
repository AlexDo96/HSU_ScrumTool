package com.example.tuananh.hsuscrumtool.activities.ScrumMaster;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.tuananh.hsuscrumtool.R;

public class ScrumMasterActivity extends AppCompatActivity {
    private DrawerLayout drawer;
     Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrum_master);
        setSupportActionBar(toolbar);
Anhxa();
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.drawer_open,R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_scrum_master);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //     .setAction("Action", null).show();
                Toast.makeText(ScrumMasterActivity.this, "Chức nănng đang thực hiện", Toast.LENGTH_SHORT).show();
            }
        });NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_scrum_master);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                xulychonmenu(menuItem);

                return false;
            }
        });
    }
    public void xulychonmenu(MenuItem menuItem) {
        int id = menuItem.getItemId();
        Fragment fragment = null;
        Class classfragment = null;
        if (id == R.id.nav_Sprints_scrum_master)
            classfragment = SprintBacklogsFragment.class;
        if (id == R.id.nav_Tasks)
            classfragment = TasksScrumMasterFragment.class;
        if (id == R.id.nav_Scrum_Meeting)
            classfragment = ScrumMeetingFragment.class;
        if (id == R.id.nav_statistic)
            classfragment = StatisticFragment.class;
        try {
            fragment = (Fragment) classfragment.newInstance();

            FragmentManager fmanager = getSupportFragmentManager();
            fmanager.beginTransaction()
                    .replace(R.id.flContent_scrum_master, fragment)
                    .commit();
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            drawer.closeDrawer(GravityCompat.START);
        } catch (Exception e) {
        }
    }
    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_scrum_master);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }
    public void Anhxa()
    {
        drawer=(DrawerLayout)findViewById(R.id.drawer_layout_scrum_master);
        toolbar = (Toolbar) findViewById(R.id.tb_Menu_Scrum_Master);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.scrum_master_drawer, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        if(id==android.R.id.home)
            drawer.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }



}
