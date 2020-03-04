package com.huang.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.huang.pojo.Student;

public class StudentMapperImpl implements StudentMapper{
	
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Student> showAllStuBySid() {
		List<Student> ls = sqlSession.getMapper(StudentMapper.class).showAllStuBySid();
		return ls;
	}

	@Override
	public int delStu(String sid) {
		int d = sqlSession.getMapper(StudentMapper.class).delStu(sid);
		return d;
	}

	@Override
	public int addStu(Student stu) {
		int a = sqlSession.getMapper(StudentMapper.class).addStu(stu);
		return a;
	}

	@Override
	public int updStu(Student stu,String sId) {
		int u = sqlSession.getMapper(StudentMapper.class).updStu(stu,sId);
		return u;
	}

	@Override
	public Student selectOneStu(String sid) {
		Student s = sqlSession.getMapper(StudentMapper.class).selectOneStu(sid);
		return s;
	}

	@Override
	public List<Student> showAllStuBySname() {
		List<Student> ls = sqlSession.getMapper(StudentMapper.class).showAllStuBySname();
		return ls;
	}

	@Override
	public List<Student> showAllStuBySsex() {
		List<Student> ls = sqlSession.getMapper(StudentMapper.class).showAllStuBySsex();
		return ls;
	}

	@Override
	public List<Student> showAllStuBySbirth() {
		List<Student> ls = sqlSession.getMapper(StudentMapper.class).showAllStuBySbirth();
		return ls;
	}

	@Override
	public List<Student> showAllStuBySclass() {
		List<Student> ls = sqlSession.getMapper(StudentMapper.class).showAllStuBySclass();
		return ls;
	}

	@Override
	public List<Student> selectStu(String sid, String sname, String scalss) {
		List<Student> ls = sqlSession.getMapper(StudentMapper.class).selectStu(sid, sname, scalss);
		return ls;
	}
	
}
