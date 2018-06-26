package com.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {

    public static void main(String[] args)throws Exception{
        String originFileName = FileCopy.class.getClassLoader().getResource("io-data.txt").getPath() ;
        String dstFileName = FileCopy.class.getClassLoader().getResource("io-data2.txt").getPath();
        FileCopy.copyFile(originFileName,dstFileName);
    }
    public static void copyFile(String originFileName,String dstFileName) throws Exception{
        FileInputStream in = new FileInputStream(originFileName);
        FileOutputStream out = new FileOutputStream(dstFileName);
        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            buffer.clear();
            if(inChannel.read(buffer)==-1){
                break;
            }
            buffer.flip();
            outChannel.write(buffer);
        }
        in.close();
        out.close();
    }

}

