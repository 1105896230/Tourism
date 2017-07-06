package com.xinguang.freshworld.lifecomponent;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by 林其望 on 2017/7/3.
 * email 1105896230@qq.com
 * blog
 */

@Database(entities = {User.class},version = 1, exportSchema = false)
public abstract
class AppDataBase extends RoomDatabase{
    public abstract UserDao userDao();
}
