package com.pz.cg.db.util;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author percy
 * @date 2020/8/26 14:29
 */
public class MetaDataUtil {

    public static Map<String, String> getTableColumns(Connection con, String tableName) {
        Map<String, String> columns = new HashMap<String, String>();
        return columns;
    }

    public static String createSetterName(String fieldName) {
        return "set"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()-1);
    }

    public static String createGetterName(String fieldName) {
        return "get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()-1);
    }

    public static String createJavaType(String dbJavaType) {
        String javaType = dbJavaType.substring(dbJavaType.lastIndexOf(".") + dbJavaType.length() - 1);
        if ("TimeStamp".equals(javaType)) {
            javaType = "Date";
        }
        return javaType;
    }

    public static String propertyToField(String property) {
        if (null == property) {
            return "";
        }
        char[] chars = property.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            if (CharUtils.isAsciiAlphaUpper(c)) {
                sb.append("_" + StringUtils.lowerCase(CharUtils.toString(c)));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String fieldToProperty(String field) {
        if (null == field) {
            return "";
        }
        char[] chars = field.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '_') {
                int j = i + 1;
                if (j < chars.length) {
                    sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));
                    i++;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
