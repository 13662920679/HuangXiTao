package com.ithxt.dao;

import com.ithxt.domain.Book;
import com.ithxt.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {

    public List<Book> findAllBook(String category) throws SQLException {
        QueryRunner qr=new QueryRunner(C3P0Util.getConnection());
         String sql=null;
         System.out.print("dao中获取到的书籍类别为"+category);

         if ("".equals(category)){
             sql="select * from book";
         }else {
             sql="select * from book where category='"+category+"'";
         }
        List<Book> list= qr.query(sql,new BeanListHandler<Book>(Book.class));
         System.out.print("查询到的数据集合的数据为"+list);
         return list;
    }

    public Book findBookById(String id) throws SQLException {
        QueryRunner qr=new QueryRunner(C3P0Util.getConnection());
        String sql="select * from book where id=?";
        return  qr.query(sql,new BeanHandler<Book>(Book.class),id);
    }
}
