package com.springapp.mvc.testjava;

/**
 * Created by xionghuacheng on 2018/4/25.
 */
public class Test {

    public static Integer a = 1;

    public static Integer b;


    static {
        b = a;
        a++;
    }


    public static void main(String[] args) {
        System.out.printf(a+"+"+b);
    }

}
