package com.designmodel.create.singlton;

public class PrivateClassMethod {
    private static class ObjectHolder{
        private static final Object obj = new Object();
        public static Object getObj(){
            return obj;
        }
    }
    public  static Object getInstance(){
        return ObjectHolder.getObj();
    }
}
