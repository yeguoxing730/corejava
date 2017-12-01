package java.io.netty;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/19/17
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
public class TimeCLientHandler extends ChannelInboundHandlerAdapter{
    private final ByteBuf firstMSG;

    public TimeCLientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMSG = Unpooled.buffer(req.length);
        firstMSG.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client -> active");

        ctx.writeAndFlush(firstMSG);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client -> read");

        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8");

        System.out.println("NOW is: " + body);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
