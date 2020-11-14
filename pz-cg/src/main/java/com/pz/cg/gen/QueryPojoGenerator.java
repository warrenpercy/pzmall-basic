package com.pz.cg.gen;

import com.pz.cg.CodeGenerator;
import com.pz.cg.GenerateEngine;

import java.util.HashSet;
import java.util.Set;

/**
 * @author percy
 * @date 2020/8/26 15:52
 */
public class QueryPojoGenerator extends GenerateEngine implements CodeGenerator {
    @Override
    public void generate(String tableName, String className) {
        this.tableName = tableName;
        this.className = className;
        this.setFileName("Query"+this.className + ".java");
        this.setPackagee(prop.getProperty(PACKAGE_NAME)+ "." + prop.getProperty("package.querydomain") +  this.getSecondDir());
        this.setImports(getImport());
        this.init(QUERYDOMAIN);
        context.put(IMPORTS,this.getImports());
        this.generate();
    }

    public Set<String> getImport() {
        Set<String> imports = new HashSet<String>();
        imports.add(prop.getProperty(PACKAGE_NAME) + ".domain.base.PaginateBaseDO");
        context.put(IMPORTS, imports);
        return imports;
    }
}
