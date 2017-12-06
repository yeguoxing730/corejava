package com.disruptor;

import com.lmax.disruptor.ExceptionHandler;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 5/18/17
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntEventExceptionHandler implements ExceptionHandler {
    @Override
    public void handleEventException(Throwable throwable, long l, Object o) {
        System.out.println("handle event exception");
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleOnStartException(Throwable throwable) {
        System.out.println("handle event exception for on start");
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {
        System.out.println("handle event exception for on shutdown");
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
