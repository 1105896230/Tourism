package com.xinguang.freshworld.lifecomponent;

import android.Manifest;
import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by 林其望 on 2017/7/3.
 * email 1105896230@qq.com
 * blog
 */

public class UserLiveData extends MutableLiveData<User> {
    public static String TAG="LocationLiveData";
    private Context context;
    private  User user;
    AppDataBase db;
    public UserLiveData(final Context context) {
        this.context=context;
        UserLiveData.this.user=new User();

        db=Room.databaseBuilder(context,AppDataBase.class,"database-name").build();
            new AsyncTask<Void,Void,User>(){

                @Override
                protected User doInBackground(Void... voids) {
                    return  db.userDao().getUser(1499060593510l);
                }

                @Override
                protected void onPostExecute(User user) {
                    if (user!=null) {
                        UserLiveData.this.user=user;
                    }else {
                        UserLiveData.this.user=new User();
                    }
                }
            }.execute();
    }

    @Override
    protected void onActive() {
        Log.e(TAG,"onActive");
        runAge();
    }

    @Override
    protected void onInactive() {
        Log.e(TAG,"onInactive");
        stopAge();
    }

    public STATE mState=STATE.Normal;
    public enum STATE{
        Start,
        Stop,
        Normal,
    }
    public void runAge(){
        mState=STATE.Start;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mState==mState.Start){
                    user.age=user.age+1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    postValue(user);
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            db.userDao().updateUser(user);
                        }
                    });

                }
            }
        }).start();
    }
    public void stopAge(){
        mState=STATE.Stop;
    }
}
