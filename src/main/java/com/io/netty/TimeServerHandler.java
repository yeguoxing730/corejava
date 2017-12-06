package com.io.netty;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/19/17
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

import java.util.Date;
public class TimeServerHandler  extends ChannelInboundHandlerAdapter{
    private static Logger logger = Logger.getLogger(TimeServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("Server -> read");

        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8");

        System.out.println("timeServer received order: " + body);

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? (new Date()).toGMTString() : "BAD ORDER";

        //response
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        //异步发送应答消息给客户端: 这里并没有把消息直接写入SocketChannel,而是放入发送缓冲数组中
        final ChannelFuture f =ctx.writeAndFlush(resp);
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
           //     assert f == future;
                System.out.println("The server have been sent msg to client successful.");
                ctx.close();
            }
        }); // (4)

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Server -> read complete");

        //将发送缓冲区中数据全部写入SocketChannel
        //ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        ctx.close();
    }

}
