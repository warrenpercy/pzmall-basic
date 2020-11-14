package com.pz.cg.gen;

import com.pz.cg.CodeGenerator;
import com.pz.cg.GenerateEngine;

/**
 * @author percy
 * @date 2020/8/26 15:53
 */
public class SqlMapGenerator extends GenerateEngine implements CodeGenerator {

    public static String SQL_DOMAIN ="sqlDomain";
    public static String SQL_QUERYDOMAIN ="sqlQueryDomain";
    public static String DAO_DOMAIN ="daoDomain";

    @Override
    public void generate(String tableName, String className) {
        this.tableName = tableName;
        this.className = className;
        this.setFileName(this.className+ "Mapper.xml");
        //设置sqlmap的domain和querydomain 的package
        context.put(SQL_DOMAIN,prop.getProperty(PACKAGE_NAME) + "." +prop.getProperty("package.domain") + this.getSecondDir()  + "." + className);
        context.put(SQL_QUERYDOMAIN,prop.getProperty(PACKAGE_NAME) + "." +prop.getProperty("package.querydomain")+ this.getSecondDir()  + ".Query" + className);
        context.put(DAO_DOMAIN,prop.getProperty(PACKAGE_NAME) + "." +prop.getProperty("package.dao") + this.getSecondDir()  + "." + className);
        this.init(SQL_MAP);
        this.generate();
    }
}
