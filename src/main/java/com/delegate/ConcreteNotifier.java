package com.delegate;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/18/17
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConcreteNotifier extends Notifier {

    @Override
    public void addListener(Object object, String methodName, Object... args) {
        this.getEventHandler().addEvent(object, methodName, args);
    }

    @Override
    public void notifyX() {
        try {
            this.getEventHandler().notifyX();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
