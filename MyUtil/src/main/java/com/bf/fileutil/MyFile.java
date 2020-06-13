package com.bf.fileutil;

import java.io.File;

/**
 * 继承File,添加一个自定义属性level，
 * 重写 listFiles()方法，使其返回类型为MyFile[]
 * @author bofei
 * @date 2017年8月10日 上午9:20:28 
 */
public class MyFile extends File {

    private Integer level;

    public MyFile(String pathname) {
        super(pathname);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public MyFile[] listFiles() {
        File[] theFiles = super.listFiles();
        
        if (theFiles == null) return null;
        // if (theFiles == null || theFiles.length == 0) return null;

        MyFile[] myFiles = new MyFile[theFiles.length];
        for (int i = 0; i < theFiles.length; i++) {
            myFiles[i] = new MyFile(theFiles[i].getAbsolutePath());
        }
        return myFiles;
    }

}
