package java.java8;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/27/16
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DefaultFormulaInterface {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
