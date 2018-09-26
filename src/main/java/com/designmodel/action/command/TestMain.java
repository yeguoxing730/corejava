package com.designmodel.action.command;

public class TestMain {
    public static void main(String args[]) {
        Document doc = new Document(); //文档实体对象
        AddCommand addCmd = new AddCommand(doc); //具体命令实体对象
        UndoCommand undoCmd = new UndoCommand(doc); //具体命令实体对象
        RedoCommand redoCmd = new RedoCommand(doc); //具体命令实体对象
        Invoker invoker = new Invoker(); //调用者对象
        invoker.setCommand(addCmd);
        invoker.execute();
        invoker.setCommand(addCmd);
        invoker.execute();
        invoker.setCommand(undoCmd);
        invoker.execute();
        invoker.setCommand(redoCmd);
        invoker.execute();
    }
}
/**
 * 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤销的操作。
 * 命令模式主要应用于将行为调用者与实现者解耦。比如我们以前惯用的写代码的方式是LogicProcess logic = new LogicProcess();
 * 然后紧接着调用实现方法logic.process()，这种写法其实非常普遍，但这种写法把行为调用者和行为实现者耦合在了一起，一般情况下并
 * 没有什么问题的，但当调用逻辑比较复杂或则调用行为有多种实现时就非常不利于程序的扩展。
 * 命令模式的适用场景描述：
 * （1）整个调用过程比较繁杂，或者存在多处这种调用。使用Command类对该调用加以封装，便于功能的再利用。
 * （2）调用前后需要对调用参数进行某些处理。
 * （3）调用前后需要进行某些额外处理，比如日志，缓存，记录历史操作等。
 * <p>
 * 命令模式的使用流程就是首先创建一个抽象命令，然后创建多个具体命令实现抽象命令接口，然后创建一个命令接受者角色，它包含各种的行为的具体实现，然后再有一个命令调用者角色，提供给客户端，用于接收客户端的参数。
 * 下面总结下命令模式的优点：
 * （1）命令模式将行为调用者和各种行为分隔开，降低程序的耦合，便于程序扩展。
 * （2）命令模式将行为的具体实现封装起来，客户端无需关心行为的具体实现。
 * （3）命令模式可为多种行为提供统一的调用入口，便于程序对行为的管理和控制。
 */
