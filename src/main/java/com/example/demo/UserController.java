package com.example.demo;

import com.example.config.SpringConfiguration;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.save();
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
         // 通过bean的id获取Bean，需要进行类型强转
//        UserService userService = (UserService) app.getBean("userService");
//        userService.save();

        // 通过读取SpringConfiguration（AnnotationConfigApplicationContext）核心配置类创建Spring容器
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 通过字节码形式获取对应的Bean, 不需要进行类型强转换
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
