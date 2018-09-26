package com.thread.forkjoin;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Calculate extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    private int[] arr;
    private int start;
    private int end;
    private static final int THRESHOLD = 100;//门限

    public Calculate(int[] arr) {
        this.arr = arr;
        this.start = 0;
        this.end = arr.length - 1;

    }

    public Calculate(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int interval = end - start;
        int sum = 0;
        if (interval < THRESHOLD) {
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }
        } else {
            //任务过大，需要继续分割
            int mid = start + (end - start) / 2;
            Calculate leftCalculate = new Calculate(arr, start, mid);
            Calculate rightCalculate = new Calculate(arr, mid + 1, end);
            //执行子任务
            leftCalculate.fork();
            rightCalculate.fork();
            //等待子任务执行结束，并得到子任务的结果
            int leftResult = leftCalculate.join();
            int rightResult = rightCalculate.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        int len = 1000;
        int[] arr = new int[len];
        Random r = new Random(47);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = r.nextInt(len);
            sum += arr[i];
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Calculate c = new Calculate(arr);
        Future<Integer> future = forkJoinPool.submit(c);


        try {
            //          forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
            int res = future.get();
            System.out.println("是否相等:" + (res == sum));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
