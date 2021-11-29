package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// 使用@Component生产Spring容器中的实例
//@Component("userService")
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${db.driver}") // 从spring容器中寻找db.driver,并将其赋给driver
    private String driver;

    // @Autowired、@Qualifier一起使用，实现Bean的注入
    // 使用@Autowired(这个叫自动注入), 向Service中注入Dao
//    @Autowired // 按照数据类型从spring容器中进行匹配的
    // @Qualifier表示要注入谁，这里注入userDao
//    @Qualifier("userDao") // 是按照id的值从容器中进行匹配的，但注意@Qualifier要结合@Autowired一起使用
    @Resource(name="userDao") // @Resource相当于@Qualifier+@Autowired
    private UserDao userDao;

    // 当使用xml配置的方式生成对应的Bean时，set方法或构造函数都必须写
    // 当使用注解时，set方法或构造函数不需要写
    // 无参构造
//    public UserServiceImpl() {
//    }

    // 构造方法 实现依赖注入，有参构造
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 通过set方法实现将UserDao注入UserServiceImpl中，实现依赖注入
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @PostConstruct
    public void init() {
        System.out.println("service的初始化方法....");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("service的销毁方法");
    }

    @Override
    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) app.getBean("userDao");

        System.out.println(driver);

        userDao.save();

//        app.close();
    }
}
