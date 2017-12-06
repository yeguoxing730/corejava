package com.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 5/18/17
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongEventMain {
    public static void main(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        LongEventFactory factory = new LongEventFactory();
        int ringBufferSize = 1024*1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(
                factory,ringBufferSize,executor, ProducerType.SINGLE,
                new YieldingWaitStrategy());
//        disruptor.handleEventsWith(new LongEventHandler());
        //一、 菱形操作 执行完hander1 和 handler2后执行handler3 handler1和handler2没有先后关系
        /**
         *           ->handler1
         * req --->                 -->handler3
         *           ->handler2
         * */
//        EventHandlerGroup<LongEvent> handlerGroup = disruptor.handleEventsWith(new LongEventHandler1(),new LongEventHandler2());
//        handlerGroup.then(new LongEventHandler3());
//        //二、顺序操作
//        disruptor.handleEventsWith(new LongEventHandler()).handleEventsWith(new LongEventHandler1()).handleEventsWith(new LongEventHandler2());
//        //三、六边形操作
//        /**
//         *           ->handler1  handler3
//         * req --->                          -->handler5
//         *           ->handler2  handler4
//         * */
        LongEventHandler1 h1 = new LongEventHandler1();
        LongEventHandler2 h2 = new LongEventHandler2();
        LongEventHandler3 h3 = new LongEventHandler3();
        LongEventHandler4 h4 = new LongEventHandler4();
        LongEventHandler5 h5 = new LongEventHandler5();
        disruptor.handleEventsWith(h1,h2);
        disruptor.after(h1).handleEventsWith(h3);
        disruptor.after(h2).handleEventsWith(h4);
        disruptor.after(h3,h4).handleEventsWith(h5);

        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
       // for(long a=0;a<1024*2048;a++){
        for(long a=0;a<100;a++){
            byteBuffer.putLong(0,a);
            producer.onData(byteBuffer);
        }
        disruptor.shutdown();
        executor.shutdown();

    }
}
