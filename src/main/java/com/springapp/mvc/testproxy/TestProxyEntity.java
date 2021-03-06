package com.springapp.mvc.testproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xionghuacheng on 2018/4/17.
 */
public class TestProxyEntity implements InvocationHandler {

    // ??????
    private Object target;

    /**
     * ??????
     * @param target ??????
     */
    public TestProxyEntity(Object target) {
        super();
        this.target = target;
    }


    /**
     * ?????????????
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // ?????????????????????????
        System.out.println("------------------before------------------");

        // ?????????????
        Object result = method.invoke(target, args);

        // ?????????????????????????
        System.out.println("-------------------after------------------");

        return result;
    }

    /**
     * ????????????????
     * @return ???????
     */
    public Object getProxy() {
        Class cla = target.getClass();
        Class[] c = cla.getInterfaces();
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}
