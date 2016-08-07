package com.example.ziv.swipebackexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import com.example.ziv.swipebackexample.utils.StateBarTranslucentUtils;
import java.io.File;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * Created by JiaQing on 2016/7/17.
 */
public class BaseActivity extends SwipeBackActivity {

    protected String TAG = this.getClass().getSimpleName();

    // 右滑返回
    private SwipeBackLayout mSwipeBackLayout;
    protected RelativeLayout mTitleBar;
    protected Toolbar mToolBar;

    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        mSwipeBackLayout = getSwipeBackLayout();
        // 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    protected void initView() {

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);
        //状态栏着色
        StateBarTranslucentUtils.setStateBarColor(this);

    }

    protected void initData() {

        File file ;

    }

}
