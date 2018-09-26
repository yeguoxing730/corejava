package com.cache;

import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 11/15/17
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */

public class CacheComputed {
    public static void main(String[] args) throws InterruptedException {
        // whenCacheMiss_thenValueIsComputed()  ;
    }

    @Test
    public void whenCacheMiss_thenValueIsComputed() throws InterruptedException {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            // 当guava cache中不存在，则会调用load方法
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder
                .newBuilder()
                // 写数据1s后重新加载缓存
                .refreshAfterWrite(1L, TimeUnit.SECONDS)
                .build(loader);
        assertEquals(0, cache.size());
        cache.put("test", "test");
        System.out.println(cache.getUnchecked("test"));
        System.out.println(cache.getUnchecked("hello"));
        System.out.println(cache.size());
        System.out.println(cache.getUnchecked("test"));
        assertEquals("test", cache.getUnchecked("test"));
        assertEquals("HELLO", cache.getUnchecked("hello"));
        assertEquals(2, cache.size());
        TimeUnit.SECONDS.sleep(2);
        assertEquals("TEST", cache.getUnchecked("test"));
    }

    @Test
    public void whenCacheReachMaxSize_thenEviction() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder().maximumSize(3).build(loader);
        System.out.println(cache.getUnchecked("first"));
        System.out.println(cache.getUnchecked("second"));
        System.out.println(cache.getUnchecked("third"));
        System.out.println(cache.getUnchecked("forth"));
        System.out.println(cache.size());
        System.out.println(cache.getIfPresent("first"));
        System.out.println(cache.getIfPresent("forth"));
        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("FORTH", cache.getIfPresent("forth"));
    }

    @Test
    public void whenCacheReachMaxWeight_thenEviction() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };
        Weigher<String, String> weighByLength;
        weighByLength = new Weigher<String, String>() {
            @Override
            public int weigh(String key, String value) {
                return value.length();
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumWeight(16)
                .weigher(weighByLength)
                .build(loader);
        System.out.println(cache.getUnchecked("first"));
        System.out.println(cache.getUnchecked("second"));
        System.out.println(cache.getUnchecked("third"));
        System.out.println(cache.getUnchecked("last"));
        System.out.println(cache.size());
        System.out.println(cache.getIfPresent("first"));
        System.out.println(cache.getIfPresent("last"));
        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("LAST", cache.getIfPresent("last"));
    }

    @Test
    public void whenEntryIdle_thenEviction() throws InterruptedException {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .expireAfterAccess(2, TimeUnit.MILLISECONDS)
                .build(loader);
        System.out.println(cache.getUnchecked("hello"));
        System.out.println(cache.size());
        assertEquals(1, cache.size());
        System.out.println(cache.getUnchecked("hello"));
        Thread.sleep(300);
        System.out.println(cache.getUnchecked("test"));
        System.out.println(cache.size());
        System.out.println(cache.getIfPresent("hello"));
        assertEquals(1, cache.size());
        assertNull(cache.getIfPresent("hello"));
    }

    @Test
    public void whenEntryRemovedFromCache_thenNotify() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(final String key) {
                return key.toUpperCase();
            }
        };
        RemovalListener<String, String> listener;
        listener = new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> n) {
                if (n.wasEvicted()) {
                    String cause = n.getCause().name();
                    System.out.println("cause===" + cause);
                    assertEquals(RemovalCause.SIZE.toString(), cause);
                }
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build(loader);
        System.out.println(cache.getUnchecked("first"));
        System.out.println(cache.getUnchecked("second"));
        System.out.println(cache.getUnchecked("third"));
        System.out.println(cache.getUnchecked("last"));
        System.out.println(cache.size());
        assertEquals(3, cache.size());
    }

    @Test
    public void cache_reLoad() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }

            /**
             * 重写reload方法可以定制自己的reload策略
             * @param key
             * @param oldValue
             * @return
             * @throws Exception
             */
            @Override
            public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                return super.reload(key, oldValue);
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .build(loader);
    }
}
