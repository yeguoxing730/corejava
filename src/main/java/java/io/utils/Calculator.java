package java.io.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/17/17
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public final  class Calculator {
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }
}
