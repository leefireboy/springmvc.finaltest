/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.finaltest.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.libing.finaltest.bean.User;
import com.libing.finaltest.dao.UserDAO;
import com.libing.finaltest.util.JDBCDataSource;
import com.mysql.jdbc.PreparedStatement;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月18日下午2:28:52
 */
@Repository("userDAO")
public class MysqlUserDAO implements UserDAO {

    @Resource
    private JDBCDataSource dataSource;

    public JDBCDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(JDBCDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /** 根据唯一用户名查询系统用户，如果没有找到用户信息返回null */
    @Override
    public User findByName(String name) {
        System.out.println("利用JDBC技术查找User信息");
        String sql = "select id, name, pwd, phone from users where name = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, name);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setPhone(rs.getString("phone"));
            }
            rs.close();
            ps.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            dataSource.close(conn);
        }
    }

}
