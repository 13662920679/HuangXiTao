package com.huang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huang.pojo.Student;

public interface StudentMapper {
	
	public List<Student> showAllStuBySid();
	
	public int delStu(@Param("sid")String sid);
	
	public int addStu(Student stu);
	
	public int updStu(@Param("s")Student stu,@Param("sId")String sId);
	
	public Student selectOneStu(@Param("sid")String sid);
	
	public List<Student> showAllStuBySname();
	public List<Student> showAllStuBySsex();
	public List<Student> showAllStuBySbirth();
	public List<Student> showAllStuBySclass();
	
	public List<Student> selectStu(@Param("sid")String sid,@Param("sname")String sname,@Param("sclass")String scalss);
	
}
