package com.springapp.mvc.testFile;

import java.io.File;

public class TestFile {

    public static void main(String[] args) {
        File f = new File("d:\\work");
        //File f = new File("src\\com\\itheima_01\\RecurrenceDemo.java");
        method(f);
    }

    public static void method(File file) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                //判断是否是文件对象
                if(f.isFile()) {
                    if(f.getName().endsWith(".java")) {
                        System.out.println("文件："+f.getName());
                    }
                }
                else if(f.isDirectory()){
                    //是一个目录对象
                    method(f);
                    System.out.println("目录："+ f.getName());
                }
            }
        }
    }

}
