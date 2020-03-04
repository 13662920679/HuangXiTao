package com.huang.dao.impl;

import java.util.ArrayList;

import com.huang.dao.UserDao;
import com.huang.entity.User;

public class UserDaoImpl implements UserDao{
	
	private static ArrayList<User> array = new ArrayList<User>() ;

	@Override
	public boolean isLogin(String username, String password) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		
		for(User u:array) {
			if(u.getUsername().equals(username)&&u.getPassword().equals(password)) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		array.add(user);
	}

	
}
