package java.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 11/29/17
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rece {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.35.63.149");
        factory.setPort(AMQP.PROTOCOL.PORT);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
