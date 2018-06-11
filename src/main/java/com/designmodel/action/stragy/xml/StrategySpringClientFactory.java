package com.designmodel.action.stragy.xml;

import com.designmodel.action.stragy.xml.factory.ContextSpringFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StrategySpringClientFactory {
    public static void main(String[] args) {
        //外部参数
        String type = "writeStg";
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-stragy.xml");
        ContextSpringFactory ctf = (ContextSpringFactory) context.getBean("ctf");
        ctf.doAction(type);
        type = "printStg";
        ctf.doAction(type);
    }
}
