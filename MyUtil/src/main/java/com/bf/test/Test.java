package com.bf.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bofei
 * @date 2017年8月16日 上午10:22:52 
 */
public class Test {
    public static void main(String[] args) {
        Integer[] arrInt = new Integer[]{
           1, 2, 4, 6, 7, 8, 9, 11, 12, 14, 16, 17, 18
        };
        
        // 数组转换为LinkedList
        List list = new LinkedList(Arrays.asList(arrInt));
        System.out.println(list);
        
        System.out.println(test(arrInt));
    }
    
    /**
     * 查询数组中第一个能被3整出的数
     * @author bofei
     * @date 2017年8月16日 上午11:30:54
     * @param arrInt
     * @return
     */
    public static Integer test(Integer[] arrInt) {
        for (int i = 0; i< arrInt.length; i++) {
            if (arrInt[i]%3 ==0) {
                return arrInt[i];
            }
        }
        return null;
    }
}
