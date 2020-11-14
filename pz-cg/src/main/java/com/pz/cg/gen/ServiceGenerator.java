package com.pz.cg.gen;

import com.pz.cg.CodeGenerator;
import com.pz.cg.GenerateEngine;

import java.util.HashSet;
import java.util.Set;

/**
 * @author percy
 * @date 2020/8/26 15:53
 */
public class ServiceGenerator extends GenerateEngine implements CodeGenerator {
    @Override
    public void generate(String tableName, String className) {
        this.tableName = tableName;
        this.className = className;
        this.setFileName(this.className+ "Service" + ".java");
        this.setPackagee(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.service") +this.getSecondDir());
        this.setImports(this.getServiceImport());
        this.init(SERVICE);
        this.generate();
        this.generateImpl(tableName,className);
    }

    private void generateImpl(String tableName, String className) {
        this.tableName = tableName;
        this.className = className;
        this.setFileName(this.className+ "ServiceImpl" + ".java");
        this.setPackagee(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.service") +  this.getSecondDir() + ".impl");
        this.setTemplate(prop.getProperty("service.impl"));
        this.setImports(this.getServiceImplImport());
        this.init(SERVICE_IMPL);
        this.generate();
    }

    public Set<String> getServiceImport() {
        Set<String> imports =new HashSet<String>();
        imports.add("java.util.List");
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.domain") +".Result" );
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.domain") +this.getSecondDir()  + "." +className);
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.querydomain")+this.getSecondDir()  + ".Query"+ className);
        context.put(IMPORTS,imports);
        return imports;
    }

    public Set<String>getServiceImplImport() {
        Set<String> imports =new HashSet<String>();
        imports.add("java.util.List");
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.domain") +".Result" );
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.domain") +this.getSecondDir()  + "." +className);
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.querydomain")+this.getSecondDir()  + ".Query"+ className);
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.dao") +this.getSecondDir()  + "." +className + "Dao");
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.service") +this.getSecondDir() + "." + className + "Service");
        context.put(IMPORTS,imports);
        return imports;
    }

}
