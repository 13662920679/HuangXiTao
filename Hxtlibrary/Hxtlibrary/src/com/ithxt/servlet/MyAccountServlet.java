package com.ithxt.servlet;



import com.ithxt.domain.User;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MyAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
     HttpSession session= request.getSession();
    User user= (User) session.getAttribute("user");
    //判断有没有登录
        if (user==null){
            response.getWriter().print("用户还没登录！<span style='color: #FF0000'>3秒</span>自动跳转到登录界面");
            response.setHeader("refresh", "3;url='"+request.getContextPath()+"/loginregister.jsp'");
        }else {
           request.getRequestDispatcher("/myAccount.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
