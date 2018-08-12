package com.example.myjd.base;

import android.app.Application;

import com.facebook.fresco.helper.Phoenix;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/11$ 23:07$
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Phoenix.init(this);
    }
}
