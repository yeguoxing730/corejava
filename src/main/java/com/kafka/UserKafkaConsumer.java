package com.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 11/13/17
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserKafkaConsumer extends Thread{
    private final ConsumerConnector consumer;
    private final String topic;
    public UserKafkaConsumer(String topic){
        consumer=kafka.consumer.Consumer.createJavaConsumerConnector(
                createConsumerConfig());
        this.topic=topic;
    }
    private ConsumerConfig createConsumerConfig() {
        Properties props=new Properties();
        props.put("zookeeper.connect",KafkaProperties.zkConnect);
        props.put("group.id","test-consumer-group"+1);
        props.put("zookeeper.session.timeout.ms","40000");
        props.put("zookeeper.sync.time.ms","200");
        props.put("auto.commit.interval.ms","1000");
        return new ConsumerConfig(props);
    }
    @Override
    public void run() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);

        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()) {
            System.out.println("receive：" + new String(it.next().message()));
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new UserKafkaConsumer(KafkaProperties.topic).start();
    }
}
