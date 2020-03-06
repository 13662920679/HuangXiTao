package com.ithxt.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0Util {
    private static  DataSource dataSource=new ComboPooledDataSource();
    public static DataSource getConnection(){
        //从数据源中得到一个链接
        return dataSource;
    }

}
