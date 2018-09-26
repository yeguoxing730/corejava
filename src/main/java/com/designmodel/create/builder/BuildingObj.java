package com.designmodel.create.builder;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * 适合构造器参数太多的情况 不想写太多的重载构造方法
 * 可以采用构建器来构建自己 参数通过构造器传入到构造对象内部
 */
public class BuildingObj {
    private static String Name = null;
    private static int age = 0;


    public static class Builder {
        private String Name;
        private int age;

        public String getName() {
            return Name;
        }

        public Builder setName(String name) {
            Name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public BuildingObj build() {
            return new BuildingObj(this);
        }
    }

    private BuildingObj(Builder builder) {
        this.Name = builder.getName();
        this.age = builder.getAge();
    }

    public void sayHello() {
        System.out.println(Name + " say hello.....");
    }

    public static void main(String[] args) {
        BuildingObj buildingObj = new Builder().setName("HH").setAge(19).build();
        buildingObj.sayHello();
    }
}
