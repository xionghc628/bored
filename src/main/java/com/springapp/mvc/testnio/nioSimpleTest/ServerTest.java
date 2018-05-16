//package com.springapp.mvc.testnio.nioSimpleTest;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.ServerSocketChannel;
//
///**
// * Created by xionghuacheng on 2018/5/15.
// */
//public class ServerTest {
//
//    public static void main(String[] args) {
//        private Selector selector  ;
//
//        private ServerSocketChannel serverChannel ;
//
//        private ByteBuffer buff ;
//
//        public void SelectorServer(){
//            try {
//                selector = Selector.open() ;
//                serverChannel = ServerSocketChannel.open() ;
//                serverChannel.configureBlocking(false) ;
//                serverChannel.socket().bind(new InetSocketAddress(8888));
//                serverChannel.register(selector, SelectionKey.OP_ACCEPT) ;
//                buff = ByteBuffer.allocate(1024) ;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void openServer() throws IOException{
//
//            while(true){
//                System.out.println("正在select等待下一步操作...");
//                int keys = selector.select() ;
//                if(keys > 0){
//                    Iterator<SelectionKey> itKeys = selector.selectedKeys().iterator() ;
//                    while(itKeys.hasNext()){
//                        SelectionKey key = itKeys.next() ;
//                        if(key.isAcceptable()){
//                            System.out.println("发现有客户端加入，Accept方法激活...");
//                            ServerSocketChannel ss = (ServerSocketChannel)key.channel();
//                            SocketChannel clientChannel = ss.accept();
//                            System.out.println("接收到来自" + clientChannel.socket().getRemoteSocketAddress() + "的请求");
//                            writeMessageToClient(clientChannel , "Hello Welcome!");
//                            System.out.println("向客户端" + clientChannel.socket().getRemoteSocketAddress() + "发送信息成功");
//                        }
//                        itKeys.remove();
//                    }
//
//                }
//
//            }
//
//        }
//
//        public void writeMessageToClient(SocketChannel clientChannel , String message){
//            try {
//                buff.clear() ;
//                buff.put(message.getBytes("UTF-8"))  ;
//                buff.flip() ;
//                clientChannel.write(buff) ;
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public static void main(String[] args) throws IOException {
//
//            SelectorServer ss = new SelectorServer() ;
//
//            ss.openServer();
//
//        }
//    }
//}
