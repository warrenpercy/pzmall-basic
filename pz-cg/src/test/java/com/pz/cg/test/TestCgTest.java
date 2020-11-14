package com.pz.cg.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

/**
 * @author percy
 * @date 2020/8/27 7:26
 */
public class TestCgTest {

    @Test
    public void test001() {
        URL resource = CgTest.class.getResource("/config/config-local.properties");
        File file = FileUtils.toFile(resource);
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> strings = prop.stringPropertyNames();
        System.out.println(strings);
    }
}
