package com.example.ziv.swipebackexample;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by JiaQing on 2016/7/24.
 * 使用android:fitsSystemWindows=true属性,然后新建一个和ToolBar背景色一样的View添加到原来状态栏的位置
 */
public class FourthActivity extends BaseActivity {


    View mStatusBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
//
//        //以下方案在5.0以上部分手机内会有问题，会有半透明的背景
//        final int sdk = Build.VERSION.SDK_INT;
//        Window window = getWindow();
//        WindowManager.LayoutParams params = window.getAttributes();
//
//        if (sdk >= Build.VERSION_CODES.KITKAT) {
//            int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//            // 设置透明状态栏
//            if ((params.flags & bits) == 0) {
//                params.flags |= bits;
//                window.setAttributes(params);
//            }
//        }
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
    }


}
