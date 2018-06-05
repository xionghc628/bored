package com.springapp.mvc.testAnnotation;

import java.lang.reflect.Method;

/**
 * Created by xionghuacheng on 2018/6/1.
 */
public class Test implements ITest{


    public static void main(String[] args) {
        Test test = new Test();
        TestProxy testProxy = new TestProxy(test);
        ITest proxy = (ITest)testProxy.getProxy();
        proxy.testA("sssssfsfsf");

        Method[] methods = test.getClass().getMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Xhc.class)){
                System.out.println(method.getName());
            }
        }
    }

    @Xhc(value = "testA")
    public void testA(String name){
        System.out.println(name);
    }

}
