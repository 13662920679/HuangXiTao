package com.huang.service;

import com.huang.dao.UserMapper;
import com.huang.pojo.User;

public class UserServiceImpl implements UserService{
	
	//声明UserMapper接口引用
	private UserMapper userMapper;
	
	@Override
	public User loginService(String uid, String upwd) {
		return userMapper.loginDao(uid, upwd);
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int regService(User user) {
		
		return userMapper.regDao(user);
	}

	@Override
	public int changePwdService(String upwd, String uid) {
		// TODO Auto-generated method stub
		return userMapper.changePwdDao(upwd, uid);
	}
	
}
