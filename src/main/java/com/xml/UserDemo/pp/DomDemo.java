package com.xml.UserDemo.pp;

import com.xml.UserDemo.pp.Header.Parameter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/23/17
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class DomDemo {
    private static Pricer pricer = new Pricer();
    public  static void main(String[] args) throws Exception{
        readXML();
    }
    public static void readXML() throws Exception{
        SAXReader reader = new SAXReader();
        File file = new File("file/pp_in.xml");
        Document document = reader.read(file);
        Element root = document.getRootElement();
        List<Element> childElements = root.elements();
        for (Element child : childElements) {
            if(child.getQName().getName().equalsIgnoreCase("Header")){
                parserHeader(child.elements());
            }  else{

            }
//            System.out.println(child.getQName());
//            System.out.println(child.element(""));
//            System.out.println(child.getQName());
            //未知属性名情况下
            /*List<Attribute> attributeList = child.attributes();
            for (Attribute attr : attributeList) {
                System.out.println(attr.getName() + ": " + attr.getValue());
            }*/

//            //已知属性名情况下
//            System.out.println("id: " + child.attributeValue("id"));
//
//            //未知子元素名情况下
//            /*List<Element> elementList = child.elements();
//            for (Element ele : elementList) {
//                System.out.println(ele.getName() + ": " + ele.getText());
//            }
//            System.out.println();*/
//
//            //已知子元素名的情况下
//            System.out.println("title" + child.elementText("title"));
//            System.out.println("author" + child.elementText("author"));
//            //这行是为了格式化美观而存在
//            System.out.println();
        }
    }
    public static void parserHeader(List<Element> elements){
        for(Element child:elements){

            if(child.getQName().getName().equalsIgnoreCase("Output")){
                System.out.println("-------2-----"+child.getQName().getName());
                List<Element> parameters  = child.elements();
                for(Element parameter:parameters){
                    Parameter parameterVar = new Parameter();
                    parameterVar.setName(parameter.attribute("name").getStringValue());
                    parameterVar.setValue(parameter.attribute("value").getStringValue());
                    pricer.getHeader().getOutput().add(parameterVar);
                }
            }else if(child.getQName().getName().equalsIgnoreCase("AsOfDate")){
                System.out.println("-------2-----"+child.getStringValue());
                pricer.getHeader().setAsOfDate(child.getStringValue());
            }
        }

    }
    public static void readXmlIterator()throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("books.xml"));
        Element root = document.getRootElement();

        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();

            //未知属性名称情况下
            /*Iterator attrIt = element.attributeIterator();
            while (attrIt.hasNext()) {
                Attribute a  = (Attribute) attrIt.next();
                System.out.println(a.getValue());
            }*/

            //已知属性名称情况下
            System.out.println("id: " + element.attributeValue("id"));

            //未知元素名情况下
            /*Iterator eleIt = element.elementIterator();
            while (eleIt.hasNext()) {
                Element e = (Element) eleIt.next();
                System.out.println(e.getName() + ": " + e.getText());
            }
            System.out.println();*/

            //已知元素名情况下
            System.out.println("title: " + element.elementText("title"));
            System.out.println("author: " + element.elementText("author"));
            System.out.println();
        }
    }
}
