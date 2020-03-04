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

import com.huang.pojo.Student;
import com.huang.service.StudentService;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("text/html;charset=utf-8");
		//获取操作符
		String oper = req.getParameter("oper");
		
		if("del".equals(oper)) {
			//调用删除处理方法
			delStu(req,resp);
		}else if("showAllStu".equals(oper)) {
			String showType = req.getParameter("showType");
			if ("sid".equals(showType)) {
				//调用查询所有学生信息处理方法BySid
				showAllStuBySid(req,resp);
			} else if("sname".equals(showType)){
				//调用查询所有学生信息处理方法BySname
				showAllStuBySname(req,resp);
			}else if("ssex".equals(showType)) {
				//调用查询所有学生信息处理方法BySsex
				showAllStuBySsex(req,resp);
			}else if("sbirth".equals(showType)) {
				//调用查询所有学生信息处理方法BySbirth
				showAllStuBySbirth(req,resp);
			}else if("sclass".equals(showType)) {
				//调用查询所有学生信息处理方法BySclass
				showAllStuBySclass(req,resp);
			}else {
				System.out.println("没找到对应操作符:"+showType);
			}
			
		}else if("addStu".equals(oper)) {
			//调用添加学生信息处理方法
			addStu(req,resp);
		}else if("selOneStu".equals(oper)) {
			//调用查找学生信息处理方法
			selOneStu(req,resp);
		}else if("updStu".equals(oper)) {
			//调用修改学生信息处理方法
			updStu(req,resp);
		}else if("selectStu".equals(oper)) {
			//查找指定学生
			selectStu(req,resp);
		}else {
			System.out.println("没找到对应操作符:"+oper);
		}
	}
	
	private void selectStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		List<Student> ls = studentService.selectStu(req.getParameter("sid"), req.getParameter("sname"), req.getParameter("sclass"));
		System.out.println(ls.size());
		if(ls.size()!=0) {
			for(Student s:ls) {
				System.out.println(s);
			}
//			req.setAttribute("tf", "t");
			req.setAttribute("stu", ls);
			System.out.println("***********");
			req.getRequestDispatcher("/student/selectStu.jsp").forward(req, resp);
			
		}else {
			System.out.println("没有数据");
			req.setAttribute("aaa", 1);
			req.getRequestDispatcher("/student/selectStu.jsp").forward(req, resp);
		}
		
	}

	private void showAllStuBySclass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		List<Student> ls = studentService.showAllStuBySclass();
		if(ls!=null) {
			req.setAttribute("ls", ls);
			req.getRequestDispatcher("/student/showAllStu.jsp").forward(req, resp);
		}
	}

	//BySbirth
	private void showAllStuBySbirth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		List<Student> ls = studentService.showAllStuBySbirth();
		if(ls!=null) {
			req.setAttribute("ls", ls);
			req.getRequestDispatcher("/student/showAllStu.jsp").forward(req, resp);
		}
	}


	//BySsex
	private void showAllStuBySsex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		List<Student> ls = studentService.showAllStuBySsex();
		if(ls!=null) {
			req.setAttribute("ls", ls);
			req.getRequestDispatcher("/student/showAllStu.jsp").forward(req, resp);
		}
	}

	//BySname
	private void showAllStuBySname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		List<Student> ls = studentService.showAllStuBySname();
		if(ls!=null) {
			req.setAttribute("ls", ls);
			req.getRequestDispatcher("/student/showAllStu.jsp").forward(req, resp);
		}
	}

	private void updStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		Student stu = new Student();
		stu.setSid(req.getParameter("sid"));
		stu.setSname((String)req.getParameter("sname"));
		stu.setSsex(req.getParameter("ssex"));
			String birth=(String)req.getParameter("sbirth");
			System.out.println(birth);
			String[] bs=null;
			if(birth!=""){
				bs=birth.split("/");
				birth=bs[2]+"-"+bs[0]+"-"+bs[1];
			}else{
				birth = "2000-01-01";
			}
		stu.setSbirth(birth);
		stu.setSclass(req.getParameter("sclass"));
		int u = studentService.updStu(stu, req.getParameter("oldSid"));
		if(u>0) {
			System.out.println("保存成功");
			req.getRequestDispatcher("/student/updSuccess.jsp").forward(req, resp);
		}else {
			System.out.println("保存失败");
		}
	}

	//查找学生信息用于修改
	private void selOneStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		
		String sid = req.getParameter("sid");
		Student s = studentService.selectOneStu(sid);
		req.setAttribute("stu", s);
		req.setAttribute("oldSid", s.getSid());
		req.getRequestDispatcher("/student/updStu.jsp").forward(req, resp);
	}


	//添加学生
	private void addStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		Student stu = new Student();
		stu.setSid(req.getParameter("sid"));
		stu.setSname(req.getParameter("sname"));
		stu.setSsex(req.getParameter("ssex"));
			String birth=(String)req.getParameter("sbirth");
			System.out.println(birth);
			String[] bs=null;
			if(birth!=""){
				bs=birth.split("/");
				birth=bs[2]+"-"+bs[0]+"-"+bs[1];
			}else{
				birth = "2000-01-01";
			}
		stu.setSbirth(birth);
		stu.setSclass(req.getParameter("sclass"));
		int addStu = studentService.addStu(stu);
		if(addStu>0) {
			System.out.println("成功");
			req.getRequestDispatcher("/student/addSuccess.jsp").forward(req, resp);
		}else {
			System.out.println("失败");
		}
		
	}

	//删除学生
	private void delStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		int delStu = studentService.delStu((String)req.getParameter("sid"));
		System.out.println(delStu);
		if(delStu>0) {
			System.out.println("成功");
			List<Student> ls = studentService.showAllStuBySid();
			if(ls!=null) {
				req.setAttribute("ls", ls);
				req.getRequestDispatcher("/student/showAllStu.jsp").forward(req, resp);
			}
		}else {
			System.out.println("失败");
			
		}
	}

	//查询所有学生信息BySid
	private void showAllStuBySid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		List<Student> ls = studentService.showAllStuBySid();
		if(ls!=null) {
			req.setAttribute("ls", ls);
			req.getRequestDispatcher("/student/showAllStu.jsp").forward(req, resp);
		}
	}

}
