/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.finaltest.service.impl;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月22日上午9:56:05
 */
public class NameOrPwdException extends Exception {

    private static final long serialVersionUID = 7480995259026817834L;

    public NameOrPwdException() {
        super();
    }

    public NameOrPwdException(String message) {
        super(message);
    }

    public NameOrPwdException(Throwable cause) {
        super(cause);
    }

    public NameOrPwdException(String message, Throwable cause) {
        super(message, cause);
    }

}
