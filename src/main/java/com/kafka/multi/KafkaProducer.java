package com.kafka.multi;

import kafka.producer.Producer;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 11/24/17
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class KafkaProducer implements Runnable {
    private Producer<String, String> producer = null;

    private ProducerConfig config = null;

    @Override
    public void run() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "*****:2181,****:2181,****:2181");

//      props.put("zookeeper.connect", "localhost:2181");

        // 指定序列化处理类，默认为kafka.serializer.DefaultEncoder,即byte[]
        props.put("serializer.class", "kafka.serializer.StringEncoder");

        // 同步还是异步，默认2表同步，1表异步。异步可以提高发送吞吐量，但是也可能导致丢失未发送过去的消息
        props.put("producer.type", "sync");

        // 是否压缩，默认0表示不压缩，1表示用gzip压缩，2表示用snappy压缩。压缩后消息中会有头来指明消息压缩类型，故在消费者端消息解压是透明的无需指定。
        props.put("compression.codec", "1");

        // 指定kafka节点列表，用于获取metadata(元数据)，不必全部指定
        props.put("broker.list", "****:6667,***:6667,****:6667");

        config = new ProducerConfig(props);
    }

    public static void main(String[] args) {
        Thread t = new Thread(new KafkaProducer());
        t.start();
    }
}
