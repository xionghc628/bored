package com.springapp.mvc.testjava;

public class TestSingle {

    private static TestSingle singles;


    public TestSingle() {

    }

    public TestSingle getSingle(){
        if(singles!=null){
            return singles;
        } else {
            synchronized (this){
                if(singles == null){
                    singles = new TestSingle();
                }
                return singles;
            }
        }
    }
}
