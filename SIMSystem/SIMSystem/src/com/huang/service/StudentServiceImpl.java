package com.huang.service;

import java.util.List;

import com.huang.dao.StudentMapper;
import com.huang.dao.StudentMapperImpl;
import com.huang.dao.UserMapper;
import com.huang.pojo.Student;

public class StudentServiceImpl implements StudentService{
	
	//声明StudentMapper接口引用
	private StudentMapper studentMapper;

	

	public StudentMapper getStudentMapper() {
		return studentMapper;
	}

	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	
	@Override
	public List<Student> showAllStuBySid() {
		List<Student> ls = studentMapper.showAllStuBySid();
		return ls;
	}
	
	@Override
	public int delStu(String sid) {
		int d  = studentMapper.delStu(sid);
		return d;
	}

	@Override
	public int addStu(Student stu) {
		int a = studentMapper.addStu(stu);
		return a;
	}

	@Override
	public int updStu(Student stu, String sId) {
		int u = studentMapper.updStu(stu, sId);
		return u;
	}

	@Override
	public Student selectOneStu(String sid) {
		Student u = studentMapper.selectOneStu(sid);
		return u;
	}

	@Override
	public List<Student> showAllStuBySname() {
		List<Student> ls = studentMapper.showAllStuBySname();
		return ls;
	}

	@Override
	public List<Student> showAllStuBySsex() {
		List<Student> ls = studentMapper.showAllStuBySsex();
		return ls;
	}

	@Override
	public List<Student> showAllStuBySbirth() {
		List<Student> ls = studentMapper.showAllStuBySbirth();
		return ls;
	}

	@Override
	public List<Student> showAllStuBySclass() {
		List<Student> ls = studentMapper.showAllStuBySclass();
		return ls;
	}

	@Override
	public List<Student> selectStu(String sid, String sname, String sclass) {
		List<Student> ls = studentMapper.selectStu(sid, sname, sclass);
		return ls;
	}
	
	
	
	
	
}
