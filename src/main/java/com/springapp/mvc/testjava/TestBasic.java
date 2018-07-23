package com.springapp.mvc.testjava;

import java.util.Base64;
import java.util.Random;

public class TestBasic {

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.hashCode());
    }

    public static void main(String[] args) {

        TestBasic testBasic = new TestBasic();
        testBasic = null;
        while (true){
            Random random = new Random();
            Integer i = random.nextInt(1000000000);
            String s = new String(Base64.getEncoder().encode(i.toString().getBytes()));
            System.out.println(s);
        }

    }
}
