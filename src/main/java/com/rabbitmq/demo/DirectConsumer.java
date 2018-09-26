package com.rabbitmq.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Created by yeguoxing on 2018/1/11.
 */
@Service("directConsumer")
public class DirectConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(DirectConsumer.class);

    @Override
    public void onMessage(Message message) {
        System.out.println("消费者处理消息====" + "receive message --" + message);
    }
}
