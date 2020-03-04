package com.huang.test;

import java.util.Scanner;

import com.huang.dao.UserDao;
import com.huang.dao.impl.UserDaoImpl;
import com.huang.entity.User;
import com.huang.game.GuessNumberGame;

public class UserTest {
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("------��ӭ����------");
			System.out.println("��ѡ��");
			System.out.println("1  ��½");
			System.out.println("2  ע��");
			System.out.println("3  �˳�");
			
			Scanner sc = new Scanner(System.in);
			
			//Ϊ�˷������ݵ�¼��,������String���ͽ���
			String choiceString = sc.nextLine();
			
			UserDao ud = new UserDaoImpl();
			
			switch(choiceString) {
				case "1":
					System.out.println("------------��½����--------------");
	                System.out.println("�������û���:");
	                String username = sc.nextLine() ;
	                System.out.println("������������:");
	                String password = sc.nextLine() ;
	                
	                //UserDao ud = new UserDaoImpl();
	                boolean flag = ud.isLogin(username, password);
	                if(flag) {
	                	System.out.println("��½�ɹ�,��ʼ����Ϸ��?y/n");
	                	while(true) {
	                		String yn = sc.nextLine();
	                		if(yn.equalsIgnoreCase("y")) {
	                			GuessNumberGame.start();
	                			System.out.println("�㻹����?y/n");
	                		}else {
	                			break;
	                		}
	                	}
	                	System.out.println("ллʹ��,�´�����...");
	                }else {
	                	System.out.println("�û��������������,����������....");
	                }
	                break;
	                
				case "2":
					System.out.println("------------ע�����--------------");
	                System.out.println("���������û���:");
	                String newUserName = sc.nextLine() ;
	                System.out.println("������������:");
	                String newPassword = sc.nextLine() ;
	                
	                User u = new User() ;
	                u.setUsername(newUserName) ;
	                u.setPassword(newPassword) ;
	                
	                ud.regist(u);
	                System.out.println("ע��ɹ�...");
	                break;
	                
				case "3":
					System.out.println("��ӭ�´�������");
					System.exit(0);
					break;
					
				default:
					System.out.println("���������������������");
					
			}
			
		}
		
	}

}
