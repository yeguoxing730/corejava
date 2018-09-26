package com.designmodel.action.expression;

public class Main {
    public static void main(String[] args) {
        //(a*b)/(a-b+15000)
        Context context = new Context();
        Variable a = new Variable();
        Variable b = new Variable();
        Constant c = new Constant(15000);

        context.addValue(a, 14);
        context.addValue(b, 10000);

        Expression expression = new Div(new Mul(a, b), new Add(new Sub(a, b), c));
        System.out.println("Result = " + expression.interpret(context));
    }
}
/**
 * 解释器模式优点：
 * 易于改变和扩展文法。
 * 每一条文法规则都可以表示为一个类，因此可以方便地实现一个简单的语言。
 * 实现文法较为容易。在抽象语法树中每一个表达式节点类的实现方式都是相似的，这些类的代码编写都不会特别复杂，
 * 还可以通过一些工具自动生成节点类代码。
 * 增加新的解释表达式较为方便。如果用户需要增加新的解释表达式只需要对应增加一个新的终结符表达式或非终结符表达式类，
 * 原有表达式类代码无须修改，符合“开闭原则”。
 * 解释器模式缺点：
 * 对于复杂文法难以维护。在解释器模式中，每一条规则至少需要定义一个类，因此如果一个语言包含太多文法规则，类的个数将会急剧增加，导致系统难以管理和维护，此时可以考虑使用语法分析程序等方式来取代解释器模式。
 * 执行效率较低。由于在解释器模式中使用了大量的循环和递归调用，因此在解释较为复杂的句子时其速度很慢，而且代码的调试过程也比较麻烦。
 */
