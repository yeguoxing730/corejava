package com.io.netty.hw.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class HWClient {
    private String host;
    private int port;

    public HWClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public void start(){
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap client = new Bootstrap();
        client.group(group).channel(NioSocketChannel.class).handler(new ClientChannelInitializer());
        try {
            ChannelFuture future = client.connect(host,port).sync();
            future.channel().writeAndFlush("Hello Netty Server ,I am a common client");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }


    }
    public static void main(String[] args){
        HWClient client = new HWClient("127.0.0.1",7788);
        client.start();
    }
}
