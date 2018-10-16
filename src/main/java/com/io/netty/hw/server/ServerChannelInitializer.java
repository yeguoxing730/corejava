package com.io.netty.hw.server;

import com.io.netty.hw.MarshallingCodeCFactory;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //解决粘包拆包问题
        pipeline.addLast(new LineBasedFrameDecoder(2048));
//        pipeline.addLast("decoder",new StringDecoder());
//        pipeline.addLast("encoder",new StringEncoder());
        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
        pipeline.addLast("handler1",new HWServerHandler());
    }
    /**
     * TCP以流的方式进行数据传输，上层应用协议为了对消息进行区分，一般采用如下4种方式：
     *
     * 1.消息长度固定，累计读取到消息长度总和为定长Len的报文之后即认为是读取到了一个完整的消息。计数器归位，重新读取。
     * 2.将回车换行符作为消息结束符。
     * 3.将特殊的分隔符作为消息分隔符，回车换行符是他的一种。
     * 4.通过在消息头定义长度字段来标识消息总长度。
     *
     * FixedLengthFrameDecoder属于第一种
     * LineBasedFrameDecoder 是第二种情况
     * DelimiterBasedFrameDecoder 是第三种情况
     *         ByteBuf delimiter = Unpooled.copiedBuffer("\t".getBytes());
     *         pipeline.addLast("framer", new DelimiterBasedFrameDecoder(2048,delimiter));
     * LengthFieldBasedFrameDecoder是第四种情况
     * https://blog.csdn.net/a953713428/article/details/68939371
     * Netty编码技术 java序列号 ProtoBuf Marshalling编码技术
     *  https://blog.csdn.net/a953713428/article/details/72353833
     *  ①JBoss的Marshalling包
     *  ②google的Protobuf
     *  ③基于Protobuf的Kyro
     *  ④Apache的Thrift
     *
     */
}
