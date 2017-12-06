package com.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 11/30/17
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedHashMapTest {
    public static void main(String[] args){
        //linked hashmap     保证了存储的顺序                    遍历时
        /**先进先出
         *
         */
        Map<String, Integer> lmap = new LinkedHashMap<String, Integer>();
        lmap.put("语文", 1);
        lmap.put("数学", 2);
        lmap.put("英语", 3);
        lmap.put("历史", 4);
        lmap.put("化学", 5);
        lmap.put("政治", 5);
        lmap.put("地理", 6);
        lmap.put("生物", 7);
        lmap.put("化学", 8);
        for(Map.Entry<String, Integer> entry : lmap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
