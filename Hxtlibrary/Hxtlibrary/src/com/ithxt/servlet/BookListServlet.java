package com.ithxt.servlet;

import com.ithxt.domain.Book;
import com.ithxt.service.BookService;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;


public class BookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //获取表单数据
      String category= request.getParameter("category");
      System.out.print("获取到的数据为"+category);
        BookService bs=new BookService();
        try {
            List<Book> list= bs.findAllBook(category);
            //将查询到的图书信息集合放到request作用域中
            request.setAttribute("book",list);
            //分发转向
            request.getRequestDispatcher("/booklist.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
