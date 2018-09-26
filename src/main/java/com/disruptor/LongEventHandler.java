package com.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 5/18/17
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
