package com.springapp.mvc.testnio.servcer;

import com.springapp.mvc.testnio.UserService;

/**
 * Created by xionghuacheng on 2018/4/23.
 */
public class TestService {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(UserService.class, UserServiceImpl.class);
                    serviceServer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while (true){
            Thread.sleep(1000L);
        }
    }
}
