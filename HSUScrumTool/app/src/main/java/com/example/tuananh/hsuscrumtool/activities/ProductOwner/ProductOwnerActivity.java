package com.example.tuananh.hsuscrumtool.activities.ProductOwner;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.tuananh.hsuscrumtool.R;


public class ProductOwnerActivity extends AppCompatActivity{
        private DrawerLayout drawer;
private Toolbar toolbar;
private ActionBarDrawerToggle toggle;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product_owner);
        //set toolbar thay thế cho actionbar
        setSupportActionBar(toolbar);
        Anhxa();
        // Tạo toggle
        toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.drawer_open,R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); // tạo fab và bắt sự kiện khi click fab
        fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //     .setAction("Action", null).show();
                        Toast.makeText(ProductOwnerActivity.this, "Chức nănng đang thực hiện", Toast.LENGTH_SHORT).show();
                }
        });

//tạo navigation và bắt sự kiện
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_product_owner);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
@Override
public boolean onNavigationItemSelected(MenuItem menuItem) {
        xulychonmenu(menuItem);
        return false;
        }
        });
        }
public void xulychonmenu(MenuItem menuItem) // bắt sự kiện khi click vào item
        {
        int id=menuItem.getItemId();
                //tao class fragment
        Fragment fragment=null;
        Class classfragment=null;
        if(id==R.id.nav_project)
        classfragment=ProjectFragment.class; // gọi class fragment khi click
        if(id==R.id.nav_ProductBacklog)
                classfragment=ProductBacklogFragment.class;
        if(id==R.id.nav_Process)
                classfragment=ProcessFragment.class;
        if(id==R.id.nav_Sprint)
                classfragment=SprintManagementFragment.class;
        if(id==R.id.nav_SMM)
                classfragment=SprintEvents.class;
        try {
                fragment=(Fragment)classfragment.newInstance();
                FragmentManager fmanager= getSupportFragmentManager();
                fmanager.beginTransaction()
                .replace(R.id.flContent_product_owner,fragment)
                .commit();
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                drawer.closeDrawer(GravityCompat.START);
                }catch(Exception e) {

                }
                }

@Override
public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
        }
@Override
//Bắt sự kiện khi nhấn vào nút back trên thiết bị
public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_product_owner);
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
        drawer=(DrawerLayout)findViewById(R.id.drawer_layout_product_owner);
        toolbar = (Toolbar) findViewById(R.id.tb_Menu);

        }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.product_owner_drawer, menu);
        return true;
        }

public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //bắt sự kiện nút setting góc phải phía trên màn hình . Cái này hiện tại t ẩn và chưa làm gì hết , t  dự định chuyển nó thành notification , m xem cái product_owner_menu.xml sẽ thấy cái đó
        if (toggle.onOptionsItemSelected(item)) {
        return true;
        }
        if (id == R.id.action_settings) {
                drawer.openDrawer(Gravity.START);
        return true;
        }
        if(id==android.R.id.home)
        drawer.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
        }
        }
