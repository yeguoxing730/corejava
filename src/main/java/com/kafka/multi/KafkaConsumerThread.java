package com.kafka.multi;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 11/24/17
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class KafkaConsumerThread implements Runnable {
    private KafkaStream<byte[], byte[]> stream;

    public KafkaConsumerThread(KafkaStream<byte[], byte[]> stream) {
        this.stream = stream;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()) {
            MessageAndMetadata<byte[], byte[]> mam = it.next();
            System.out.println(Thread.currentThread().getName() + ": partition[" + mam.partition() + "],"
                    + "offset[" + mam.offset() + "], " + new String(mam.message()));

        }
    }
}
