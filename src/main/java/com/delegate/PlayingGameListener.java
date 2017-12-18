package com.delegate;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/18/17
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayingGameListener {
    public PlayingGameListener()
    {
        System.out.println("playing");
    }

    public void stopPlayingGame(Date date)
    {
        System.out.println("stop playing" + date);
    }
}
