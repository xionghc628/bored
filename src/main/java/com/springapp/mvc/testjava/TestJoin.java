package com.springapp.mvc.testjava;

import java.util.UUID;

/**
 * Created by xionghuacheng on 2018/4/25.
 */
public class TestJoin {

    public static volatile Integer a = 1;


    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                for(int i =0;i<100;i++){
                    System.out.println(name +" : "+i);
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                for(int i =100;i < 200;i++){
                    System.out.println(name +" : "+i);
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        thread2.start();

//        thread.yield();


        System.out.println("end");

    }


    public static String getUUID(){
        UUID uuid= UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

}
