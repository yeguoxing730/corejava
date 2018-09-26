package com.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * XML 解析的方式有DOM 和 SAX
 * 还有其他几种第三方类库JDOM StAX XPath DOM4j 提高效率
 */
public class DomDemo {
    private Document document;
    private String fileName;

    public void init() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createXml(String fileName) {
        //创建一个新的文档对象
        init();
        //根节点
        Element root = this.document.createElement("employees");
        //将根节点加载到文档对象中
        this.document.appendChild(root);

        //创建子元素
        Element employee = this.document.createElement("employee");
        Element name = this.document.createElement("name");

        //添加文本节点
        name.appendChild(this.document.createTextNode("qiankunshe"));

        employee.appendChild(name);
        Element age = this.document.createElement("age");
        age.appendChild(this.document.createTextNode("25"));
        employee.appendChild(age);

        //添加层级关系
        root.appendChild(employee);
        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);

            //添加xml 头信息
            transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            //输出xml流信息包装类
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
            StreamResult result = new StreamResult(pw);

            //将xml写到文件中
            transformer.transform(source, result);
            System.out.println("生成XML文件成功!");
        } catch (TransformerConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void parserXml(String fileName) throws Exception {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //将xml文件解析
            Document document = db.parse(fileName);

            //获得所有节点，递归遍历节点
            NodeList employees = document.getChildNodes();
            for (int i = 0; i < employees.getLength(); i++) {
                //取得一个节点
                Node employee = employees.item(i);


                NodeList employeeInfo = employee.getChildNodes();
                for (int j = 0; j < employeeInfo.getLength(); j++) {
                    Node node = employeeInfo.item(j);
                    NodeList employeeMeta = node.getChildNodes();
                    for (int k = 0; k < employeeMeta.getLength(); k++) {
                        System.out.println(employeeMeta.item(k).getNodeName()
                                + ":" + employeeMeta.item(k).getTextContent());
                    }
                }
            }
            System.out.println("解析完毕");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        DomDemo domDemo = new DomDemo();
        domDemo.createXml("domxml.xml");
        domDemo.parserXml("domxml.xml");
    }
}
