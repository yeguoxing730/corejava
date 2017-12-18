package com.delegate;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/18/17
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class WatchingTVListener {
    public WatchingTVListener()
    {
        System.out.println("watching TV");
    }

    public void stopWatchingTV(Date date)
    {
        System.out.println("stop watching" + date);
    }
}
