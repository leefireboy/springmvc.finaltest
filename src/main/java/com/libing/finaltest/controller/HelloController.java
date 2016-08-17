/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.finaltest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * <P>
 * Description:TODO
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月20日上午12:05:29
 */
@Controller
public class HelloController{

    @RequestMapping("/test2/hello")
    public String execute() throws Exception {
        return "hello";
    }

}
