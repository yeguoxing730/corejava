package com.designmodel.action.statue;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateWating());
        context.request("1");
        context.setState(new ConcreteStateLoading());
        context.request("2");
        context.setState(new ConcreteStateFinish());
        context.request("3");
        context.setState(new ConcreteStateError());
        context.request("e");
    }
}
/**
 * 策略模式是根据不同的策略设置一种算法 不会变化 新增策略 只需更改默认配置策略即可
 * 而状态模式是根据对象状态的变化 使用不同的算法 新增状态需要更改算法切换的逻辑
 * * 状态模式将各个状态所对应的操作分离开来，即对于不同的状态，由不同的子类实现具体操作，
 * * 不同状态的切换由子类实现，当发现传入参数不是自己这个状态所对应的参数，则自己给Context类切换状态；
 * * 而策略模式是直接依赖注入到Context类的参数进行选择策略，不存在切换状态的操作。
 * *
 * *状态模式缺点：
 * * 状态模式的使用必然会增加系统中类和对象的个数，导致系统运行开销增大。
 * * 状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码的混乱，增加系统设计的难度。
 * * 状态模式对“开闭原则”的支持并不太好，增加新的状态类需要修改那些负责状态转换的源代码，
 * * 否则无法转换到新增状态；而且修改某个状态类的行为也需修改对应类的源代码。
 */
