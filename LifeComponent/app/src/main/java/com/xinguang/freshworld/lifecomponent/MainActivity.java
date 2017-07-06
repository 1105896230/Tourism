package com.xinguang.freshworld.lifecomponent;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends LifecycleActivity {
    public static String TAG="MainActivity";
    public TextView mTvAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvAge=findViewById(R.id.tv_age);
//        getLifecycle().addObserver(new MyObserver());
//        UserLiveData user = new UserLiveData(this);
//        user.observe(this, new Observer<User>() {
//            @Override
//            public void onChanged(@Nullable User user) {
//                mTvAge.setText("年龄："+user.age);
//            }
//        });

        MyViewModel myViewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.getUser(this).observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mTvAge.setText("年龄："+user.age);
            }
        });
    }
}
