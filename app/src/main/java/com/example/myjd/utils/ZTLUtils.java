package com.example.myjd.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import com.example.myjd.view.R;


/**
 *
 */
public class ZTLUtils extends Activity {
    Activity activity;

    public ZTLUtils(Activity activity) {
        this.activity = activity;
    }

    public void setTranslucentStatus(View view) {
        //改变状态栏字体颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            this.activity.getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            // 透明状态栏
            this.activity.getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            this.activity.getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemStatusManager tintManager = new SystemStatusManager(this.activity);
            tintManager.setStatusBarTintEnabled(true);
            // 设置状态栏的颜色
            tintManager.setStatusBarTintResource(R.color.transparent);
            this.activity.getWindow().getDecorView().setFitsSystemWindows(true);
        }
    }
}
