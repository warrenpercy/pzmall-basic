package com.pz.cg.gen;

import com.pz.cg.CodeGenerator;
import com.pz.cg.GenerateEngine;
import com.sun.java.browser.plugin2.DOM;

import java.util.HashSet;
import java.util.Set;

/**
 * @author percy
 * @date 2020/8/26 15:52
 */
public class PojoGenerator extends GenerateEngine implements CodeGenerator {
    @Override
    public void generate(String tableName, String className) {
        this.tableName = tableName;
        this.className = className;
        this.setFileName(this.className + ".java");
        this.setPackagee(prop.getProperty(PACKAGE_NAME) + "." + prop.getProperty("package.domain") + this.getSecondDir());
        this.init(DOMAIN);
        context.put(IMPORTS, this.getPojoImports());
    }

    protected Set<String> getPojoImports() {
        Set<String> imports = new HashSet<String>();
        imports.add(prop.getProperty(PACKAGE_NAME) + ".domain.base.BaseDO");
        return imports;
    }
}
