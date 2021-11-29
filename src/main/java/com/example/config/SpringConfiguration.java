package com.example.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

// 标志该类是Spring的核心配置类
@Configuration
//@PropertySource("classpath:db.properties") // 加载db.properties配置文件
@ComponentScan("com.example") // 组件扫描
@Import({DataSourceConfiguration.class}) // 里面接受一个可用逗号隔开的对象
public class SpringConfiguration {

//    @Value("${db.driver}")
//    private String driver;
//
//    @Value("${db.url}")
//    private String url;
//
//    @Value("${db.username}")
//    private String username;
//
//    @Value("${db.password}")
//    private String password;

//    @Bean("dataSource") // Spring会将当前方法的返回值以指定名称存储到Spring容器中
//    public DataSource getDataSource() throws PropertyVetoException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass(driver);
//        dataSource.setJdbcUrl(url);
//        dataSource.setUser(username);
//        dataSource.setPassword(password);
//
//        return dataSource;
//    }
}
