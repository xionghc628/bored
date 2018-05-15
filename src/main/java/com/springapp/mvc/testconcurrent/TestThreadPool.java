package com.springapp.mvc.testconcurrent;

import java.util.concurrent.*;

/**
 * Created by xionghuacheng on 2018/5/2.
 */
public class TestThreadPool {

    public static void main(String[] args) {

        //测试普通线程池
//        final ExecutorService executorService = new ThreadPoolExecutor(10, 10,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
//        for(int i = 0;i<52;i++){
//            final int num = i;
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "运行"+num);
//                    try {
//                        Thread.sleep(5000l);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "结束"+num);
//                }
//            });
//        }

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        System.out.println("一会该你了："+System.currentTimeMillis());
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("该你了："+System.currentTimeMillis());
            }
        },-10,TimeUnit.SECONDS);


    }



}
