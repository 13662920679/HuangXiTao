package com.huang.gamble;

import java.util.ArrayList;

public class LoginAndRegister implements Login,Register{
	
	public static ArrayList<User> array = new ArrayList<User>();//���ڴ�ųɹ�ע���User
	
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
				System.out.println("���˺��ѱ�ʹ��");
				flag = false;
				break;
			}else {
				flag = true;
			}
		}
		
		if(flag==true) {
			array.add(user);
			System.out.println("ע��ɹ�");
		}
		
		if(flag==false) {
			System.out.println("ע��ʧ��");
		}
		
		
	}

	public boolean login(String username, String password) {
		boolean loginTof = false;
		
		
		for(User u:array) {
			num++;
			if(username.equals(u.getUsername())&&password.equals(u.getPassword())) {
				System.out.println("��¼�ɹ�");
				loginTof = true;
				break;
			}
		}
		
		if(loginTof==false) {
			System.out.println("��½ʧ��");
		}
		
		return loginTof;
	}
	
	

}
