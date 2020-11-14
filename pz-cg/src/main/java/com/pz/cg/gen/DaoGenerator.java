package com.pz.cg.gen;

import com.pz.cg.CodeGenerator;
import com.pz.cg.GenerateEngine;

import java.util.HashSet;
import java.util.Set;

/**
 * @author percy
 * @date 2020/8/26 15:52
 */
public class DaoGenerator extends GenerateEngine implements CodeGenerator {
    @Override
    public void generate(String tableName, String className) {
        this.tableName = tableName;
        this.className = className;
        this.setFileName(this.className+ "Dao" + ".java");
        this.setPackagee(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.dao") +this.getSecondDir());
        this.setImports(this.getDaoImport());
        this.init(DAO);
        this.generate();
        this.generateImpl(tableName,className);
    }

    private void generateImpl(String tableName, String className) {
        this.tableName = tableName;
        this.className = className;
        this.setFileName(this.className+ "DaoImpl" + ".java");
        this.setPackagee(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.dao") +  this.getSecondDir() + ".impl");
        this.setTemplate(prop.getProperty("dao.impl"));
        this.setImports(this.getDaoImplImport());
        this.init(DAO_IMPL);
        this.generate();
    }

    public Set<String> getDaoImport(){
        Set<String> imports =new HashSet<String>();
        imports.add("java.util.List");
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.querydomain")+this.getSecondDir()  + "."+"Query"+ className);
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.domain") +this.getSecondDir()  + "." +className);
        context.put(IMPORTS,imports);
        return imports;
    }

    public Set<String>getDaoImplImport() {
        Set<String> imports =new HashSet<String>();
        imports.add("java.util.List");
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.domain") +  this.getSecondDir()  + "." + className);
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.querydomain")+this.getSecondDir()  + ".Query"+ className);
        imports.add(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.dao") +  this.getSecondDir()  + "." + className +"Dao");
        context.put(IMPORTS,imports);
        return imports;
    }

}
