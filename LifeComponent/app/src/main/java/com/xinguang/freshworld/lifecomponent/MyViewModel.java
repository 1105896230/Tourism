package com.xinguang.freshworld.lifecomponent;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

/**
 * Created by 林其望 on 2017/7/3.
 * email 1105896230@qq.com
 * blog
 */

public class MyViewModel extends ViewModel {

    public UserLiveData user;
    public LiveData<User> getUser(Context context){
       if (user==null) {
           user = new UserLiveData(context);
       }
       return user;
    }

}
