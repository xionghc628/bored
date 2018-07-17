package com.springapp.mvc.testLock;

import java.util.ArrayList;
import java.util.List;

public class TestSync {

    private Object a = new Object();

    private Object b = new Object();

    private int count = 5;

    private List<String> list = new ArrayList<>(5);

    public void add(String str) {

        synchronized (a) {
            if (list.size() == count) {
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (this) {
            list.add(str);
        }
        synchronized (b) {
            try {
                b.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String get() {

        synchronized (b) {
            if (list.size() == 0) {
                try {
                    b.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        String str = "";
        synchronized (this) {
            str = list.get(0);
            list.remove(0);
        }
        synchronized (a) {
            try {
                a.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static void main(String[] args) throws Exception {

        TestSync sync = new TestSync();
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
