package com.ithxt.servlet;


import com.ithxt.domain.User;
import com.ithxt.service.UserService;
import com.ithxt.utils.UserException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取表单数据
      String username=request.getParameter("username");
      String password=request.getParameter("password");
      String remember=request.getParameter("remember");
      //记住用户名和密码
      Cookie ckname=  new Cookie("username",username);
      Cookie ckpassword= new Cookie("password",password);
      response.addCookie(ckname);
        if (remember!=null){
            ckname.setMaxAge(Integer.MAX_VALUE);
            ckpassword.setMaxAge(Integer.MAX_VALUE);
            //将cookie写回到客户端中
            response.addCookie(ckname);
            response.addCookie(ckpassword);
        }else {
            ckname.setMaxAge(0);
            ckpassword.setMaxAge(0);
        }
        //根据用户名和密码查找出用户的信息
       UserService us=new UserService();
        try {
            User user= us.findUser(username,password);
            //将用户信息保存到session中
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        } catch (UserException e) {
            e.printStackTrace();
            request.setAttribute("login_msg",e.getMessage());
            request.getRequestDispatcher("/loginregister.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
