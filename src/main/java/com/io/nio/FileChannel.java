package com.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 3/8/17
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileChannel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("file/io-data.txt", "rw");
            java.nio.channels.FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            aFile.close();
        }
    }


}
