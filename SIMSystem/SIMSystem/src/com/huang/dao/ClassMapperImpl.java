package com.huang.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.huang.pojo.Cclass;

public class ClassMapperImpl implements ClassMapper{
	
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Cclass> showAllClassByCid() {
		List<Cclass> lc = sqlSession.getMapper(ClassMapper.class).showAllClassByCid();
		return lc;
	}

	@Override
	public int delClass(String cid) {
		int delClass = sqlSession.getMapper(ClassMapper.class).delClass(cid);
		return delClass;
	}

	@Override
	public List<Cclass> selectClass(String cid) {
		List<Cclass> lc = sqlSession.getMapper(ClassMapper.class).selectClass(cid);
		return lc;
	}

	@Override
	public Cclass selectOneClass(String cid) {
		Cclass c = sqlSession.getMapper(ClassMapper.class).selectOneClass(cid);
		return c;
	}

	@Override
	public int updClass(String ctJava, String ctPython, String ctC, String cid) {
		int updClass = sqlSession.getMapper(ClassMapper.class).updClass(ctJava, ctPython, ctC, cid);
		return updClass;
	}

	
	
}
