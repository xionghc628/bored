package com.springapp.mvc.testAnnotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xionghuacheng on 2018/6/1.
 */
public class TestProxy implements InvocationHandler {

    private Object obj;

    public TestProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean annotationPresent = method.isAnnotationPresent(Xhc.class);
        Xhc declaredAnnotation = method.getAnnotation(Xhc.class);
        if(declaredAnnotation!=null){
            System.out.println(declaredAnnotation.value());
        }
        return method.invoke(obj,args);
    }


    public Object getProxy(){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
}
