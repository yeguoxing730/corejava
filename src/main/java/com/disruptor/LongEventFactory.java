package com.disruptor;
import com.lmax.disruptor.EventFactory;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 5/18/17
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance(){
        return  new LongEvent();
    }
}
