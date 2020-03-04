package com.huang.dao;

import com.huang.entity.*;

public interface UserDao {
	
	//µÇÂ½µÄ
	public abstract boolean isLogin(String username,String password);
	
	//×¢²áµÄ
	public abstract void regist(User user);
}
