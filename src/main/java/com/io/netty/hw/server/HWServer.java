package com.io.netty.hw.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HWServer {
    private int port;

    public HWServer(int port) {
        this.port = port;
    }
    public void start(){
        ServerBootstrap server = new ServerBootstrap();
        EventLoopGroup acceptGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        server.group(acceptGroup,workGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelInitializer());
        try {
            ChannelFuture future = server.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            acceptGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args){
        HWServer server = new HWServer(7788);
        server.start();
    }
}
