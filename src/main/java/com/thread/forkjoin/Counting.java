package com.thread.forkjoin;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Counting {
    public  static void main(String[] args){
//        int[] arrs = new int[399999];
//        Long start = System.currentTimeMillis();
//        System.out.println(arrs.length+"--"+start);
//        Arrays.stream(arrs).forEach(x->System.out.println(x));
//        System.out.println(System.currentTimeMillis()-start);
        System.out.println(Integer.toBinaryString(16));
        int mask = 1 << 16;
        System.out.println(Integer.toBinaryString(mask-1));
        System.out.println(Integer.toBinaryString(3>>>mask));
    }
}
