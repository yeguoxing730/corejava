package com.designmodel.create.singlton;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/24/16
 * Time: 9:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class SafeDoubleCheckLocking {
    /**
     * 使用 volatile 的原因是可见性，也就是可以保证线程在本地不会存有 instance 的副本，每次都是去主内存中读取
     * 使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化。也就是说，
     * 在 volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），
     * 读操作不会被重排序到内存屏障之前。比如上面的例子，取操作必须在执行完 1-2-3 之后
     * 或者 1-3-2 之后，不存在执行到 1-3 然后取到值的情况。从「先行发生原则」的角度理解的话，
     * 就是对于一个volatile 变量的写操作都先行发生于后面对这个变量的读操作（这里的“后面”是
     * 时间上的先后顺序）。
     * 但是特别注意在 Java 5 以前的版本使用了 volatile 的双检锁还是有问题的。其原因是 Java 5 以前的 JMM （Java 内存模型）
     * 是存在缺陷的，即时将变量声明成 volatile 也不能完全避免重排序，主要是 volatile 变量前后的代码仍然存在重排序问题。
     * 这个 volatile 屏蔽重排序的问题在 Java 5 中才得以修复，所以在这之后才可以放心使用 volatile。
     */
    private static volatile Object instance;   //避免指令重拍

    public static Object getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckLocking.class) {
                if (instance == null) {      //分配内存空间 分配内存地址 初始化实例 如果发生指令重排则对象并未初始化完成 所以加上volitale确保了不发生指令重排
                    instance = new Object();
                }
            }
        }
        return instance;
    }
}
