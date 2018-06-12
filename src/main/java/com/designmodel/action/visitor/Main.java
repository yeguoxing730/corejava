package com.designmodel.action.visitor;

public class Main {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ConcreteElementNodeA());
        objectStructure.add(new ConcreteElementNodeB());

        Vistor vistor = new ConcreteVisitorA();
        objectStructure.action(vistor);
    }
}
/**
 * 访问者模式优点：
 *
 * 增加新的访问操作很方便。使用访问者模式，增加新的访问操作就意味着增加一个新的具体访问者类，实现简单，无须修改源代码，符合“开闭原则”。 *
 * 将有关元素对象的访问行为集中到一个访问者对象中，而不是分散在一个个的元素类中。类的职责更加清晰，有利于对象结构中元素
 * 对象的复用， 相同的对象结构可以供多个不同的访问者访问。
 * 让用户能够在不修改现有元素类层次结构的情况下，定义作用于该层次结构的操作。
 *
 * 访问者模式缺点： *
 * 增加新的元素类很困难。在访问者模式中，每增加一个新的元素类都意味着要在抽象访问者角色中增加一个新的抽象操作，
 * 并在每一个具体访问者类中增加相应的具体操作，这违背了“开闭原则”的要求。 *
 * 破坏封装。访问者模式要求访问者对象访问并调用每一个元素对象的操作，这意味着元素对象有时候必须暴露一些自己的内部操作
 * 和内部状态，否则无法供访问者访问。
 */
/**
 * 访问者模式的优点
 *
 * 符合单一职责原则：凡是适用访问者模式的场景中，元素类中需要封装在访问者中的操作必定是与元素类本身关系不大且是易变的操作，
 * 使用访问者模式一方面符合单一职责原则，另一方面，因为被封装的操作通常来说都是易变的，所以当发生变化时，就可以在不改变元素类本身的前提下，
 * 实现对变化部分的扩展。
 * 扩展性良好：元素类可以通过接受不同的访问者来实现对不同操作的扩展。
 *  访问者模式的适用场景
 *
 *        假如一个对象中存在着一些与本对象不相干（或者关系较弱）的操作，为了避免这些操作污染这个对象，则可以使用访问者模式来把这些操作封
 *        装到访问者中去。 假如一组对象中，存在着相似的操作，为了避免出现大量重复的代码，也可以将这些重复的操作封装到访问者中去。
 *        但是，访问者模式并不是那么完美，它也有着致命的缺陷：增加新的元素类比较困难。通过访问者模式的代码可以看到，在访问者类中，
 *        每一个元素类都有它对应的处理方法，也就是说，每增加一个元素类都需要修改访问者类（也包括访问者类的子类或者实现类），修改起来相当麻烦。
 *        也就是说，在元素类数目不确定的情况下，应该慎用访问者模式。所以，访问者模式比较适用于对已有功能的重构，比如说，一个项目的基本功能已经
 *        确定下来，元素类的数据已经基本确定下来不会变了，会变的只是这些元素内的相关操作，这时候，我们可以使用访问者模式对原有的代码进行重构一遍，
 *        这样一来，就可以在不修改各个元素类的情况下，对原有功能进行修改。
 *
 *
 */
