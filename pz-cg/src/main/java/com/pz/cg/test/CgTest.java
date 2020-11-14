package com.pz.cg.test;

import com.pz.cg.GenerateEngine;

/**
 * @author percy
 * @date 2020/8/26 16:49
 */
public class CgTest {

    public static void main(String[] args) {
        String tableName1 = "mall_province";
        String className1 = "MallProvince";
        cgPojo(tableName1, className1);
        cgQueryPojo(tableName1, className1);
        cgSqlMap(tableName1, className1);
        cgDao(tableName1, className1);
        cgService(tableName1, className1);
        cgAction(tableName1, className1);
        cgBase();
        GenerateEngine.clearContext();

        String tableName2 = "mall_city";
        String className2 = "MallCity";
        cgPojo(tableName2, className2);
        cgQueryPojo(tableName2, className2);
        cgSqlMap(tableName2, className2);
        cgDao(tableName2, className2);
        cgService(tableName2, className2);
        cgAction(tableName2, className2);
        cgBase();
        GenerateEngine.clearContext();

        String tableName3 = "mall_area";
        String className3 = "MallArea";
        cgPojo(tableName3, className3);
        cgQueryPojo(tableName3, className3);
        cgSqlMap(tableName3, className3);
        cgDao(tableName3, className3);
        cgService(tableName3, className3);
        cgAction(tableName3, className3);
        cgBase();
        GenerateEngine.clearContext();

    }

    private static void cgBase() {
    }
    private static void cgQueryPojo(String tableName1, String className1) {
    }
    private static void cgPojo(String tableName1, String className1) {
    }
    private static void cgSqlMap(String tableName1, String className1) {
    }
    private static void cgDao(String tableName1, String className1) {
    }
    private static void cgService(String tableName1, String className1) {
    }
    private static void cgAction(String tableName1, String className1) {
    }

}
