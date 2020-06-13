package corejava.jihe.treeset.demo;

import java.util.TreeSet;

/**
 * @author bofei
 * @date 2017年9月13日 上午9:11:56 
 */
class Z implements Comparable 
{ 
    int age; 
    public Z(int age) 
    { 
        this.age = age; 
    } 
    public boolean equals(Object obj) 
    { 
        return false; 
    } 
    public int compareTo(Object obj) 
    { 
        return 1; 
    } 
}

public class TestTreeSet 
{ 
    public static void main(String[] args) 
    { 
        TreeSet set = new TreeSet(); 
        Z z1 = new Z(6); 
        set.add(z1); 
        System.out.println(set.add(z1)); 
        //下面输出set集合，将看到有2个元素 
        System.out.println(set); 
        //修改set集合的第一个元素的age属性 
        ((Z)(set.first())).age = 9; 
        //输出set集合的最后一个元素的age属性，将看到也变成了9 
        System.out.println(((Z)(set.last())).age); 
    } 
}
