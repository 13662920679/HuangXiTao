package com.huang.dao;

import com.huang.entity.*;

public interface UserDao {
	
	//��½��
	public abstract boolean isLogin(String username,String password);
	
	//ע���
	public abstract void regist(User user);
}
