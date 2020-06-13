package com.bf.fileutil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;



/**
 * @author bofei
 * @date 2017年8月10日 上午10:44:40 
 */
public class ClassifyFolderUtils {
    
    /**
     * 按文件类型打包 先if，使用形参 保证 在递归中一直是一个 Set集合 
     * 使用 后缀名作为新包名
     * @param typesSet
     * @param inPath
     * @param outPath
     * @return
     */
    public static Set<String> typeClassify(Set<String> typesSet, String inPath, String outPath) {
        File file = new File(inPath);
        
        // 如果是目录则递归计算其内容的总大小
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File f : children) {
                typesSet.addAll(typeClassify(typesSet, f.getPath(), outPath));
            }
            return typesSet;
        } else {
            String filePath = file.getPath();
            // 截取后缀名
            String suffix = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
            // 文件类型文件夹所在的位置
            String typePath = outPath + File.separator + suffix;
            
            // 不重复建
            if (!typesSet.contains(suffix)) {
                typesSet.add(suffix);
                // 在新创建的文件夹里面创建这个后缀名命名的文件夹。
                System.out.println("建立文件夹： " + typePath);
                new File(typePath).mkdir();
            }
            FileMove.moveFile(filePath, typePath);
            return typesSet;
        }
        
    }
    
    /**
     * 使用uuid作为新包名
     * 使用map  映射 后缀和uuid的 关系
     * @param map
     * @param inPath
     * @param outPath
     * @return
     */
    public static Map<String,String> typeClassify2(Map<String,String> map, String inPath, String outPath) {
        File file = new File(inPath);

        // 如果是目录则递归计算其内容的总大小
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File f : children) {
                map.putAll(typeClassify2(map, f.getPath(), outPath));
            }
            return map;
        } else {
            String filePath = file.getPath();
            // 截取后缀名
            String suffix = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
            
            // 不重复建
            if (!map.keySet().contains(suffix)) {
                String pkgUUID = UUID.randomUUID().toString();
                String typePath = outPath + File.separator + pkgUUID;
                map.put(suffix, typePath);
                
                // 在新创建的文件夹里面创建这个后缀名命名的文件夹。
                System.out.println("建立文件夹： " + typePath);
                new File(typePath).mkdir();
            }
            
            FileMove.moveFile(filePath, map.get(suffix));
            return map;
        }

    }
}
