package com.jvm;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.*;
import java.util.ArrayList;
import java.util.List;

public class JVMSummaryInfo {
    /**
     * Java 虚拟机在其上运行的操作系统
     */
    public static  String getOperationMemoryInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("=======================OperatingSystemMXBean============================ ").append("\n");
        OperatingSystemMXBean osm = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        stringBuilder.append("物理内存大小: "+osm.getTotalPhysicalMemorySize()/1024/1024+"M").append("\n");
        stringBuilder.append("空闲物理内存大小:"+osm.getFreePhysicalMemorySize()/1024/1024+"M").append("\n");
        stringBuilder.append("已使用物理内存大小:"+(osm.getTotalPhysicalMemorySize() - osm.getFreePhysicalMemorySize())/1024/1024+"M").append("\n");
        stringBuilder.append("swap分区大小(总的物理内存+虚拟内存) :"+osm.getTotalSwapSpaceSize()/1024/1024+"M").append("\n");
        stringBuilder.append("CommittedVirtualMemorySize:"+osm.getCommittedVirtualMemorySize()).append("\n");
        stringBuilder.append("ProcessCpuLoad :"+osm.getProcessCpuLoad()).append("\n");
        stringBuilder.append("ProcessCpuTime :"+osm.getProcessCpuTime()).append("\n");
        stringBuilder.append("SystemCpuLoad :"+osm.getSystemCpuLoad()).append("\n");
        stringBuilder.append("SystemLoadAverage :"+osm.getSystemLoadAverage()).append("\n");
        Double compare = (Double) (1 - osm.getFreePhysicalMemorySize() * 1.0
                / osm.getTotalSwapSpaceSize()) * 100;
        Double compare2 = (Double) (1 - osm.getFreePhysicalMemorySize() * 1.0
                / osm.getTotalPhysicalMemorySize()) * 100;
        stringBuilder.append("内存使用率(空闲/swap分区) :"+compare.doubleValue()).append("\n");
        stringBuilder.append("内存使用率(空闲/物理内存大小) :"+compare2.doubleValue()).append("\n");
        return stringBuilder.toString();
    }
    /**
     * Java 虚拟机的运行时系统
     */
    public static String showJvmInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        RuntimeMXBean mxbean = ManagementFactory.getRuntimeMXBean();
        String vendor = mxbean.getVmVendor();
        stringBuilder.append("jvm name:" + mxbean.getVmName()).append("\n");
        stringBuilder.append("jvm version:" + mxbean.getVmVersion()).append("\n");
        stringBuilder.append("jvm bootClassPath:" + mxbean.getBootClassPath()).append("\n");
        stringBuilder.append("jvm start time:" + mxbean.getStartTime()).append("\n");
        stringBuilder.append("jvm start time:" + vendor).append("\n");
        return stringBuilder.toString();
    }

    /**
     * Java 虚拟机的内存系统
     */
    public static  String getJVMMemoryInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        MemoryMXBean memorymbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memorymbean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage =  memorymbean.getNonHeapMemoryUsage();
        stringBuilder.append("初始化Heap大小: " + heapMemoryUsage.getInit()/1024/1024+"M").append("\n");
        stringBuilder.append("最大Heap大小: " + heapMemoryUsage.getMax()/1024/1024+"M").append("\n");
        stringBuilder.append("已使用Heap大小: " + heapMemoryUsage.getUsed()/1024/1024+"M").append("\n");
        stringBuilder.append("初始化非Heap大小: " + nonHeapMemoryUsage.getInit()/1024/1024+"M").append("\n");
        stringBuilder.append("最大非Heap大小: " + nonHeapMemoryUsage.getMax()/1024/1024+"M").append("\n");
        stringBuilder.append("已使用非Heap大小: " + nonHeapMemoryUsage.getUsed()/1024/1024+"M").append("\n");

        stringBuilder.append("Full Information:").append("\n");
        stringBuilder.append("Heap Memory Usage: "
                + memorymbean.getHeapMemoryUsage()).append("\n");
        stringBuilder.append("Non-Heap Memory Usage: "
                + memorymbean.getNonHeapMemoryUsage()).append("\n");
        Runtime r = Runtime.getRuntime();
        stringBuilder.append("Runtime获取的JVM总内存:    " + r.totalMemory()/1024/1024+"M").append("\n");
        stringBuilder.append("Runtime获取的JVM可以使用的剩余内存:   " + r.freeMemory()/1024/1024+"M").append("\n");
        stringBuilder.append("Runtime获取的JVM可以使用的处理器个数:  " + r.availableProcessors()).append("\n");

        return stringBuilder.toString();
    }
    /**
     * Java 虚拟机的类加载系统
     */
    public static String getClassLoadingInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        ClassLoadingMXBean cl = ManagementFactory.getClassLoadingMXBean();
        stringBuilder.append("TotalLoadedClassCount: " + cl.getTotalLoadedClassCount()).append("\n");
        stringBuilder.append("LoadedClassCount" + cl.getLoadedClassCount()).append("\n");
        stringBuilder.append("UnloadedClassCount:" + cl.getUnloadedClassCount()).append("\n");
        return stringBuilder.toString();
    }
    /**
     * Java 虚拟机的编译系统
     */
    public static String showCompilation() {
        StringBuilder stringBuilder = new StringBuilder();
        CompilationMXBean com = ManagementFactory.getCompilationMXBean();
        stringBuilder.append("TotalCompilationTime:" + com.getTotalCompilationTime()).append("\n");
        stringBuilder.append("name:" + com.getName()).append("\n");
        return stringBuilder.toString();
    }

    /**
     * Java 虚拟机中的垃圾回收器。
     */
    public static void showGarbageCollector() {
        List<GarbageCollectorMXBean> gc = ManagementFactory.getGarbageCollectorMXBeans();
        System.out.println("-----------------garbagecollectiors----------------");
        for (GarbageCollectorMXBean GarbageCollectorMXBean : gc) {

            System.out.println("name:" + GarbageCollectorMXBean.getName());
            System.out.println("CollectionCount:" + GarbageCollectorMXBean.getCollectionCount());
            System.out.println("CollectionTime" + GarbageCollectorMXBean.getCollectionTime());
            String[] poolnames = GarbageCollectorMXBean.getMemoryPoolNames();
            for (String poolname : poolnames) {
                System.out.print("poolname------"+poolname);
            }
        }
    }

    /**
     * Java 虚拟机中的内存池
     */
    public static void showMemoryPool() {
        StringBuilder stringBuilder = new StringBuilder();
        List<MemoryPoolMXBean> mps = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean mp : mps) {
            stringBuilder.append("------------" + mp.getName()+"------------").append("\n");
            MemoryUsage memoryUsage = mp.getUsage();
            if(memoryUsage!=null){
                stringBuilder.append("初始化Collection大小: " + memoryUsage.getInit()/1024/1024+"M").append("\n");
                stringBuilder.append("最大Collection大小: " + memoryUsage.getMax()/1024/1024+"M").append("\n");
                stringBuilder.append("已使用Collection大小: " + memoryUsage.getUsed()/1024/1024+"M").append("\n");
            }
            stringBuilder.append("type:" + mp.getType()).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * Java 虚拟机的线程系统
     */
    public static void showThread() {
        ThreadMXBean thread = ManagementFactory.getThreadMXBean();
        System.out.println("ThreadCount:" + thread.getThreadCount());
        long threadIds[] = thread.getAllThreadIds();
        List<Long> threadIdList = new ArrayList<Long>();
        for(long threadId : threadIds){
            threadIdList.add(threadId);
        }
        System.out.println("AllThreadIds:" + threadIds);
        System.out.println("CurrentThreadUserTime:" + thread.getCurrentThreadUserTime());
        System.out.println("TotalStartedThreadCount:" + thread.getTotalStartedThreadCount());
        ThreadInfo infos[] = thread.getThreadInfo(thread.getAllThreadIds(), 30);
        for(ThreadInfo info : infos){
            System.out.println("----------"+info.getThreadName()+"--------------------");
            System.out.println("ThreadId:"+info.getThreadId());
            System.out.println("ThreadName:"+info.getThreadName());
            System.out.println("LockName:"+info.getLockName());
            System.out.println("LockOwnerName:"+info.getLockOwnerName());
            System.out.println("ThreadState:"+info.getThreadState());
            System.out.println("BlockedCount:"+info.getBlockedCount());
            System.out.println("BlockedTime:"+info.getBlockedTime());
            System.out.println("LockOwnerId:"+info.getLockOwnerId());
            LockInfo lockInfo = info.getLockInfo();
            if(lockInfo!=null){
                System.out.println("lockClassName:"+lockInfo.getClassName());
            }
           LockInfo[] lockInfos = info.getLockedSynchronizers();
            for (LockInfo lockInfo1 : lockInfos) {
                System.out.println("LockedSynchronizers--lockClassName:"+lockInfo.getClassName());
            }

            System.out.println("-------StackTraceElements----");
            for(StackTraceElement stk : info.getStackTrace()){
                System.out.println("class:"+stk.getClassName());
                System.out.println("file:"+stk.getFileName());
                System.out.println("method:"+stk.getMethodName());
                System.out.println("line:"+stk.getLineNumber());
            }
            System.out.println("-------LockedMonitors----");
            MonitorInfo[] monitorInfos = info.getLockedMonitors();
            for (MonitorInfo monitorInfo : monitorInfos) {
                System.out.println("ClassName:"+monitorInfo.getClassName());
                System.out.println("IdentityHashCode:"+monitorInfo.getIdentityHashCode());
                System.out.println("LockedStackDepth:"+monitorInfo.getLockedStackDepth());
            }
        }
        //......还有其他很多信息
    }


    public static void main(String[] args){
       // System.out.println(showJvmInfo());
        //System.out.println(showCompilation());
//        showGarbageCollector();
//        showMemoryPool();
       // System.out.println(getClassLoadingInfo());
        showThread();
    }
}
