package com.huang.gamble;

import java.util.ArrayList;

public class LoginAndRegister implements Login,Register{
	
	public static ArrayList<User> array = new ArrayList<User>();//用于存放成功注册的User
	
	/****************/
	public int num = -1;
	public int getNum() {
		return num;
	}
	public User user(int num) {
		return array.get(num);
	}
	/*******************/
	
	public void register(User user) {
		boolean flag = true; 
		
		for(User u:array) {
			if(user.getUsername().equals(u.getUsername())) {
				System.out.println("该账号已被使用");
				flag = false;
				break;
			}else {
				flag = true;
			}
		}
		
		if(flag==true) {
			array.add(user);
			System.out.println("注册成功");
		}
		
		if(flag==false) {
			System.out.println("注册失败");
		}
		
		
	}

	public boolean login(String username, String password) {
		boolean loginTof = false;
		
		
		for(User u:array) {
			num++;
			if(username.equals(u.getUsername())&&password.equals(u.getPassword())) {
				System.out.println("登录成功");
				loginTof = true;
				break;
			}
		}
		
		if(loginTof==false) {
			System.out.println("登陆失败");
		}
		
		return loginTof;
	}
	
	

}
