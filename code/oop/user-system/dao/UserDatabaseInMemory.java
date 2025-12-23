package com.itheima.users.dao;

import com.itheima.users.entity.User;

public class UserDatabaseInMemory implements UserDatabase {
    private static final int MAX_SIZE =1000;
    private static final User[] USERS = new User[MAX_SIZE];
    private static int index = 0;

    @Override
    public boolean save(User user) {
        //判断用户数是否超过最大值
        if (index >= MAX_SIZE) {
            System.out.println("用户数已满！");
            return false;
        }
        USERS[index] = user;
        index++;
        user.setId(index);
        return true;
    }

    @Override
    public User queryByUsername(String username) {
        if(username == null || username.equals("")) {
            return null;
        }
        //遍历用户数组
        for (int i = 0; i < index; i++) {
            User user = USERS[i];
            //判断用户名是否一致
            if (user != null && username.equals(user.getUsername())){
                return user;
            }
        }
        //数组遍历完，依然没有，说明不存在
        return null;
    }
}
