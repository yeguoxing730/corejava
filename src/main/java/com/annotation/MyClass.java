package com.annotation;

import com.annotation.types.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/25/17
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
@ClassAnnotation(name = "myname",value = "class annotation")
public class MyClass {
    @FieldAnnotation(name="field",value="fieldVal")
    public static String fieldVal;
    @MethodAnnotation(name="method",value = "method value")
    public  String getMethodVal(String fieldVal){
        return fieldVal;
    }
    public  String getFieldVal(@ParametersAnnotation(name = "parameter" ,value = "parameter value") String parameterVal){
        return   parameterVal;
    }
    public String getLocalParameterVal(){
        @LocalAreaAnnotation(name="local",value = "loacal varaiable value")
        String name = "heihie local";
        return name;
    }
    public static void main(String[] args) throws  Exception{
        //通过反射获得MyClass的注解信息
        ClassAnnotation myAnnotation = MyClass.class.getAnnotation(ClassAnnotation.class);
        System.out.println(myAnnotation.name());
        System.out.println(myAnnotation.value());
        //获取方法的注解信息
        MethodAnnotation annotation = MyClass.class.getMethod("getMethodVal",String.class).getAnnotation(MethodAnnotation.class);
        System.out.println(annotation.name());
        System.out.println(annotation.value());
        //  获取字段的注解信息
        FieldAnnotation fieldAnnotation = MyClass.class.getField("fieldVal").getAnnotation(FieldAnnotation.class);
        System.out.println(fieldAnnotation.name());
        System.out.println(fieldAnnotation.value());
        //  获取参数的注解信息
        Method method=     MyClass.class.getMethod("getFieldVal",String.class);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class[] parameterTypes = method.getParameterTypes();
        int i=0;
        for(Annotation[] annotations : parameterAnnotations){
            Class parameterType = parameterTypes[i++];
            for(Annotation paramAno : annotations){
                if(paramAno instanceof ParametersAnnotation){
                    ParametersAnnotation parametersAnnotation = (ParametersAnnotation) paramAno;
                    System.out.println("param: " + parameterType.getName());
                    System.out.println("name : " + parametersAnnotation.name());
                    System.out.println("value: " + parametersAnnotation.value());
                }
            }
        }
    }
}
