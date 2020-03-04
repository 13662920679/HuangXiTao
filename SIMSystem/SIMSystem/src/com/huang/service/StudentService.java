package com.huang.service;

import java.util.List;

import com.huang.pojo.Student;

public interface StudentService {
	
	public List<Student> showAllStuBySid();
	
	public int delStu(String sid);
	
	public int addStu(Student stu);
	
	public int updStu(Student stu,String sId);
	
	public Student selectOneStu(String sid);
	
	public List<Student> showAllStuBySname();
	public List<Student> showAllStuBySsex();
	public List<Student> showAllStuBySbirth();
	public List<Student> showAllStuBySclass();
	
	public List<Student> selectStu(String sid,String sname,String sclass);
	
	
}
