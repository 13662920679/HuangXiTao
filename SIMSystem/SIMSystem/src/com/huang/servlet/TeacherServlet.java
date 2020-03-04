package com.huang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huang.pojo.Teacher;
import com.huang.service.TeacherService;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
				req.setCharacterEncoding("utf-8");
				//设置响应编码格式
				resp.setCharacterEncoding("text/html;charset=utf-8");
				//获取操作符
				String oper = req.getParameter("oper");
				
				if("showAllTeacher".equals(oper)) {
					showAllTeacher(req,resp);
				}else {
					System.out.println("没找到对应操作符:"+oper);
				}
	}

	private void showAllTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherService teacherService  = (TeacherService)ctx.getBean("teacherService");
		List<Teacher> lt = teacherService.showAllTeacher();
		System.out.println(lt.size());
		if(lt.size()!=0) {
			for(Teacher t:lt) {
				System.out.println(t);
			}
			req.setAttribute("lt", lt);
			req.getRequestDispatcher("/teacher/showAllTeacher.jsp").forward(req, resp);
		}else {
			System.out.println("没有数据");
		}
	}

}
