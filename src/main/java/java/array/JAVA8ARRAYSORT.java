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
 * Time: 10:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class JAVA8ARRAYSORT {
    public static void main(String[] args) {
        JAVA8ARRAYSORT mySort = new JAVA8ARRAYSORT();

        int[] src = null;

        System.out.println("\nSerial sort:");
        src = mySort.getData();
        mySort.sortIt(src, false);

        System.out.println("\nParallel sort:");
        src = mySort.getData();
        mySort.sortIt(src, true);
    }

    public void sortIt(int[] src, boolean parallel) {
        try {
            System.out.println("--Array size: " + src.length);

            long start = System.currentTimeMillis();
            if ( parallel == true ) {
                Arrays.parallelSort(src);
            }
            else {
                Arrays.sort(src);
            }
            long end = System.currentTimeMillis();

            System.out.println(
                    "--Elapsed sort time: " + (end-start));
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private int[] getData() {
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
