package com.test;

public class StringDemo {
    public static void main(String[] args) {
        String s = "abc@def@g".substring(1);
        System.out.println(s);
        int i = "abc@def@g".lastIndexOf("@");
        System.out.println(i);
    }
}
