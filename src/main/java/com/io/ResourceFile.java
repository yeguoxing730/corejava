package com.io;


import com.google.common.io.Resources;

import java.nio.charset.Charset;
import java.nio.file.Paths;
/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/21/17
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceFile {
    public static   String filePath = "./file/OverrideConfiguration.xml";
    public static void main(String[] args) throws Exception{
      String result = getInputString(filePath)  ;
        System.out.println(result);
    }
    public static  String getInputString(String inputpath) throws Exception {
        String payload =  Resources.toString(Paths.get(inputpath).toUri().toURL(), Charset.defaultCharset());
        return payload;
    }
}
