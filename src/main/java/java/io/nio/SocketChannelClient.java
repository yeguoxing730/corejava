package java.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 3/8/17
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class SocketChannelClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://127.0.0.1", 9999));
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            socketChannel.write(buf);
        }
    }
    static void nonBlockingClient() throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("http://localhost", 9999));
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            socketChannel.write(buf);
        }
        while(! socketChannel.finishConnect() ){
            //wait, or do something else...
        }
    }
}
