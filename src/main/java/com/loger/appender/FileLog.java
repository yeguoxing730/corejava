package com.loger.appender;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yeguoxing on 2018/1/16.
 */
public class FileLog {
    private static Logger debugLogger = null;
    private static Logger errorLogger = null;
    private static Logger infoLogger = null;

    private static Logger countTimeLogger=null;


    static {
        loadLogger();
    }

    public FileLog() {
        super();
    }

    /**
     * 装载系统使用的log
     */
    static void loadLogger() {
        debugLogger = LoggerFactory.getLogger("debugLogger");
        infoLogger =  LoggerFactory.getLogger("infoLogger");
        errorLogger =  LoggerFactory.getLogger("errorLogger");

        countTimeLogger =  LoggerFactory.getLogger("countTimeLogger");
    }

    //自定义的输出类型

    public static void countTimeLog(String msg) {
        countTimeLogger.info(msg.toString());
    }

    public static void countTimeLog(String msg,Exception e) {
        countTimeLogger.info(msg+"\n"+getExceptionTrace(e));
    }


    /**
     * @param msg: error级别的错误信息
     */
    public static void errorLog(String msg) {
        errorLogger.error(msg);
    }

    /**
     * @param e: error级别的异常信息
     */
    public static void errorLog(Exception e) {
        errorLogger.error(getExceptionTrace(e));
    }

    /**
     * @param e: error级别的异常信息
     * @param msg: error级别的错误信息
     */
    public static void errorLog(Exception e, String msg) {
        errorLogger.error(msg + "\n" + getExceptionTrace(e));
    }

    /**
     * @param msg: debug级别的错误信息
     */
    public static void debugLog(String msg) {
        debugLogger.debug(msg);
    }

    /**
     * @param e: debug级别的异常信息
     */
    public static void debugLog(Exception e) {
        debugLogger.debug(getExceptionTrace(e));
    }

    /**
     * @param e: debug级别的异常信息
     * @param msg: debug级别的错误信息
     */
    public static void debugLog(Exception e, String msg) {
        debugLogger.debug(msg + "\n" + getExceptionTrace(e));
    }

    /**
     * @param msg: info级别的错误信息
     */
    public static void systemLog(String msg) {
        infoLogger.info(msg);
    }

    /**
     * @param e: info级别的异常信息
     */
    public static void systemLog(Exception e) {
        infoLogger.info(getExceptionTrace(e));
    }

    /**
     * @param e: debug级别的异常信息
     * @param msg: debug级别的错误信息
     */
    public static void systemLog(Exception e, String msg) {
        infoLogger.info(msg + "\n" + getExceptionTrace(e));
    }

    /**
     * @param e: 异常信息输出
     */
    public static void exOut(Exception e) {
        String print = getExceptionTrace(e);
        errorLogger.error(print);
    }

    /**
     * @param e: debug级别的异常信息
     * @param msg: debug级别的错误信息
     */
    private static String getExceptionTrace(Exception e) {
        String print = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintWriter wrt = new PrintWriter(bout);
        e.printStackTrace(wrt);
        wrt.close();
        print = bout.toString();
        return print;
    }
}
