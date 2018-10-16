package com.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class XPathExample {
    public static void main(String[] args)
            throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("books.xml");

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        //one way by compile
        //      XPathExpression expr                = xpath.compile("//book[author='Neal Stephenson']/title/text()");
//        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        //the other way
        Object result = xpath.evaluate("//book[author='Neal Stephenson']/title/text()", doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

    }

}
