package com.kafka;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 11/13/17
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserKafkaTest {
    public static void main(String[] args) {
        UserKafkaProducer producerThread=new UserKafkaProducer(KafkaProperties.topic);
        producerThread.start();
        UserKafkaConsumer consumerThread=new UserKafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }
}
