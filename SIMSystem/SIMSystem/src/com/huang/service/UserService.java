package com.huang.service;

import com.huang.pojo.User;

public interface UserService {
	
	public User loginService(String uid,String upwd);
	
	public int regService(User user);
	
	public int changePwdService(String upwd,String uid);
	
}
