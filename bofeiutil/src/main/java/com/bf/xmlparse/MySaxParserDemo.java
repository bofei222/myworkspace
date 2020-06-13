package com.bf.xmlparse;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

// sax 只用于解析数据，不用于修改xml数据。
public class MySaxParserDemo {
    public static void main(String[] args) throws Exception, SAXException {


        // 使用SAXParserFactory创建SAX解析工厂
        SAXParserFactory spf = SAXParserFactory.newInstance();
        // 通过SAX解析工厂得到解析器对象
        SAXParser sp = spf.newSAXParser();
        // 通过解析器对象得到一个XML的读取器
        XMLReader xmlReader = sp.getXMLReader();
        // 设置读取器的事件处理器
        xmlReader.setContentHandler(new MySaxHanlder());
        // 解析xml文件
        xmlReader.parse("D:\\MyProjects\\mycode\\bofeiutil\\book.xml");
    }
}