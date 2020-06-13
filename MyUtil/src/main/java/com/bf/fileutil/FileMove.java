package com.bf.fileutil;

import java.io.File;

/**
 * @author 作者 bofei
 * @version 创建时间：2017年7月31日 下午6:10:06
 */
public class FileMove {
    public static void main(String[] args) {
        moveDirectory("F:\\AA\\B\\2.txt", "F:\\AA\\这里存放的是按照类型分类之后的文件所在位置\\txt");
        System.out.println("完毕");
    }

    /**
     * 移动目录
     * 
     * @param srcDirName
     *            源目录完整路径
     * @param destDirName
     *            目的目录完整路径
     * @return 目录移动成功返回true，否则返回false
     */
    public static boolean moveDirectory(String srcDirName, String destDirName) {

        File srcDir = new File(srcDirName);
        if (!srcDir.exists() || !srcDir.isDirectory())
            return false;

        File destDir = new File(destDirName);
        if (!destDir.exists())
            destDir.mkdirs();

        /**
         * 如果是文件则移动，否则递归移动文件夹。删除最终的空源文件夹 注意移动文件夹时保持文件夹的树状结构
         */
        File[] sourceFiles = srcDir.listFiles();
        for (File sourceFile : sourceFiles) {
            if (sourceFile.isFile()) {

                moveFile(sourceFile.getAbsolutePath(), destDir.getAbsolutePath());
                String inFile = sourceFile.getAbsolutePath();
                System.out.println("inFile:" + inFile);
                String outFile = destDirName + File.separator + sourceFile.getName();
                System.out.println("outFile:" + outFile);
            } else if (sourceFile.isDirectory())
                moveDirectory(sourceFile.getAbsolutePath(),
                        destDir.getAbsolutePath() + File.separator + sourceFile.getName());
            else
                ;
        }
        // return srcDir.delete();
        return true;
    }

    /**
     * 移动文件
     * 
     * @param srcFileName
     *            源文件完整路径
     * @param destDirName
     *            目的目录完整路径
     * @return 文件移动成功返回true，否则返回false
     */
    public static boolean moveFile(String srcFileName, String destDirName) {

        File srcFile = new File(srcFileName);
        if (!srcFile.exists() || !srcFile.isFile())
            return false;

        // File destDir = new File(destDirName);
        // if (!destDir.exists())
        // destDir.mkdirs();

        return srcFile.renameTo(new File(destDirName + File.separator + srcFile.getName()));
    }
}
