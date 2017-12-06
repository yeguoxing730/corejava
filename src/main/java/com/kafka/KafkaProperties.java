package com.kafka;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 11/13/17
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
public interface KafkaProperties {
    final static String zkConnect = "10.35.63.91:2181,10.35.63.91:2182,10.35.63.91:2183";
    final static String groupId="test-consumer-group";
    final static String topic ="hahatopic";
    final static String mytopic="mytopic";
    final static String kafkaServerURL = "10.35.63.91";
    final static int kafkaServerPort = 9093;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";
}
