package com.rabbitmq.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yeguoxing on 2018/1/13.
 */
@Service("topicProducer")
public class TopicProcedurer implements IMessageProducer {
    private Logger logger = LoggerFactory.getLogger(DirectProducer.class);
    @Resource
    private AmqpTemplate topicTemplate;
    @Override
    public void sendMessage(Object message) {
        for(int i = 1; i <= 10; i++) {
            String str = "topic hello" + i;
            topicTemplate.send(new Message(str.getBytes(), new MessageProperties()));
        }
    }
}
