package com.javasm.constant;

/**
 * JDBC连接数据库的4个常量
 */
public interface JDBCConstant {

    String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    String USERNAME = "root";
    String PWD = "root";

}