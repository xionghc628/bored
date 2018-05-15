package com.springapp.mvc.testproxy;

/**
 * Created by xionghuacheng on 2018/4/17.
 */
public class TestProxy {

    public static void main(String[] args) {
        // 实例化目标对象
        UserService userService = new UserServiceImpl();

        // 实例化InvocationHandler
        TestProxyEntity invocationHandler = new TestProxyEntity(userService);

        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.add();
    }
}
