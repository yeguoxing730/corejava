package java.thread.procedureconsumer;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 10/19/17
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Storage {
    public void produce(int num);
    public void consume(int num);
    public int getMAX_SIZE();
}
