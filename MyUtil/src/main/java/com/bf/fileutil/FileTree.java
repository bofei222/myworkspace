package com.bf.fileutil;

import java.io.File;

/**
 * 打印目录树
 * @author bofei
 * @date 2017年8月10日 上午9:54:36 
 */
public class FileTree {

    public static void main(String[] args) {
        File dir = new File("F:\\A\\");
        // File dir=new File("F:\\");
        // 如果使用上述的盘符的根目录，会出现java.lang.NullPointerException
        // 为什么？
        getAllFiles(dir, 0);// 0表示最顶层
    }

    // 获取层级的方法
    public static String getLevel(int level) {
        // A mutable sequence of characters.
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < level; l++) {
            sb.append("|--");
        }
        return sb.toString();
    }
    
    /**
     * 
     * @author bofei
     * @date 2017年8月4日 下午5:28:32
     * @param dir
     * @param level
     */
    public static void getAllFiles(File dir, int level) {
        System.out.println(getLevel(level) + dir.getName());
        level++;
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                // 这里面用了递归的算法
                getAllFiles(files[i], level);
            } else {
                System.out.println(getLevel(level) + files[i]);
            }
        }
    }
}
