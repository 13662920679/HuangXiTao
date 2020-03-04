package com.huang.test;

import java.util.Scanner;

import com.huang.dao.UserDao;
import com.huang.dao.impl.UserDaoImpl;
import com.huang.entity.User;
import com.huang.game.GuessNumberGame;

public class UserTest {
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("------欢迎光临------");
			System.out.println("请选择：");
			System.out.println("1  登陆");
			System.out.println("2  注册");
			System.out.println("3  退出");
			
			Scanner sc = new Scanner(System.in);
			
			//为了方便数据的录入,就是用String类型接收
			String choiceString = sc.nextLine();
			
			UserDao ud = new UserDaoImpl();
			
			switch(choiceString) {
				case "1":
					System.out.println("------------登陆界面--------------");
	                System.out.println("请输入用户名:");
	                String username = sc.nextLine() ;
	                System.out.println("请您输入密码:");
	                String password = sc.nextLine() ;
	                
	                //UserDao ud = new UserDaoImpl();
	                boolean flag = ud.isLogin(username, password);
	                if(flag) {
	                	System.out.println("登陆成功,开始玩游戏吗?y/n");
	                	while(true) {
	                		String yn = sc.nextLine();
	                		if(yn.equalsIgnoreCase("y")) {
	                			GuessNumberGame.start();
	                			System.out.println("你还玩吗?y/n");
	                		}else {
	                			break;
	                		}
	                	}
	                	System.out.println("谢谢使用,下次再来...");
	                }else {
	                	System.out.println("用户名或者密码错误,请重新输入....");
	                }
	                break;
	                
				case "2":
					System.out.println("------------注册界面--------------");
	                System.out.println("请您输入用户名:");
	                String newUserName = sc.nextLine() ;
	                System.out.println("请您输入密码:");
	                String newPassword = sc.nextLine() ;
	                
	                User u = new User() ;
	                u.setUsername(newUserName) ;
	                u.setPassword(newPassword) ;
	                
	                ud.regist(u);
	                System.out.println("注册成功...");
	                break;
	                
				case "3":
					System.out.println("欢迎下次再来！");
					System.exit(0);
					break;
					
				default:
					System.out.println("你的输入有误，请重新输入");
					
			}
			
		}
		
	}

}
