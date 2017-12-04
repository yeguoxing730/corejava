package java.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;


/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 5/18/17
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb)
    {
        long sequence = ringBuffer.next();  // Grab the next sequence
        try
        {
            LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            // for the sequence
            event.setValue(bb.getLong(0));  // Fill with data
        }
        finally
        {
            ringBuffer.publish(sequence);
        }
    }
}
