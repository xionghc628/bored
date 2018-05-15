package com.springapp.mvc.testconcurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xionghuacheng on 2018/4/25.
 */
public class TestCountDownLanch {

    public static void main(String[] args) throws Exception{
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"已经开始了");
                    try {
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"已经结束了");
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("main开始睡眠了");
        Thread.sleep(10000L);
    }
}
