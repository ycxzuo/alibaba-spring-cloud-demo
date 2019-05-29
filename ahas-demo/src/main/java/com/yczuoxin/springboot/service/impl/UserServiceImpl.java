package com.yczuoxin.springboot.service.impl;

import com.yczuoxin.springboot.mappers.primary.UserDao;
import com.yczuoxin.springboot.model.User;
import com.yczuoxin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Long id) {
        return userDao.selectById(id);
    }

}
