package com.example.ziv.swipebackexample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.ziv.swipebackexample.utils.StateBarTranslucentUtils;

/**
 * Created by JiaQing on 2016/7/17.
 * 含有DrawerLayout+NavigationView 页面
 * 不使用android:fitsSystemWindows=true属性,
 * 在ToolBar外面套一层布局，然后为ToolBar设置顶部margin
 */
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSwipeBackEnable(false);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initView();
        initData();

        //DrawerLayout兼容4.4
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //将侧边栏顶部延伸至status bar
            drawer.setFitsSystemWindows(true);
            //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
            drawer.setClipToPadding(false);
        }
    }


    @Override
    protected void initView() {
       // super.initView();
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);


        //获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int stateBarHeight =  getResources().getDimensionPixelSize(resourceId);
        //设置margin
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mToolBar.getLayoutParams();
        layoutParams.setMargins(0, stateBarHeight, 0, 0);
        mToolBar.setLayoutParams(layoutParams);
    }


    @Override
    protected void initData() {
        super.initData();
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
        getMenuInflater().inflate(R.menu.main, menu);
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


    public void next(View view) {
        startActivity(new Intent(context, SecondActivity.class));
    }
}
