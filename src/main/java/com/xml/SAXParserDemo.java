package com.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/10/17
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class SAXParserDemo {
    public static void main(String[] args){

        try {
            File inputFile = new File("input.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
