package com.huang.gamble;

import java.util.Random;
import java.util.Scanner;

/**
 * ҡ���ӣ��´�С
 * @author 13662
 *
 */

public class Gamble {
	
	
	
	public void StartGamble(User u) {
		System.out.println("***************");
		System.out.println("*ҡ����, �´�С*");
		System.out.println("***************");
		System.out.println("��Ϸ����1~3ΪС��4~6Ϊ��");
		System.out.println("���ʣ�2");
//		System.out.println("���������Ѿ�ҡ����");
//		int num = (int)(Math.random()*6 +1);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("����ѹ����ѹС��d/x");
		String dx = scanner.nextLine();
		
		while(true) {
		System.out.println("��������ѹ�Ľ�");
		
		int money = scanner.nextInt();
		if(money<=u.getMoney()) {
			System.out.println("���������Ѿ�ҡ����");
			int num = (int)(Math.random()*6 +1);
//		}
		
		System.out.println("���ӵ���Ϊ��"+num);
		
		if(num<=3) {
			if(dx.equals("x")) {
				System.out.println("��ϲ��¶���,�����"+money+"���");
				u.setMoney(u.getMoney()+money);
			}else {
				System.out.println("�´�,ʧȥ"+money+"���");
				u.setMoney(u.getMoney()-money);
			}
		}else {
			if(dx.equals("d")) {
				System.out.println("��ϲ��¶���,�����"+money+"���");
				u.setMoney(u.getMoney()+money);
			}else {
				System.out.println("�´�,ʧȥ"+money+"���");
				u.setMoney(u.getMoney()-money);
			}
		}
		break;
		}else {
			System.out.println("���㣬�������Ϊ��"+u.getMoney());
			System.out.println("���������룡����");
		}
		}
		
	}

}
