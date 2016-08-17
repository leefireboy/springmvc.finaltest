/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.libing.finaltest.bean.User;
import com.libing.finaltest.service.impl.UserService;
import com.libing.finaltest.util.JDBCDataSource;
import com.mysql.jdbc.PreparedStatement;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月21日下午10:00:31
 */
public class TestCase {

//    @Ignore
    @Test
    public void test() throws Exception {
        String conf = "spring-mvc.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        Properties prop = ac.getBean("jdbcProperties", Properties.class);
        JDBCDataSource jdbcds = ac.getBean("dataSource", JDBCDataSource.class);
        System.out.println(prop);
        System.out.println(jdbcds);
        System.out.println(jdbcds.getConnection());
        UserService userService = ac.getBean("userService", UserService.class);
        System.out.println(userService);
        User user = userService.login("李冰", "123456");
        System.out.println(user);
//        System.out.println(ac);
//        UserDAO userDAO = ac.getBean("userDAO", UserDAO.class);
//        User user = userDAO.findByName("libing");
//        System.out.println(user);
//        JDBCDataSource dataSource = ac.getBean("dataSource", JDBCDataSource.class);
//        System.out.println(dataSource);
//        User user = ac.getBean("user", User.class);
//        System.out.println(user);
//        HelloController hello = ac.getBean("helloController", HelloController.class);
//        System.out.println(hello);

        AbstractApplicationContext aac = (AbstractApplicationContext) ac;
        aac.close();
    }

    @Ignore
    @Test
    public void testJdbc() {
        try {
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "123456");
            String sql = "insert into users(name, pwd, phone) values (?,?,?)";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, "方修超");
            ps.setString(2, "123456");
            ps.setString(3, "13813838438");
            System.out.println(ps.toString());
            int i = ps.executeUpdate();
            System.out.println(i);
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

