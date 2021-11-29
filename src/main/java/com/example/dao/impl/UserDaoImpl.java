package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Properties;

// 使用@Component生产Spring容器中的实例
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
//    public UserDaoImpl() {
//        System.out.println("UserDaoImpl 创建...");
//    }
//
//    public void init() {
//        System.out.println("UserDaoImpl 初始化");
//    }
//
//    public void destory() {
//        System.out.println("UserDaoImpl 对象销毁");
//    }

    // 声明一个list，内部变量类型为String
    private List<String> strList;

    // map集
    private Map<String, User> userMap;

    private Properties properties;

    private String username;

    private int age;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
//        System.out.println(username + " === " + age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running...");
    }
}
