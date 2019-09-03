package com.springapp.mvc.testMyBatis.proxy;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*******************************************************
 * Copyright (C) 2019 iQIYI.COM - All Rights Reserved
 *
 * <p>This file is part of bored.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * <p>Author(s): xionghuacheng
 * Created: 2019/9/3
 *******************************************************/
public class TestMapperInvocationHandler implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Select annotation = method.getAnnotation(Select.class);
        System.out.println(annotation.value()[0]);

        return null;

    }
}
