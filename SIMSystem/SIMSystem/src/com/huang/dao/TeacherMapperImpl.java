package com.huang.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.huang.pojo.Teacher;

public class TeacherMapperImpl implements TeacherMapper{
	
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public List<Teacher> showAllTeacher() {
		List<Teacher> showAllTeacher = sqlSession.getMapper(TeacherMapper.class).showAllTeacher();
		return showAllTeacher;
	}
	
}
