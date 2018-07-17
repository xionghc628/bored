package com.springapp.mvc.testLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition {

    private ReentrantLock lock = new ReentrantLock();

    private Condition a = lock.newCondition();

    private Condition b = lock.newCondition();

    private List<String> list = new ArrayList<>(5);

    private int count = 5;

    public void add(String str) {

        try {
            lock.lock();
            if (list.size() == count) {
                a.await();
            }
            list.add(str);
            b.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public String get() {

        try {
            lock.lock();
            if (list.size() == 0) {
                b.await();
            }
            String str = list.get(0);
            list.remove(0);
            a.signalAll();
            return str;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {

        TestCondition sync = new TestCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    int count = 1;
                    while (true) {
                        System.out.println("消费" + count + ":" + sync.get());
                        count++;
                        Thread.sleep(2000L);
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
                    while (true) {
                        sync.add("sss" + count);
                        System.out.println("生产：sss" + count);
                        count++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
