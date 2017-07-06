package com.xinguang.freshworld.lifecomponent;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by 林其望 on 2017/7/3.
 * email 1105896230@qq.com
 * blog
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user where uid=:uid")
    User getUser(long uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User users);

    @Delete
    void delete(User user);

}
