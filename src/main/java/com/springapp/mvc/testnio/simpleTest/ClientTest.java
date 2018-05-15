package com.springapp.mvc.testnio.simpleTest;

import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by xionghuacheng on 2018/5/15.
 */
public class ClientTest {

    public static void main(String[] args) throws IOException {
        try {
            System.out.println("尝试连接服务器ip端口 127.0.0.1:8889");
            Socket socket = new Socket("127.0.0.1",8989);
            System.out.println("客户端已经成功连接至服务器");
            //请求信息拼接
            Scanner scan = new Scanner(System.in);
            String ipRequest = scan.nextLine();
            String requestLength = String.format("%04d", ipRequest.length());//获取长度，不足的补0，如长度56，则输出0056
            ipRequest = requestLength+ipRequest;
            System.out.println("发送给服务端的信息是:"+ipRequest);
            InputStream in_withcode = new ByteArrayInputStream(ipRequest.getBytes());
            BufferedReader line = new BufferedReader(new InputStreamReader(in_withcode));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(line.readLine());
            //获取服务端返回信息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());
            printWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
