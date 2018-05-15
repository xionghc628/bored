package com.springapp.mvc.testnio.client;

import com.springapp.mvc.testnio.UserService;

import java.net.InetSocketAddress;

/**
 * Created by xionghuacheng on 2018/4/23.
 */
public class testClient {

    public static void main(String[] args) {
        UserService service = UserProxy.getRemoteProxyObj(UserService.class, new InetSocketAddress("localhost", 8088));
        String name = service.getName(null);
        System.out.println(name);
    }


}
