package corejava.jihe.treeset.demo;

import java.util.TreeSet;

/**
 * @author bofei
 * @date 2017年9月13日 上午9:16:33 
 */
class Err 
{ 
} 
public class TestTreeSetError 
{ 
    public static void main(String[] args) 
    { 
        TreeSet ts = new TreeSet(); 
        //向TreeSet集合中添加两个Err对象 
        ts.add(new Err()); 
        //  java.lang.ClassCastException: 
        // corejava.jihe.treeset.demo.Err cannot be 
        // cast to java.lang.Comparable
        ts.add(new Err()); 
    } 
}