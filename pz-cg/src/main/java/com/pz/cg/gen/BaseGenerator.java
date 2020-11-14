package com.pz.cg.gen;

import com.pz.cg.CodeGenerator;
import com.pz.cg.GenerateEngine;

import java.util.HashSet;
import java.util.Set;

/**
 * @author percy
 * @date 2020/8/26 15:45
 */
public class BaseGenerator extends GenerateEngine implements CodeGenerator {
    @Override
    public void generate(String tableName, String className) {
        //由PaginateBaseDO.vm生成PaginateBaseDO.java
        this.classType = QUERYDOMAIN;
        this.setTemplate("PaginateBaseDO.vm");
        this.setFileName("PaginateBaseDO.java");
        this.setPackagee(prop.getProperty(GenerateEngine.PACKAGE_NAME)+ "." + prop.getProperty("package.querydomain"));
        initClassMetaInfo();
        initLocation();
        this.generate();


        //由Result.vm生成Result.java
        this.classType = DOMAIN;
        this.setTemplate("Result.vm");
        this.setFileName("Result.java");
        this.setPackagee(prop.getProperty(GenerateEngine.PACKAGE_NAME)+ ".domain.base" );
        this.setImports(getResultImport());
        initClassMetaInfo();
        initLocation();
        this.generate();

        //生成BaseDO
        this.classType = DOMAIN;
        this.setTemplate("BaseDO.vm");
        this.setFileName("BaseDO.java");
        this.setPackagee(prop.getProperty(GenerateEngine.PACKAGE_NAME)+ ".domain.base");
        this.setImports(getResultImport());
        initClassMetaInfo();
        initLocation();
        this.generate();

        //生成输出文件格式
        this.classType = DOMAIN;
        this.setTemplate("NoNullFieldStringStyle.vm");
        this.setFileName("NoNullFieldStringStyle.java");
        this.setPackagee(prop.getProperty(GenerateEngine.PACKAGE_NAME)+ ".domain.base" );
        this.setImports(getResultImport());
        initClassMetaInfo();
        initLocation();
        this.generate();
    }

    public Set<String> getResultImport() {
        Set<String> imports =new HashSet<String>();
        imports.add(prop.getProperty(PACKAGE_NAME)+ ".domain.base"  +".PaginateBaseDO" );
        context.put(IMPORTS,imports);
        return imports;
    }
}
