package com.ithxt.dao;

import com.ithxt.domain.User;
import com.ithxt.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    //用户注册
    public void register(User user) throws SQLException {
        QueryRunner qr=new QueryRunner(C3P0Util.getConnection());
        String sql="insert into user (username,email,password,telephone) value (?,?,?,?) ";
       qr.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getTelephone());

    }
    //用户登录
    public User findUser(String username, String password) throws SQLException {
        QueryRunner qr=new QueryRunner(C3P0Util.getConnection());
        String sql="select * from user where username=? and password=?";
        return qr.query(sql,new BeanHandler<User>(User.class),username,password);
    }

}
