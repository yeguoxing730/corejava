package com.designmodel.singlton;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/24/16
 * Time: 9:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class SafeDoubleCheckLocking {
    private static volatile Object instance;   //避免指令重拍
    public  static Object getInstance(){
        if(instance == null){
                  synchronized (SafeDoubleCheckLocking.class){
                      if(instance == null){      //分配内存空间 分配内存地址 初始化实例 如果发生指令重排则对象并未初始化完成 所以加上volitale确保了不发生指令重排
                            instance = new Object();
                      }
                  }
        }
        return  instance;
    }
}
