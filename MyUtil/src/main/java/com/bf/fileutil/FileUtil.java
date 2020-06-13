package com.bf.fileutil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



/**
 * @author bofei
 * @date 2017年8月10日 上午9:26:19 
 */
public class FileUtil {
    
    /**
     * 为目录下每层目录设置 层级（level属性），并返回集合
     * 使用局部变量list。level作为参数，在递归中传入
     * @param dir
     * @param level
     * @return
     */
    public static List<MyFile> setLevels(MyFile dir, int level) {
        List<MyFile> list = new ArrayList();
        dir.setLevel(level);
        list.add(dir);
        level++;
        MyFile[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                // 这里面用了递归的算法
                list.addAll(setLevels(files[i], level));

            } else {
                // System.out.println(level + " " + files[i]);
            }
        }
        return list;
    }
    
    /**
     * 遍历MyFile集合，选出指定层级的目录集合
     * @param myfiles
     * @param level
     * @return
     */
    public static List<String> test2(List<MyFile> myfiles, Integer level) {
        List<String> list = new ArrayList<String>();
        for (MyFile myfile : myfiles) {
            if (myfile.getLevel() == level) {
                list.add(myfile.getAbsolutePath());
            }
        }
        return list;
    }
    
    /**
     * 获取文件或文件夹的大小
     * @param file
     * @return
     */
    public static double getDirSize(File file) {
        // 判断文件是否存在
        if (file.exists()) {
            // 如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                double size = 0;
                for (File f : children)
                    size += getDirSize(f);
                return size;
            } else {// 如果是文件则直接返回其大小,以“兆”为单位
                double size = (double) file.length() / 1024 / 1024;
                return size;
            }
        } else {
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
            return 0.0;
        }
    }
}
