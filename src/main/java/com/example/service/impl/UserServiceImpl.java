package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 无参构造
    public UserServiceImpl() {
    }

    // 构造方法 实现依赖注入，有参构造
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // 通过set方法实现将UserDao注入UserServiceImpl中，实现依赖注入
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) app.getBean("userDao");

        userDao.save();
    }
}
