package com.springapp.mvc.testjava;

public class TestSingle {

    private volatile static TestSingle singles;


    private TestSingle() {

    }

    public static TestSingle getSingle(){
        if(singles!=null){
            return singles;
        } else {
            synchronized (TestSingle.class){
                if(singles == null){
                    singles = new TestSingle();
                }
                return singles;
            }
        }
    }
}
