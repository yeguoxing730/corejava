package com.xml.rt;

import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class XPathFactoryExample {
    public void xPathProcessor() throws SAXException, IOException, XPathExpressionException, ParserConfigurationException,Exception {
        // Create DocumentBuilderFactory for reading xml file DocumentBuilderFactory factory =
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String fileName = XPathFactoryExample.class.getClassLoader().getResource("smartphone.xml").getPath();
        Document doc = builder.parse(fileName);

        // Create XPathFactory for creating XPath Object
        XPathFactory xPathFactory = XPathFactory.newInstance();
        // Create XPath object from XPathFactory
        XPath xpath = xPathFactory.newXPath();
        // Compile the XPath expression for getting all brands
        XPathExpression xPathExpr = xpath.compile("/smartphones/smartphone/brand/text()");

        // XPath text example : executing xpath expression in java Object
        Object  result = xPathExpr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Java Xpath text example: All brands of popular smartphones ");
        printXpathResult(result);

        // get all models by xpath expression in java
        xPathExpr = xpath.compile("/smartphones/smartphone/model/text()");
        result = xPathExpr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Java Xpath text example: All popular smartphone model ");
        printXpathResult(result);

        // XPath count example : XPath expression to count elements in xml
        xPathExpr = xpath.compile("count(/smartphones/smartphone)");
        Double count = (Double) xPathExpr.evaluate(doc, XPathConstants.NUMBER);
        System.out.println("XPath count example: How many Smartphones we have: ");
        System.out.println("Count of elements: " + count);

        // XPath conditional exampl e: Do we have any HTC smartphone xPath
        xPathExpr = xpath.compile("count(/smartphones/smartphone[brand='HTC']) > 0");
        Boolean test = (Boolean) xPathExpr.evaluate(doc, XPathConstants.BOOLEAN);
        System.out.println("XPath boolean example: Do we have any HTC smartphone ");
        System.out.println(test);
    }

    /**
     * Method to print result on console
     * @param result
     */
    public void printXpathResult(Object result) {
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
    }

    //Main class to run the example.
    public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, SAXException, Exception {
        XPathFactoryExample xPathExample = new XPathFactoryExample();
        xPathExample.xPathProcessor();
    }
}
