/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.finaltest.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.libing.finaltest.bean.User;
import com.libing.finaltest.service.impl.NameOrPwdException;
import com.libing.finaltest.service.impl.NullParamException;
import com.libing.finaltest.service.impl.UserService;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月22日下午9:47:17
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    public String loginForm() {
        return "login-form";
    }

    @RequestMapping("login-action1")
    public String checkLogin1(HttpServletRequest req) {
        System.out.println("---方法一---");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        try {
            User user = userService.login(name, pwd);
            req.getSession().setAttribute("user", user);
            return "success";
        } catch (NameOrPwdException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "login-form";
        } catch (NullParamException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "redirect:login.do";
        } catch (RuntimeException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "error";
        }

    }

    @RequestMapping("login-action2")
    public String checkLogin2(String name,
            @RequestParam("pwd")String password, HttpServletRequest req) {
        System.out.println("---方法二---");
        try {
            User user = userService.login(name, password);
            req.getSession().setAttribute("user", user);
            return "success";
        } catch (NameOrPwdException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "login-form";
        } catch (NullParamException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "login-form";
        } catch (RuntimeException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "error";
        }

    }

    @RequestMapping("login-action3")
    public String checkLogin3(User user, HttpServletRequest req) {
        System.out.println("---方法三---");
        try {
            user = userService.login(user.getName(), user.getPwd());
            // 登录成功将登录用户信息保存到当前回话当中
            req.getSession().setAttribute("user", user);
            return "success";
        } catch (NameOrPwdException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "login-form";
        } catch (NullParamException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "login-form";
        } catch (RuntimeException e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            return "error";
        }

    }

    @RequestMapping("login-action4")
    public ModelAndView checkLogin4(String name, String pwd) {
        System.out.println("---方法四---");
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            User user = userService.login(name, pwd);
            data.put("user", user);
            return new ModelAndView("success", data);
        } catch (NameOrPwdException e) {
            e.printStackTrace();
            data.put("message", e.getMessage());
            return new ModelAndView("login-form", data);
        } catch (NullParamException e) {
            e.printStackTrace();
            data.put("message", e.getMessage());
            return new ModelAndView("login-form", data);
        } catch (RuntimeException e) {
            e.printStackTrace();
            data.put("message", e.getMessage());
            return new ModelAndView("error", data);
        }

    }

    @RequestMapping("login-action5")
    public String checkLogin5(String name, String pwd, ModelMap model) {
        System.out.println("---方法五---");
        try {
            User user = userService.login(name, pwd);
            model.addAttribute("user", user);
            return "success";
        } catch (NameOrPwdException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "login-form";
        } catch (NullParamException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "login-form";
        } catch (RuntimeException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "error";
        }

    }

    @RequestMapping("login-action6")
    public String checkLogin6(@ModelAttribute("name")String name,
            @ModelAttribute("pwd")String pwd, Model model) {
        System.out.println("---方法六---");
        try {
            User user = userService.login(name, pwd);
            model.addAttribute("user", user);
            return "success";
        } catch (NameOrPwdException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "login-form";
        } catch (NullParamException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "login-form";
        } catch (RuntimeException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "error";
        }

    }

    private final String[] msg = {"再来一次","下次就对了","没关系还有机会"};

    @ModelAttribute("next")
    public String getNext() {
        Random r = new Random();
        return msg[r.nextInt(msg.length)];
    }

}
