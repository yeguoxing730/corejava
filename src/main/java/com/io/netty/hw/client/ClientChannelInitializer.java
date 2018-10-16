package com.io.netty.hw.client;

import com.io.netty.hw.MarshallingCodeCFactory;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
//        pipeline.addLast("decoder",new StringDecoder());
//        pipeline.addLast("encoder",new StringEncoder());
        pipeline.addLast(new LineBasedFrameDecoder(2048));
        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
        pipeline.addLast("handler1",new HWClientHandler());
        pipeline.addLast("handler2",new BaseClientHandler());
    }
}
