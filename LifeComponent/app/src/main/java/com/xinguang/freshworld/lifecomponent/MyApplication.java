package com.xinguang.freshworld.lifecomponent;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by 林其望 on 2017/7/3.
 * email 1105896230@qq.com
 * blog
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
