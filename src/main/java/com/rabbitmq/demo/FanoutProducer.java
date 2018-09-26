package com.rabbitmq.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yeguoxing on 2018/1/11.
 */
@Service("fanoutProducer")
public class FanoutProducer implements IMessageProducer {
    private Logger logger = LoggerFactory.getLogger(FanoutProducer.class);
    @Resource
    private AmqpTemplate fanoutTemplate;

    @Override
    public void sendMessage(Object message) {
        System.out.println("fanout producer");
        for (int i = 1; i <= 10; i++) {
            String str = "fanout ....hello" + i;
            fanoutTemplate.send("leo.pay.fanout.exchange", "", new Message(str.getBytes(), new MessageProperties()));
        }
    }
}
