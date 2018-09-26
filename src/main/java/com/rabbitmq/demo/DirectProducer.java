package com.rabbitmq.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yeguoxing on 2018/1/11.
 */
@Service("directProducer")
public class DirectProducer implements IMessageProducer {
    private Logger logger = LoggerFactory.getLogger(DirectProducer.class);
    @Resource
    private AmqpTemplate directTemplate;

    @Override
    public void sendMessage(Object message) {
        logger.info("发送消息");
        logger.info("to send message:", "direct----" + message);
        directTemplate.convertAndSend("queueTestKey", message);
    }
}
