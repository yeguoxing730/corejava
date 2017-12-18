package com.delegate;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/18/17
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main (String[] args)
    {
        Notifier goodNotifier = new ConcreteNotifier();

        PlayingGameListener playingGameListener = new PlayingGameListener();

        WatchingTVListener watchingTVListener = new WatchingTVListener();

        goodNotifier.addListener(playingGameListener, "stopPlayingGame", new Date());

        goodNotifier.addListener(watchingTVListener, "stopWatchingTV", new Date());

        goodNotifier.notifyX();
    }
}
