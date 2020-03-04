package com.huang.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.huang.pojo.Student;
import com.huang.pojo.User;
import com.huang.service.StudentService;
import com.huang.service.StudentServiceImpl;
import com.huang.service.UserService;
import com.huang.service.UserServiceImpl;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	private UserService us = new UserServiceImpl();
//	private StudentService ss = new StudentServiceImpl();
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("text/html;charset=utf-8");
		//获取操作符
		String oper = req.getParameter("oper");
		
		if("login".equals(oper)) {
			//调用登录处理方法
			cheakUserLogin(req,resp);
		}else if("reg".equals(oper)) {
			//调用注册处理方法
			userReg(req,resp);
		}else if("out".equals(oper)) {
			//调用退出处理方法
			userOut(req,resp);
		}else if("pwd".equals(oper)) {
			//调用修改密码处理方法
			userChangePwd(req,resp);
		}else {
			System.out.println("没找到对应操作符:"+oper);
		}
	}


	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取数据
		String newPwd = req.getParameter("newPwd");
		//从session中获取对象信息
		User u = (User)req.getSession().getAttribute("user");
		String uid = u.getUid();
	//处理数据
		//调用service处理
		int index = us.changePwdService(newPwd, uid);
		if(index>0) {
			HttpSession hs = req.getSession();
			hs.setAttribute("pwd", "true");
			//重定向
			resp.sendRedirect("/SIMSystem/login.jsp");
		}
		
	}




	//注册
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user = new User();
		user.setUid(req.getParameter("uid"));
		user.setUname(req.getParameter("uname"));
		user.setUpwd(req.getParameter("upwd"));
		
		
		
		

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		us = (UserService)ctx.getBean("userService");
		int r = us.regService(user);
		if(r>0) {
			//获取session
			HttpSession hs=req.getSession();
			hs.setAttribute("reg", "true");
			//重定向
			resp.sendRedirect("/SIMSystem/login.jsp");
		}
		
	}



	//退出
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session对象
		HttpSession hs = req.getSession();
		//强制销毁session
		hs.invalidate();
		//重定向
		resp.sendRedirect("/SIMSystem/login.jsp");
	}

	//登录
	private void cheakUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//获取请求信息
			String uid = req.getParameter("uid");
			String upwd = req.getParameter("upwd");
			System.out.println(uid+"&"+upwd);
		//处理请求信息
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			us = (UserService)ctx.getBean("userService");
			//调用登录处理的service方法
			User u = us.loginService(uid, upwd);
		//响应处理结果
			if(u!=null) {
				System.out.println(u);
				//获取session对象
				HttpSession hs = req.getSession();
				//将用户数据存储到session
				hs.setAttribute("user", u);
				//重定向
				resp.sendRedirect("/SIMSystem/main/main.jsp");
				return;
			}else {
				req.setAttribute("flag", 0);
				//请求转发
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			//直接响应
			//请求转发
		
	}

}
