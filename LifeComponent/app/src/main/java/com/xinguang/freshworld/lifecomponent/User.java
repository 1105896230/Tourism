package com.xinguang.freshworld.lifecomponent;

import android.app.Activity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.UUID;

/**
 * Created by 林其望 on 2017/7/3.
 * email 1105896230@qq.com
 * blog
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey
    public long uid;
    public String name;
    public long age;


    public User() {
        uid= System.currentTimeMillis();
    }
}
