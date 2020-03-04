package com.huang.gamble;

import java.util.Scanner;

public class TestGamble {
	
	public static void main(String[] args) {
		
		Gamble g = new Gamble();
		
		boolean tof = true;
		
		while(tof) {
		System.out.println("***********************");
		System.out.println("Welcome to the gamble!");
		System.out.println("1.��½    2.ע��    3.�˳�");
		System.out.println("***********************");
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		LoginAndRegister lar = new LoginAndRegister();
		
		switch (str) {
		case "1":
			System.out.println("******��½ҳ��******");
			System.out.println("�����������˺ţ�");
			String getUsername = scanner.nextLine();
			System.out.println("�������������룺");
			String getPassword = scanner.nextLine();
			
			boolean loginTof = lar.login(getUsername, getPassword);//��½�ɹ�����true;ʧ�ܷ���false
			
			/*
			 * ����½�ɹ�������ø�User����
			 */
			
			User u = lar.user(lar.getNum());//����һ��User����
			
			while(loginTof) {
	
					
				System.out.println("**************************************");
				System.out.println("1.��ʼ�Ĳ�  2.�鿴���  3.��ֵ  4.�˳���½");
				System.out.println("**************************************");
				String str1 = scanner.nextLine();
				
				switch (str1) {
				case "1":
					g.StartGamble(u); 
					break;
					
				case "2":
					System.out.println("������"+u.getMoney());
					break;
					
				case "3":
					System.out.println("��ֵ:");
					int money = scanner.nextInt();
					u.setMoney(u.getMoney()+money);
					System.out.println("��ֵ�ɹ���");
					break;
					
				case "4":
					System.out.println("���˳���½״̬���ص������棡");
					loginTof = false;
					break;

				default:
					System.out.println("���������������������룡");
					break;
				}
				
			}
			
			break;
		
		case "2":
			System.out.println("******ע��ҳ��******");
			System.out.println("�����������˺ţ�");
			String setUsername = scanner.nextLine();
			System.out.println("�������������룺");
			String setPassword = scanner.nextLine();
			
			User user = new User();
			user.setUsername(setUsername);
			user.setPassword(setPassword);
			user.setMoney(100);
			
			lar.register(user);
			
			break;
			
		case "3":
			System.out.println("��ӭ�´�����������");
			tof = false;
			break;

		default:
			System.out.println("���������������������룡");
			break;
		}
		
		}
		
	}

}
