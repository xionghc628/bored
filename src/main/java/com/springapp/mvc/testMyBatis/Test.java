package com.springapp.mvc.testMyBatis;

import com.springapp.mvc.testMyBatis.mapper.TestMapper;
import com.springapp.mvc.testMyBatis.proxy.TestMapperInvocationHandler;

import java.lang.reflect.Proxy;

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
public class Test {

    public static void main(String[] args) {
        TestMapper o = (TestMapper) Proxy.newProxyInstance(TestMapper.class.getClassLoader(), new Class[]{TestMapper.class}, new TestMapperInvocationHandler());
        o.getTest();
    }
}
