package com.springapp.mvc.testconcurrent;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

/**
 * Created by xionghuacheng on 2018/4/25.
 *
 * 通过信号量完成一个生产者消费者模式
 */
public class TestSemaphore {

    /**
     * 数据列表
     */
    private Queue<String> dataList = new LinkedBlockingDeque<>();

    /**
     * 生产者信号
     */
    private Semaphore producter = new Semaphore(10);


    private Semaphore consumer = new Semaphore(0);

    public String get() throws Exception{
        consumer.acquire();
        String str =  dataList.poll();
        producter.release();
        return str;
    }


    public void put(String data) throws Exception{
        producter.acquire();
        dataList.offer(data);
        consumer.release();
    }

    public static void main(String[] args) throws Exception{
        final TestSemaphore testSemaphore = new TestSemaphore();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int count = 1;
                    while (true){
                        System.out.println("消费" + count + ":" + testSemaphore.get());
                        count++;
                        Thread.sleep(1000L);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int count = 1;
                    while (true){
                        testSemaphore.put("sss"+count);
                        System.out.println("生产：sss"+count);
                        count++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
