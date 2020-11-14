package com.pz.cg.db;

/**
 * @author percy
 * @date 2020/8/26 13:46
 */
public class Field {
    //java属性名
    private String propertyName;
    //字段名
    private String fieldName;
    //java数据完整类型
    private String javaFullType;
    //java数据类型
    private String javaType;
    //数据库字段类型
    private String jdbcType;
    //getter名
    private String getterName;
    //setter名
    private String setterName;
    //数据库字段注释
    private String Comment;
    //长度
    private int length;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getJavaFullType() {
        return javaFullType;
    }

    public void setJavaFullType(String javaFullType) {
        this.javaFullType = javaFullType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getGetterName() {
        return getterName;
    }

    public void setGetterName(String getterName) {
        this.getterName = getterName;
    }

    public String getSetterName() {
        return setterName;
    }

    public void setSetterName(String setterName) {
        this.setterName = setterName;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
