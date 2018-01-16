package com.rabbitmq.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Created by yeguoxing on 2018/1/13.
 */
@Service("detailQueueConsumer")
public class DetailQueueConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("DetailQueueConsumer: " + new String(message.getBody()));
    }
}
