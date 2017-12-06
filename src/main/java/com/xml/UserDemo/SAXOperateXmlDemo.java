package com.xml.UserDemo;

import com.xml.UserDemo.pp.Pricer;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/23/17
 * Time: 9:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class SAXOperateXmlDemo {
//    public static List<Node> nodeList = null;
//    public static Node node = null;
    public static List<User> userList = null;
    public static User user = null;
    public static Pricer pricer = null;
    public static void main(String[] args) {
        SAXOperateXmlDemo demo = new SAXOperateXmlDemo();
//        demo.parseXml04();
        demo.parseXmlForPricer();
    }
    public void parseXml04(){
        String xmlPath = "file/userDemo.xml";
        try {
            //获取SAX分析器的工厂实例，专门负责创建SAXParser分析器
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            //获取SAXParser分析器的实例
            SAXParser saxParser = saxParserFactory.newSAXParser();
            InputStream inputStream = new FileInputStream(new File(xmlPath));

            //解析xml文档
            saxParser.parse(inputStream, new UserPaserXMLHandler());

            //迭代list
            if(SAXOperateXmlDemo.userList.size() > 0){
                for (User user : SAXOperateXmlDemo.userList) {
                    System.out.println("-----------------------------------------");
                    System.out.println("【Id】" + user.getId());
                    System.out.println("【姓名】" + user.getName());
                    System.out.println("【年龄】" + user.getAge());
                    System.out.println("【爱好】" + user.getHobby());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void buildXml01(){
        try {
            //创建保存xml的结果流对象
            Result reultXml = new StreamResult(new FileOutputStream(new File("c:\\user.xml")));
            //获取sax生产工厂对象实例
            SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            //获取sax生产处理者对象实例
            TransformerHandler transformerHandle = saxTransformerFactory.newTransformerHandler();
            transformerHandle.setResult(reultXml);
            //获取sax生产器
            Transformer transformer = transformerHandle.getTransformer();
            //transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");//xml的编码格式
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");//换行
            //开始封装document文档对象，这里和解析一样都是成双成对的构造标签
            transformerHandle.startDocument();
            AttributesImpl attrImple = new AttributesImpl();
            transformerHandle.startElement("", "", "Users",attrImple);

            attrImple.addAttribute("", "", "id", "string", "123");
            transformerHandle.startElement("", "", "user", attrImple);
            transformerHandle.characters("这个是用户的信息".toCharArray(), 0, "这个是用户的信息".length());
            transformerHandle.endElement("", "", "user");

            transformerHandle.endElement("", "", "Users");
            //因为没有appendChild等等添加子元素的方法，sax提供的是构造在startElement()和endElement()区间内的标签为包含的节点的父节点
            transformerHandle.endDocument();

            System.out.println("xml文档生成成功！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    public void parseXmlForPricer(){
        String xmlPath = "file/pp_in.xml";
        try {
            //获取SAX分析器的工厂实例，专门负责创建SAXParser分析器
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            //获取SAXParser分析器的实例
            SAXParser saxParser = saxParserFactory.newSAXParser();
            InputStream inputStream = new FileInputStream(new File(xmlPath));

            //解析xml文档
            saxParser.parse(inputStream, new PricerPaserXMLHandler());
            XMLReader xmlReader =     saxParser.getXMLReader();

//            //迭代list
//            if(SAXOperateXmlDemo.userList.size() > 0){
//                for (User user : SAXOperateXmlDemo.userList) {
//                    System.out.println("-----------------------------------------");
//                    System.out.println("【Id】" + user.getId());
//                    System.out.println("【姓名】" + user.getName());
//                    System.out.println("【年龄】" + user.getAge());
//                    System.out.println("【爱好】" + user.getHobby());
//                }
//            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
