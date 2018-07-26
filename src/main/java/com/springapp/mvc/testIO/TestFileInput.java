package com.springapp.mvc.testIO;

import java.io.*;

public class TestFileInput {


    public static void main(String[] args) {
        FileInputStream file = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            file = new FileInputStream("D://dao.log");

            bufferedInputStream = new BufferedInputStream(file);

            byte[] bytes = new byte[100000];

            int read = bufferedInputStream.read(bytes);
//            if(read > 0){
//                String s = new String(bytes);
//                System.out.println(s);
//            }

            FileOutputStream fileOutputStream = new FileOutputStream("D://dao.log."+System.currentTimeMillis());

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            bufferedOutputStream.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
