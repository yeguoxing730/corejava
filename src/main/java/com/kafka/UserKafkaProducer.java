package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 11/13/17
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserKafkaProducer extends Thread {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    private final Properties props = new Properties();

    public UserKafkaProducer(String topic) {
//      props.put("metadata.broker.list", "");
        props.put("bootstrap.servers", "10.35.63.91:9092");
        props.put("acks", "all");
        props.put("retries", 3);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<Integer, String>(props);
        this.topic = topic;
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (messageNo >= 1 && messageNo <= 10000000) {
            String messageStr = new String(UUID.randomUUID() + "Message_" + messageNo);
            System.out.println("Send:" + messageStr);
            producer.send(new ProducerRecord<Integer, String>(topic, messageStr));
            messageNo++;
            try {
                sleep(0);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new UserKafkaProducer(KafkaProperties.topic).start();
//        Runtime run = Runtime.getRuntime();
//        long max = run.maxMemory();
//        long total = run.totalMemory();
//        long free = run.freeMemory();
//        long usable = max -total + free;
//
//        System.out.println("最大内存 = " + max);
//        System.out.println("已分配内存 = " + total);
//        System.out.println("已分配内存中的剩余空间 = " + free);
//        System.out.println("最大可用内存 = " + usable);
    }
}
