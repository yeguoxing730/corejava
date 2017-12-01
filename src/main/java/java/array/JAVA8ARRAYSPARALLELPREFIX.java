package java.array;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/12/16
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * 并行加法
 */
public class JAVA8ARRAYSPARALLELPREFIX {
    public static void main(String[] args){
        int[] src = null;
        IntBinaryOperator op = new MyIntOperator();
        System.out.println("\nParallel prefix:");
        JAVA8ARRAYSPARALLELPREFIX fx = new JAVA8ARRAYSPARALLELPREFIX();
        src = fx.getData();

        long start = System.currentTimeMillis();

        Arrays.parallelPrefix(src, new MyIntOperator());

        long end = System.currentTimeMillis();
        System.out.println("--Elapsed sort time: " + (end-start));
    }
    public  int[] getData() {
        try {
            File file = new File("src/parallelsort/myimage.jpg");
            BufferedImage image = ImageIO.read(file);
            int w = image.getWidth();
            int h = image.getHeight();
            int[] src = image.getRGB(0, 0, w, h, null, 0, w);
            int[] data = new int[src.length * 20];
            for ( int i = 0; i < 20; i++ ) {
                System.arraycopy(
                        src, 0, data, i*src.length, src.length);
            }
            return data;
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }
}
class MyIntOperator implements IntBinaryOperator {
    @Override
    public int applyAsInt(int left, int right) {
        return left+right;
    }
}
