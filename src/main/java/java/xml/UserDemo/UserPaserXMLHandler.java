package java.xml.UserDemo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/23/17
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserPaserXMLHandler extends DefaultHandler {

    private String currentQName;  //因为startElement()才能获取到标签名称，但是标签的内容在characters()获取，而且他们的执行顺序一直是顺序的，所以可以使用currentQName来过渡一下获取上一次的标签名

    @Override
    public void startDocument() throws SAXException {
        SAXOperateXmlDemo.userList = new ArrayList<User>();
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("user")){
            SAXOperateXmlDemo.user = new User(); //每次解析到user标签了才会创建user对象的实例
            //添加user标签中的id属性
            if(attributes.getLength() > 0){
                SAXOperateXmlDemo.user.setId(Long.valueOf(attributes.getValue("id")));
            }
        }
        this.currentQName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //需要说明的是，因为每一个非空标签都有characters(),那么无法知道user子标签循环完了
        //但是可以这样，如果不考虑子标签顺序可以判断是否解析到了最后一个子标签来判断
        //或者直接在user标签的endElement()中添加即可。
        if(qName.equals("user")){
            SAXOperateXmlDemo.userList.add(SAXOperateXmlDemo.user);
            SAXOperateXmlDemo.user = null;
        }
        this.currentQName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        //System.out.println(currentQName + "：" + content);
        if(SAXOperateXmlDemo.user != null && currentQName != null){
            if(currentQName.equals("name")){
                SAXOperateXmlDemo.user.setName(content);
            }else if(currentQName.equals("age")){
                SAXOperateXmlDemo.user.setAge(Long.valueOf(content));
            }else if(currentQName.equals("hobby")){
                SAXOperateXmlDemo.user.setHobby(content);
            }
        }
    }
}
