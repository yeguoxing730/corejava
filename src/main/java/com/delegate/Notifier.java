package com.delegate;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/18/17
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Notifier {
    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler()
    {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler)
    {
        this.eventHandler = eventHandler;
    }

    public abstract void addListener(Object object,String methodName, Object...args);

    public abstract void notifyX();

}
