package com.itheima.users.dao;

import com.itheima.users.entity.User;

public interface UserDatabase {
    boolean save(User user);

    User queryByUsername(String username);
}
