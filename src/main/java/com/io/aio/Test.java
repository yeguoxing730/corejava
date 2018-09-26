package com.io.aio;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/17/17
 * Time: 2:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //运行服务器
        Server.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Client.start();
        System.out.println("请输入请求消息：");
        Scanner scanner = new Scanner(System.in);
        while (Client.sendMsg(scanner.nextLine())) ;
    }
}
