package com.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 11/15/17
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class CacheTest {
    @Test
    public void loadingCache() {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000).build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        System.out.println("key:" + key);
                        if ("key".equals(key)) {
                            return "key return result";
                        } else {
                            return "get-if-absent-compute";
                        }
                    }
                });
        String resultVal = null;
        try {
            resultVal = graphs.get("key");
            System.out.println(resultVal);
            resultVal = graphs.get("key");
            System.out.println(resultVal);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(resultVal);
    }

}
