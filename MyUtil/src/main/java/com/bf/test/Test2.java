package com.bf.test;

import java.util.Random;

/**
 * @author bofei
 * @date 2017年8月24日 上午11:25:01 
 */
public class Test2 {
    public static void main(String[] args) {
        Random rand = new Random(47);
        System.out.println(rand.nextInt(20));
        System.out.println(rand.nextInt(20));
        System.out.println(rand.nextInt(20));
    }
}
