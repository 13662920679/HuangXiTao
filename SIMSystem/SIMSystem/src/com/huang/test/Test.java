package com.huang.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huang.pojo.Cclass;
import com.huang.pojo.Student;
import com.huang.pojo.Teacher;
import com.huang.pojo.User;
import com.huang.service.ClassService;
import com.huang.service.StudentService;
import com.huang.service.TeacherService;
import com.huang.service.UserService;
import com.huang.servlet.TeacherServlet;

class Test {

	@org.junit.jupiter.api.Test
	public void test01() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		User u = userService.loginService("100001", "123456");
		System.out.println(u);
	}
	
	@org.junit.jupiter.api.Test
	public void test02() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		List<Student> ls = studentService.showAllStuBySid();
		for(Student s:ls) {
			System.out.println(s);
		}
	}
	
	@org.junit.jupiter.api.Test
	public void test03() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		String sid = "123";
		int d = studentService.delStu(sid);
		System.out.println("删除"+d+"条数据");
	}
	
	@org.junit.jupiter.api.Test
	public void addTest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		Student stu = new Student();
		stu.setSid("666");
		stu.setSname("999");
		stu.setSsex("0");
		stu.setSbirth("2018-12-18");
		stu.setSclass("3");
		int a = studentService.addStu(stu);
		System.out.println("添加"+a+"条数据");
	}
	
	@org.junit.jupiter.api.Test
	public void selectStu() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		List<Student> ls = studentService.selectStu("0101", "黄", null);
		System.out.println(ls.size());
		if(ls.size()!=0) {
			for(Student s:ls) {
				System.out.println(s);
			}
		}else {
			System.out.println("没有数据");
		}
		
		
	}
	
	@org.junit.jupiter.api.Test
	public void showAllClassByCid() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassService classService = (ClassService)ctx.getBean("classService");
		List<Cclass> lc = classService.showAllClassByCid();
		System.out.println(lc.size());
		if(lc.size()!=0) {
			for(Cclass c:lc) {
				System.out.println(c);
			}
		}else {
			System.out.println("没有数据");
		}
	}
	
	@org.junit.jupiter.api.Test
	public void delClass() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassService classService = (ClassService)ctx.getBean("classService");
		int delClass = classService.delClass("3");
		System.out.println(delClass);
	}
	
	@org.junit.jupiter.api.Test
	public void selectOneClass() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassService classService = (ClassService)ctx.getBean("classService");
		Cclass selectOneClass = classService.selectOneClass("3");
		System.out.println(selectOneClass);
	}
	
	@org.junit.jupiter.api.Test
	public void showAllTeacher() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherService teacherService  = (TeacherService)ctx.getBean("teacherService");
		List<Teacher> lt = teacherService.showAllTeacher();
		System.out.println(lt.size());
		if(lt.size()!=0) {
			for(Teacher t:lt) {
				System.out.println(t);
			}
		}else {
			System.out.println("没有数据");
		}
		
	}
	
}
