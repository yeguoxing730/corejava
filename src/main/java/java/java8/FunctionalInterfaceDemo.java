package java.java8;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/27/16
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
@FunctionalInterface
public interface FunctionalInterfaceDemo<F,T> {
    T convert(F from);
}
