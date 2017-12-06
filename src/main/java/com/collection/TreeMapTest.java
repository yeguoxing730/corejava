package com.collection;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 11/30/17
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, Float> map = new TreeMap<String, Float>();
        map.put("B", 88.0f);
        map.put("C", 95.0f);
        map.put("A", 90.0f);
        System.out.println(map);
    }
}
