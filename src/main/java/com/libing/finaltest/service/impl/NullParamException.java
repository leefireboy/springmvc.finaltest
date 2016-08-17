/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.finaltest.service.impl;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月22日上午9:59:27
 */
public class NullParamException extends Exception {

    private static final long serialVersionUID = 8415362290914901266L;

    public NullParamException() {
        super();
    }

    public NullParamException(String message) {
        super(message);
    }

    public NullParamException(Throwable cause) {
        super(cause);
    }

    public NullParamException(String message, Throwable cause) {
        super(message, cause);
    }

}

