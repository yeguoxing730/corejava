package com.thread.webcrawler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

public class WebCrawlerForkJoin implements LinkHandler {

    private final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());
    //    private final Collection<String> visitedLinks = Collections.synchronizedList(new ArrayList<>());
    private String url;
    private ForkJoinPool mainPool;

    public WebCrawlerForkJoin(String startingURL, int maxThreads) {
        this.url = startingURL;
        mainPool = new ForkJoinPool(maxThreads);
    }

    private void startCrawling() {
        startNewThread(this.url);
    }

    @Override
    public void queueLink(String link) throws Exception {
        startNewThread(link);
    }

    private void startNewThread(String link) {
        mainPool.invoke(new LinkFinderAction(link, this));
    }

    @Override
    public int size() {
        return visitedLinks.size();
    }

    @Override
    public void addVisited(String s) {
        visitedLinks.add(s);
    }

    @Override
    public boolean visited(String s) {
        return visitedLinks.contains(s);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        new WebCrawlerForkJoin("http://www.baidu.com", 64).startCrawling();
    }
}
