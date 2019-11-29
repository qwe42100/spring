package com.lxl.service;

import com.lxl.pojo.User;

public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean add(User user);

    /**
     * 根据登录名称，查询用户
     * @param username
     * @return
     */
    User getByUsername(String username);
}
