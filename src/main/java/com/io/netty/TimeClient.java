package com.io.netty;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/19/17
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
    public void connect(int port, String host) throws Exception {
        //配置客户端NIO 线程组
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap client = new Bootstrap();

        try {
            client.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new TimeCLientHandler());
                        }
                    });

            //绑定端口, 异步连接操作
            ChannelFuture future = client.connect(host, port).sync();

            //等待客户端连接端口关闭
            future.channel().closeFuture().sync();
        } finally {
            //优雅关闭 线程组
            group.shutdownGracefully();
        }
    }

    /**
     * main 函数
     *
     * @param args
     */
    public static void main(String[] args) {
        TimeClient client = new TimeClient();
        try {
            client.connect(18888, "127.0.0.1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
