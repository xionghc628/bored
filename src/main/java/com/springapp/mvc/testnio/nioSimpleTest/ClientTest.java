package com.springapp.mvc.testnio.nioSimpleTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by xionghuacheng on 2018/5/15.
 */
public class ClientTest {


    private SocketChannel socketChannel ;
    private InetSocketAddress serverAddress;
    private Selector selector  ;
    private ByteBuffer buf = ByteBuffer.allocate(1024) ;

    public ClientTest(){
        try {
            serverAddress = new
                    InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8888) ;
            socketChannel = SocketChannel.open(serverAddress) ;
            socketChannel.configureBlocking(false);
            selector = Selector.open() ;
            socketChannel.register(selector,
                    SelectionKey.OP_READ) ;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connectServer() throws IOException{
        while(true  ){
            int keys = selector.select() ;
            System.out.println("检测到动态...");
            if(keys > 0){
                Iterator<SelectionKey> itKeys =
                        selector.selectedKeys().iterator() ;
                while(itKeys.hasNext()){

                    SelectionKey key = itKeys.next() ;

                    if(key.isReadable()){
                        readMessageFromChannel() ;
                    }
                    itKeys.remove();
                }
            }
        }

    }

    public void readMessageFromChannel() throws IOException{
        buf.clear() ;
        socketChannel.read(buf) ;
        buf.flip();
        System.out.println("服务端返回数据：" + new String(buf.array() ,
                0 , buf.limit() , "UTF-8"));
    }

    public static void main(String[] args) throws IOException {

        ClientTest client = new ClientTest();
        client.connectServer();


    }
}
