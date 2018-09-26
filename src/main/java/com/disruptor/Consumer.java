package com.disruptor;


import com.lmax.disruptor.WorkHandler;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: UC203808
 * Date: 5/18/17
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements WorkHandler<LongEvent> {
    private String consumerId;
    private static AtomicInteger count1 = new AtomicInteger(0);
    private static AtomicInteger count2 = new AtomicInteger(0);
    private static AtomicInteger count3 = new AtomicInteger(0);

    public String getConsumerId() {
        return consumerId;
    }

    public Consumer(String consumerId) {
        this.consumerId = consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }


    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {

    }

    public String getCount() {
        return "c1消费数量：" + count1.get() + ",c2消费数量：" + count2.get() + ",c3消费数量：" + count3.get();
    }

    @Override
    public void onEvent(LongEvent longEvent) throws Exception {
        System.out.println("当前消费者：" + this.consumerId + ",消费消息：" + longEvent.getValue());
        if ("c0".equals(this.consumerId)) {
            count1.incrementAndGet();
        } else if ("c1".equals(this.consumerId)) {
            count2.incrementAndGet();
        } else if ("c2".equals(this.consumerId)) {
            count3.incrementAndGet();
        }
    }
}
