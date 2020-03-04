package com.huang.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.huang.pojo.User;

public class UserMapperImpl implements UserMapper{
	
	private SqlSessionTemplate sqlSession;

	@Override
	public User loginDao(String uid, String upwd) {
		User u = sqlSession.getMapper(UserMapper.class).loginDao(uid, upwd);
		return u;
	}
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int regDao(User user) {
		int r = sqlSession.getMapper(UserMapper.class).regDao(user);
		return r;
	}

	@Override
	public int changePwdDao(String upwd, String uid) {
		int c = sqlSession.getMapper(UserMapper.class).changePwdDao(upwd, uid);
		return c;
	}
	
	
	
}
