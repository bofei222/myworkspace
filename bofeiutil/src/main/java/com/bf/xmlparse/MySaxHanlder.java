package com.bf.xmlparse;

//要用sax解析xml文档 需要自己去实现一个事件处理器
// 事件处理器会有一些事件的callback函数，需要我们去重写

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MySaxHanlder extends DefaultHandler {
    //用来标识区分相同标签的节点
    boolean flag = false;
    int booknum = 0;
    //集合用来存放书对象
    ArrayList<Book> booklist = new ArrayList<>();
    Book book;
    //全局变量用来记录每一次查找解析到的标签 方便清空
    String previousTagName;

    @Override
    /*  startElement(String uri,String localName,String qName,Attributes attributes)
     * qName - 限定的名称（带有前缀），如果限定的名称不可用，则为空字符串。
     * attributes - 元素的属性。如果没有属性，则它将是空的 Attributes 对象
     * */
    // 每解析到 一个元素（element）的时候都会触发这个函数，并且将这个element的属性attributes和值value当作参数传进来
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        // 找到第二本书的书名
        if (qName.equals("书名")) {
            booknum++;
            if (booknum == 2) {
                flag = true;
            }
        }
        //找到了“书”开始标签
        if (qName.equals("书")) {//创建对象 准备接收其属性
            book = new Book();
        }//找到“作者”标签
        else if (qName.equals("作者")) {//获取title属性
            String value = attributes.getValue("title");
            if (book != null) {//设置title
                book.setTitle(value);
            }
        }
        //本次查找完成 需要的属性值已经传给对象
        previousTagName = qName;
    }

    // 当解析到一个元素标签的结束的时候 会调用
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // System.out.println("endElement: "+qName);
        //找到了“书”结束标签
        if (qName.equals("书")) {//把书对象加入集合中 同时并将其清空 用于下一次查找
            booklist.add(book);
            book = null;
        }//本标签内的查找 结束 清空tag
        previousTagName = "";
    }

    private int i = 0;
    // 当解析到一个文本节点的时候会调用
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        System.out.println("第" + ++i + "个");
        if (flag) {//找到了第二个书名节点 获取其内容
            System.out.println("文本节点：" + new String(ch, start, length));
            flag = false;
        }

        //获取文本节点内容
        String text = new String(ch, start, length);
        switch (previousTagName) {//标签值如果匹配<书名> 把书名标签的文本内容传给book对象
            case "书名":
                book.setName(text);
                break;
            case "作者":
                book.setAuthor(text);
                break;
            case "售价":
                book.setPrice(text);
                break;
            case "age":
                //标签匹配age  text中存的是字符串
                book.setAge(Integer.parseInt(text));
                break;
            default:
                break;
        }
    }

    // 当解析到一个document文档的开始的时候会调用
    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument:");
    }

    // 当解析到一个document文档的结尾的时候 会调用
    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument:" + booklist);
    }
}