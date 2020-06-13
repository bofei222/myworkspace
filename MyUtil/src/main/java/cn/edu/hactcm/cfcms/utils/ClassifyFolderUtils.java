package cn.edu.hactcm.cfcms.utils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import com.bf.fileutil.FileMove;

/**
 * 文件分类中用到的所有工具类 CFMS ：Computer files management system version ：1.0 2013-3-3
 * 上午02:28:40
 */
public class ClassifyFolderUtils {
    /**
     * 在from 这个文件夹里创建 innerFolderName 这个文件夹，如果前者内部的文
     * 件中包含关键字innerFolderName，那么把文件拷贝到innerFolderName文件夹里面去
     * 
     * @param innerFolderName
     * @param from
     */
    /*public static void NameClassify(String innerFolderName, String from) {
        File fromFile = new File(from);

        // 如果选中的文件夹是一个文件夹，那么将不做任何操作
        if (from.isEmpty()) {
            return;
        } else {
            // 获得文件里面的所有文件
            File[] listFiles = fromFile.listFiles();

            // 如果选中的文件不是空文件，在这个文件里面创建要分类的文件
            String newPath = from + File.separator + innerFolderName;
            File newFile = new File(newPath);

            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    // 判断这个文件夹中是否有这个关键字，如果有的话就拷贝目录了到制定目录内了。
                    if (listFiles[i].getName().indexOf(innerFolderName) != -1) {
                        // 获得这个文件夹的名称，在指定的文件内创建这个目录
                        if (!newFile.exists()) {
                            newFile.mkdir();
                        }

                        FileOperationUtils.copyFolder2Folder(listFiles[i].getPath(), newPath);
                    } else {// 如果没有就跳出这个循环
                        continue;
                    }
                } else {
                    // 判断这个文件是否含有名称关键字
                    if (listFiles[i].getName().indexOf(innerFolderName) != -1) {
                        String destFilePath = newPath + File.separator + listFiles[i].getName();
                        if (!newFile.exists()) {
                            newFile.mkdir();

                        }
                        FileOperationUtils.copyFileToFile(listFiles[i].getPath(), destFilePath);
                    } else {
                        continue;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "操作成功，请查看指定目录!", "提示消息", JOptionPane.WARNING_MESSAGE);
    }*/

    public static void TypeClassify(String path) {
        File destFile = new File(path);
        // 判断是否是文件夹，文件夹是否为空
        if (destFile.isFile()) {
            JOptionPane.showMessageDialog(null, "对不起，不能对文件进行按类型分类，请填写文件夹路径");
            return;
        }

        if (!destFile.exists()) {
            JOptionPane.showMessageDialog(null, "对不起，所指定文件夹不存在");
            return;
        }

        typeOperation(path, destFile);

        // 提示消息
        JOptionPane.showMessageDialog(null, "操作成功，请查看指定目录!", "提示消息", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * @param path
     * @param destFile
     */
    private static void typeOperation(String path, File destFile) {
        File[] listFiles = destFile.listFiles();
        if (listFiles.length == 0) {
            return;
        }

        // 条件都成立了的话，就在这个路径下面创建一个文件
        String newPath = path + File.separator + "这里存放的是按照类型分类之后的文件所在位置";
        File newFile = new File(newPath);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }

        Set<String> typesSet = new HashSet<String>();
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                // 进行递归
                typeOperation(path, file2);
            } else {
                String filePath = file2.getPath();
                // 截取后缀名
                String suffix = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
                // 文件类型文件夹所在的位置
                String newTypePath = newPath + File.separator + suffix;
                // 使用set集合存储后缀名，让这些重复的后缀名只存在一次,如果没有才存入这个结合中
                if (!typesSet.contains(suffix)) {
                    typesSet.add(suffix);
                    // 在新创建的文件夹里面创建这个后缀名命名的文件夹。
                    new File(newTypePath).mkdir();
                }

//                FileOperationUtils.copyFile2Folder(file2.getPath(), newTypePath);
                FileMove.moveFile(file2.getPath(), newTypePath);
            }
        }
    }

    /**
     * 按大小分类
     * 
     * @param sizeNameValue
     *            ：按名称分类的文件名称
     * @param folderPath
     *            : 对那个文件夹进行按照大小分类
     * @param min
     *            : 文件最小值
     * @param max
     *            : 文件最大值
     * @param unit1
     *            : 最小值的单位
     * @param unit2
     *            : 最大值的单位
     */
    /*public static void SizeClassify(String sizeNameValue, String folderPath, String min, String max, String unit1,
            String unit2) {
        boolean b = DataValidate.validate(min, max);
        if (!b) {
            return;
        } else {
            Integer minValue = Integer.parseInt(min);
            Long minSize = FileInfoUtils.judgeUnit(unit1) * minValue;
            Integer maxValue = Integer.parseInt(max);
            Long maxSize = FileInfoUtils.judgeUnit(unit2) * maxValue;

            String newPath = folderPath + File.separator + sizeNameValue;
            File newFile = new File(newPath);
            if (!newFile.exists()) {
                newFile.mkdir();
            }

            // 开始按照大小分类
            File fromFile = new File(folderPath);
            File[] listFiles = fromFile.listFiles();
            // 判断这个文件夹里面是否有文件，如果有文件才可以，否者直接返回
            if (listFiles.length > 0) {
                for (File file : listFiles) {
                    long fileSize = FileInfoUtils.getFileSize(file.getPath());
                    if (fileSize > minSize && fileSize < maxSize) {
                        FileOperationUtils.copyFileInAllType(file.getPath(), newPath);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "对不起,你选中的文件夹为空!", "提示信息", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        // 提示消息
        JOptionPane.showMessageDialog(null, "操作成功，请查看指定目录!", "提示消息", JOptionPane.WARNING_MESSAGE);
    }*/

    /**
     * 按照时间分类
     * 
     * @param sizeNameValue
     *            ：时间分类的名称
     * @param folderPath
     *            : 这是一个文件夹路径，指定要对那个文件进行操作
     * @param datetime1
     *            : 这是时间点一
     * @param datetime2
     *            : 这是时间点二
     */
    /*public static void TimeClassify(String timeNameValue, String folderPath, String datetime1, String datetime2) {
        // 获得两个时间的时间毫秒值
        long time1 = new DateFormatUtils().getMillisecondsByTimeString(datetime1);
        long time2 = new DateFormatUtils().getMillisecondsByTimeString(datetime2);
        long timeMax = (time1 > time2) ? time1 : time2;
        long timeMin = (time1 > time2) ? time2 : time1;
        if (time1 == time2) {
            JOptionPane.showMessageDialog(null, "对不起，两个时间的值不能相同!", "提示消息", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 判断这个文件夹里面是否有文件，如果没有文件，那么就返回
        File file = new File(folderPath);
        File[] listFiles = file.listFiles();
        if (listFiles.length == 0) {
            return;
        }
        // 如果有文件，创建文件夹，然后执行其他的工作
        String newPath = folderPath + File.separator + timeNameValue;
        File newFile = new File(newPath);
        if (!newFile.exists()) {
            newFile.mkdir();
        }

        for (File file2 : listFiles) {
            long lastModifiedTime = file2.lastModified();
            if (lastModifiedTime <= timeMax && lastModifiedTime >= timeMin) {
                FileOperationUtils.copyFileInAllType(file2.getPath(), newPath);
            }
        }
        // 提示消息
        JOptionPane.showMessageDialog(null, "操作成功，请查看指定目录!", "提示消息", JOptionPane.WARNING_MESSAGE);
    }*/
}