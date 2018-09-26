package com.io.netty;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/19/17
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ChildChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast("timeServerHandler", new TimeServerHandler());
    }
}
