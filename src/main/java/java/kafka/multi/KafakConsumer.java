package java.kafka.multi;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 11/24/17
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class KafakConsumer implements Runnable {
    private ConsumerConfig consumerConfig;
    private static String topic="blog";
    Properties props;
    final int a_numThreads = 6;

    public KafakConsumer() {
        props = new Properties();
        props.put("zookeeper.connect", "10.35.63.91:2181,10.35.63.91:2182,10.35.63.91:2183");
//      props.put("zookeeper.connect", "localhost:2181");
//        props.put("zookeeper.connectiontimeout.ms", "30000");
        props.put("group.id", "blog");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");
        consumerConfig = new ConsumerConfig(props);
    }
    @Override
    public void run() {

        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(a_numThreads));
        ConsumerConfig consumerConfig = new ConsumerConfig(props);
        ConsumerConnector consumer = kafka.consumer.Consumer.createJavaConsumerConnector(consumerConfig);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
        ExecutorService executor = Executors.newFixedThreadPool(a_numThreads);
        for (final KafkaStream stream : streams) {
            executor.submit(new KafkaConsumerThread(stream));
        }
    }
}
