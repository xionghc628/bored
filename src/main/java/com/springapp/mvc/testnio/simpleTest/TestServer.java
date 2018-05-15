package com.springapp.mvc.testnio.simpleTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xionghuacheng on 2018/5/15.
 */
public class TestServer {

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(8989);

        while (true){
            Socket socket = serverSocket.accept();
            if(socket!=null) {
                //获取请求过来的数据
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = in .readLine();
                System.out.println("客户端的请求信息 :"+ line);
                //返回处理信息
                PrintWriter out= new PrintWriter(socket.getOutputStream(),true);
                out.println("服务端已收到请求信息销售价实际上是计算机!");
                out.close();
                in.close();
                socket.close();
            }
        }
    }
}
