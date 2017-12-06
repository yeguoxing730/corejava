package com.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 5/18/17
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MultiProducerAndConsumerMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        LongEventFactory factory = new LongEventFactory();
        int ringBufferSize = 1024*1024;
        RingBuffer<LongEvent> ringBuffer = RingBuffer.create(ProducerType.MULTI,factory,ringBufferSize,new YieldingWaitStrategy());
        SequenceBarrier barriers = ringBuffer.newBarrier();
        Consumer[] consumers = new Consumer[3];
        for(int i =0;i<consumers.length;i++){
            consumers[i] = new Consumer("c"+i);
        }
        WorkerPool<LongEvent> workerPool = new WorkerPool<LongEvent>(ringBuffer,
                barriers,new IntEventExceptionHandler(),
               consumers);
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        workerPool.start(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

        final CountDownLatch latch = new CountDownLatch(1);
        for(int i=0;i<100;i++){
            final LongEventProducer producer = new LongEventProducer(ringBuffer);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    ByteBuffer byteBuffer = ByteBuffer.allocate(8);
                    for(int a=0;a<100;a++){
                        byteBuffer.putLong(0,a);
                        producer.onData(byteBuffer);
                    }
                }
            }).start();
        } ;
        Thread.sleep(2000);
        System.out.println("-------------------开始生产---------------");
        latch.countDown();
        Thread.sleep(5000);
        System.out.println("总数："+consumers[0].getCount());

    }
}
