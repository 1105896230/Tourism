package com.xinguang.freshworld.lifecomponent;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Created by 林其望 on 2017/7/3.
 * email 1105896230@qq.com
 * blog
 */

public class MyObserver implements LifecycleObserver {

    public static String TAG="MyObery";
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        Log.e(TAG,"OnResume");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        Log.e(TAG,"onPause");
    }
}
