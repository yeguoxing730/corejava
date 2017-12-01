package java.oracleaq;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/21/17
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
import oracle.jms.AQjmsAdtMessage;
import oracle.jms.AQjmsDestination;
import oracle.jms.AQjmsFactory;
import oracle.jms.AQjmsSession;

import javax.jms.*;
import java.util.Properties;
public class Main {
    public static void main(String[] args) throws Exception {
        JmsConfig config = new JmsConfig();

        QueueConnectionFactory queueConnectionFactory = AQjmsFactory.getQueueConnectionFactory(config.jdbcUrl,
                new Properties());

        QueueConnection conn = queueConnectionFactory.createQueueConnection(config.username, config.password);
        AQjmsSession session = (AQjmsSession) conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        conn.start();

        Queue queue = (AQjmsDestination) session.getQueue(config.username, config.queueName);
        MessageConsumer consumer = session.createConsumer(queue, null, QUEUE_MESSAGE_TYPE.getFactory(), null, false);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println("Get question...");
                AQjmsAdtMessage adtMessage = (AQjmsAdtMessage) message;
                try {
                    QUEUE_MESSAGE_TYPE payload = (QUEUE_MESSAGE_TYPE) adtMessage.getAdtPayload();
                    System.out.println(payload.getContent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread.sleep(1000000);
    }
}
