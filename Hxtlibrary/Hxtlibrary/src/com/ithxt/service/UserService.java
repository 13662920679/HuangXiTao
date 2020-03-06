package com.ithxt.service;



import com.ithxt.dao.UserDao;

import com.ithxt.domain.User;
import com.ithxt.utils.UserException;

import java.sql.SQLException;

public class UserService {
    UserDao ud=new UserDao();
    //用户注册
    public void register(User user) {
        try {
            ud.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     //用户登录
     public User findUser(String username, String password) throws UserException {
         User user=null;
         try {
             user=  ud.findUser(username,password);
             if (user==null){
                 throw new UserException("用户名或密码错误");
             }
         } catch (SQLException e) {
             e.printStackTrace();
             throw new UserException("用户名或密码错误");
         }
         return user;
     }

}
