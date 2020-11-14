package com.pz.cg.db;

import com.pz.cg.GenerateEngine;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

/**
 * @author percy
 * @date 2020/8/26 13:50
 */
public class ConnectionPool {

    private static Properties prop = new Properties();
    private static String userName;
    private static String password;
    private static String url;
    private static String driver;
    private static Logger log = Logger.getLogger(ConnectionPool.class);

    static{
        try {
            prop = GenerateEngine.getProp();
            userName = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            url = prop.getProperty("jdbc.url");
            driver = prop.getProperty("jdbc.driver");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement st) {
        try {
            if (st != null) {
                st.close();
                st = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection con = null;
        log.info("正在连接到数据库。。。");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("连接数据库失败", e);
        }
        return con;
    }
}
