package com.example.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatasourceTest {
    @Test
    // 手动创建c3p0数据源
    public void testC3p0() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        // 获取资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        // 关闭数据源
        connection.close();
    }

    @Test
    // 手动创建c3p0数据源(加载properties配置文件的形式)
    public void testC3p0ByConfigFile() throws Exception {
        // 读取配置文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String driver = resourceBundle.getString("db.driver");
        String url = resourceBundle.getString("db.url");
        String username = resourceBundle.getString("db.username");
        String password = resourceBundle.getString("db.password");

        // 创建数据源对象,设置连接参数
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        // 获取资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        // 关闭数据源
        connection.close();
    }

    @Test
    // 手动创建druid数据源(加载properties配置文件的形式)
    public void testDruidByConfigFile() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 获取资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        // 关闭数据源
        connection.close();
    }

    @Test
    // 手动创建druid数据源
    public void testDruid() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 获取资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        // 关闭数据源
        connection.close();
    }

    @Test
    // 测试通过spring容器创建数据源对象
    public void testGenerateDataSourceBySpring () throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
