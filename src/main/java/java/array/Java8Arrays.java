package java.array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/12/16
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Java8Arrays {
    public static void main(String[] args){
            Java8Arrays java8Arrays = new Java8Arrays();
        java8Arrays.createLargeArray();
    }
    public void createLargeArray() {
        Integer[] array = new Integer[1024*1024*4]; // 4M
        Arrays.parallelSetAll(
                array, i -> new Integer(new Random().nextInt()));
    }
}
