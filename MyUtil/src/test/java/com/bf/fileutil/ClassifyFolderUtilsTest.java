package com.bf.fileutil;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

/**
 * @author bofei
 * @date 2017年8月10日 上午10:57:12 
 */
public class ClassifyFolderUtilsTest {
    

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testTypeClassify() {
        ClassifyFolderUtils.typeClassify(new HashSet<String>(), "F:\\A - 副本", "F:\\B");
    }

    @Test
    public void testTypeClassify2() {
        ClassifyFolderUtils.typeClassify2(new HashMap<String,String>(), "F:\\A - 副本", "F:\\B");
    }

}
