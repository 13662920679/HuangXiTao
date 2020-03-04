package com.huang.gamble;

import java.util.Scanner;

public class TestGamble {
	
	public static void main(String[] args) {
		
		Gamble g = new Gamble();
		
		boolean tof = true;
		
		while(tof) {
		System.out.println("***********************");
		System.out.println("Welcome to the gamble!");
		System.out.println("1.登陆    2.注册    3.退出");
		System.out.println("***********************");
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		LoginAndRegister lar = new LoginAndRegister();
		
		switch (str) {
		case "1":
			System.out.println("******登陆页面******");
			System.out.println("请输入您的账号：");
			String getUsername = scanner.nextLine();
			System.out.println("请输入您的密码：");
			String getPassword = scanner.nextLine();
			
			boolean loginTof = lar.login(getUsername, getPassword);//登陆成功返回true;失败返回false
			
			/*
			 * 若登陆成功，则调用该User对象
			 */
			
			User u = lar.user(lar.getNum());//返回一个User对象
			
			while(loginTof) {
	
					
				System.out.println("**************************************");
				System.out.println("1.开始赌博  2.查看余额  3.充值  4.退出登陆");
				System.out.println("**************************************");
				String str1 = scanner.nextLine();
				
				switch (str1) {
				case "1":
					g.StartGamble(u); 
					break;
					
				case "2":
					System.out.println("您的余额："+u.getMoney());
					break;
					
				case "3":
					System.out.println("充值:");
					int money = scanner.nextInt();
					u.setMoney(u.getMoney()+money);
					System.out.println("充值成功！");
					break;
					
				case "4":
					System.out.println("已退出登陆状态，回到主界面！");
					loginTof = false;
					break;

				default:
					System.out.println("您的输入有误，请重新输入！");
					break;
				}
				
			}
			
			break;
		
		case "2":
			System.out.println("******注册页面******");
			System.out.println("请设置您的账号：");
			String setUsername = scanner.nextLine();
			System.out.println("请设置您的密码：");
			String setPassword = scanner.nextLine();
			
			User user = new User();
			user.setUsername(setUsername);
			user.setPassword(setPassword);
			user.setMoney(100);
			
			lar.register(user);
			
			break;
			
		case "3":
			System.out.println("欢迎下次再来！！！");
			tof = false;
			break;

		default:
			System.out.println("您的输入有误，请重新输入！");
			break;
		}
		
		}
		
	}

}
