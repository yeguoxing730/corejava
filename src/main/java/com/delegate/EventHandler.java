package com.delegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/18/17
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventHandler {
    private List<Event> objects;

    public EventHandler()
    {
        objects = new ArrayList<Event>();
    }

    public void addEvent(Object object, String methodName, Object...args)
    {
        objects.add(new Event(object, methodName, args));
    }

    public void notifyX() throws Exception
    {
        for (Event event : objects)
        {
            event.invoke();
        }
    }
}
