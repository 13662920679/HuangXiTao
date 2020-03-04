package com.huang.dao;

import org.apache.ibatis.annotations.Param;

import com.huang.pojo.User;

public interface UserMapper {
	
	public User  loginDao(@Param("uid")String uid,@Param("upwd")String upwd);
	
	public int regDao(User user);
	
	public int changePwdDao(@Param("upwd")String upwd,@Param("uid")String uid);

}
