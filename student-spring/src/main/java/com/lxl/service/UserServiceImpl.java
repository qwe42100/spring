package com.lxl.service;
import com.lxl.dao.UserDao;
import com.lxl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean add(User user) {
        user.setIsAdmin(0);
        return userDao.insert(user)>0;
    }

    @Override
    public User getByUsername(String username) {
        return userDao.selectByUsername(username);
    }
}
