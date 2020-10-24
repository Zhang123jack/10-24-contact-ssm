package com.zxr.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zxr.dao.DaoConfig;
import com.zxr.service.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
@Configuration
//@ComponentScan("com.zxr")
@Import({DaoConfig.class, ServiceConfig.class})
@PropertySource("database.properties")
public class SpringConfig {
    @Value("${driverClassName}")
    private String driver;

    @Value("${url}")
    private String url;

    @Value("${user}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        // 返回一个Object，Spring会把这个object放到容器当中管理
        // xml - class
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/contact?useUnicode=true&characterEncoding=utf8");
//        dataSource.setUsername("root");
//        dataSource.setPassword("1234");
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
}
