package com.io.nio.demo;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/17/17
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    //测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        //运行服务器
        Server.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Client.start();
        while(Client.sendMsg(new Scanner(System.in).nextLine()));
    }
}
