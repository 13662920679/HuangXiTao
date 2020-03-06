package com.ithxt.servlet;


import com.ithxt.domain.User;
import com.ithxt.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //封装表单数据
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out=response.getWriter();
        User user=new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
            UserService us=new UserService();
            us.register(user);
            //将用户信息保存到session作用域中
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            out.print("注册成功，<span style='color:red'>3</span>秒自动跳转到主页面中");
            response.setHeader("refresh","3;url='/index.jsp'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
