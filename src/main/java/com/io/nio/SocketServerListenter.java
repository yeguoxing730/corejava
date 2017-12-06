package com.io.nio;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 3/8/17
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class SocketServerListenter {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));

        while(true){
            SocketChannel socketChannel =
                    serverSocketChannel.accept();
            System.out.println("get....");
            //do something with socketChannel...
        }
    }
     static void nonBlockListen() throws Exception{
         ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

         serverSocketChannel.socket().bind(new InetSocketAddress(9999));
         serverSocketChannel.configureBlocking(false);

         while(true){
             SocketChannel socketChannel =
                     serverSocketChannel.accept();

             if(socketChannel != null){
                 //do something with socketChannel...
             }
         }
    }
}
