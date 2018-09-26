package rabbitmq;

import com.rabbitmq.demo.DirectProducer;
import com.rabbitmq.demo.FanoutProducer;
import com.rabbitmq.demo.TopicProcedurer;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @year 2017
 * @project che168Tasker
 * @description:<p></p>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class RabbitMqTest {
    @Autowired
    private DirectProducer directProducer;
    @Autowired
    private FanoutProducer fanoutProducer;
    @Autowired
    private TopicProcedurer topicProcedurer;

    @Test
    public void testDirectConsumer() throws IOException, SolrServerException {
        directProducer.sendMessage("direct message.....");
    }

    @Test
    public void testTopicConsumer() throws IOException, SolrServerException {
        topicProcedurer.sendMessage("topic message.....");
    }

    @Test
    public void testFanoutConsumer() throws IOException, SolrServerException {
        fanoutProducer.sendMessage("fanout message.....");
    }

}
