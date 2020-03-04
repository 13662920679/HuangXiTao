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

import com.huang.pojo.Cclass;
import com.huang.service.ClassService;

/**
 * Servlet implementation class ClassServlet
 */
@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("text/html;charset=utf-8");
		//获取操作符
		String oper = req.getParameter("oper");
		
		if("showAllClass".equals(oper)) {
			String showType = req.getParameter("showType");
			if ("cid".equals(showType)) {
				
				showAllClassByCid(req,resp);
			}
		}else if("delClass".equals(oper)) {
			delClass(req,resp);
		}else if("updClass".equals(oper)) {
			updClass(req,resp);
		}else if("selOneClass".equals(oper)) {
			selOneClass(req,resp);
		}else {
			System.out.println("没找到对应操作符:"+oper);
		}
	}

	private void selOneClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassService classService = (ClassService)ctx.getBean("classService");
		String parameter = req.getParameter("cid");
		Cclass selectOneClass = classService.selectOneClass(parameter);
		req.setAttribute("class", selectOneClass);
		req.getRequestDispatcher("/class/updClass.jsp").forward(req, resp);
	}

	private void updClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassService classService = (ClassService)ctx.getBean("classService");
		String ctJ = req.getParameter("ctJava");
		String ctP = req.getParameter("ctPython");
		String ctC = req.getParameter("ctC");
		String cid = req.getParameter("cid");
		int updClass = classService.updClass(ctJ, ctP, ctC, cid);
		if(updClass>0) {
			System.out.println("修改班级成功");
			req.getRequestDispatcher("/class/updSuccess.jsp").forward(req, resp);
		}
		
	}

	private void delClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassService classService = (ClassService)ctx.getBean("classService");
		String parameter = req.getParameter("cid");
		int delClass = classService.delClass(parameter);
		System.out.println(delClass);
		if(delClass>0) {
			System.out.println("删除班级成功");
			List<Cclass> lc = classService.showAllClassByCid();
			req.setAttribute("lc", lc);
			req.setAttribute("del", "true");
			req.getRequestDispatcher("/class/showAllClass.jsp").forward(req, resp);
		}else {
			System.out.println("删除班级失败");
			List<Cclass> lc = classService.showAllClassByCid();
			req.setAttribute("lc", lc);
			req.setAttribute("del", "false");
			req.getRequestDispatcher("/class/showAllClass.jsp").forward(req, resp);
		}
	}

	private void showAllClassByCid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassService classService = (ClassService)ctx.getBean("classService");
		List<Cclass> lc = classService.showAllClassByCid();
		System.out.println(lc.size());
		if(lc.size()!=0) {
			for(Cclass c:lc) {
				System.out.println(c);
			}
			req.setAttribute("lc", lc);
			req.getRequestDispatcher("/class/showAllClass.jsp").forward(req, resp);
		}else {
			System.out.println("没有数据");
		}
	}

}
