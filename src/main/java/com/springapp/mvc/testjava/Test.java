package com.springapp.mvc.testjava;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xionghuacheng on 2018/4/25.
 */
public class Test {

    public static volatile Integer a = 1;


    public static void main(String[] args) {
//        2147483147
//        synchronized (a){
//            a += 111111;
//
//            System.out.println(a);
//        }


//        Map<String, String> map = new HashMap<>();
//        //循环添加字符
//        for(int i=1;i < 10;i++){
//            String uuid = getUUID();
//            map.put(uuid,uuid);
//        }


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
