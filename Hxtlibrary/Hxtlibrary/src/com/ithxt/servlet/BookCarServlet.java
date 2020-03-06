package com.ithxt.servlet;

import com.ithxt.domain.Book;
import com.ithxt.domain.User;
import com.ithxt.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BookCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //判断有没有登录

        User user= (User) request.getSession().getAttribute("user");
        if (user==null){
            response.getWriter().print("用户还没登录！<span style='color: #FF0000'>3秒</span>自动跳转到登录界面");
            response.setHeader("refresh", "3;url='"+request.getContextPath()+"/loginregister.jsp'");
        }else {
        //获取表单数据
        PrintWriter out=response.getWriter();
        String id=request.getParameter("id");
        System.out.print("购物车中得到的id为"+id);
        BookService bs=new BookService();
        try {
            Book b= bs.findBookById(id);
            System.out.print("购物车中通过id查询到的书籍为"+b);
         HttpSession session= request.getSession();
      Map<Book,Integer> car= (Map<Book, Integer>) session.getAttribute("car");
      int num=1;
      if (car==null){
          car=new HashMap<Book,Integer>();
      }else {

          if (car.containsKey(b)){
              num=car.get(b);
              num++;
          }
      }

      car.put(b,num);
      session.setAttribute("car",car);
      out.print("<a href='"+request.getContextPath()+"/index.jsp'>继续购物</a>,<a href='"+request.getContextPath()+"/bookcar.jsp'>查看购物车</a>");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
