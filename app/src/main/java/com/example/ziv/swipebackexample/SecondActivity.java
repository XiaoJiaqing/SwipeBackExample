package com.example.ziv.swipebackexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ziv.swipebackexample.utils.StateBarTranslucentUtils;

/**
 * Created by JiaQing on 2016/7/24.
 */
public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        //super.initView();
        mToolBar = (Toolbar) findViewById(R.id.toolbar);

        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);
    }

    public void next(View view){
        startActivity(new Intent(context,ThirdActivity.class));
    }




}
