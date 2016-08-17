/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.finaltest.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.libing.finaltest.bean.User;
import com.libing.finaltest.dao.UserDAO;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月18日下午4:02:30
 */
@Service
public class UserService implements Serializable {

    private static final long serialVersionUID = -1435774289968060367L;

    @Resource
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String name, String pwd) throws NameOrPwdException, NullParamException {

        if (name == null || name.equals("") || pwd == null || pwd.equals("")) {
            throw new NullParamException("登录参数不能为空！！！");
        }

        User user = userDAO.findByName(name);
        if (user != null && user.getPwd().equals(pwd)) {
            System.out.println("密码正确，登录成功！");
            return user;
        }
        throw new NameOrPwdException("用户名或密码错误");
    }

}
