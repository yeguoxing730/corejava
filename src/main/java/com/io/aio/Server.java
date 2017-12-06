package com.io.aio;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/17/17
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Server {
    private static int DEFAULT_PORT = 12346;
    private static AsyncServerHandler serverHandle;
    public volatile static long clientCount = 0;
    public static void start(){
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port){
        if(serverHandle!=null)
            return;
        serverHandle = new AsyncServerHandler(port);
        new Thread(serverHandle,"Server").start();
    }
    public static void main(String[] args){
        Server.start();
    }
}
