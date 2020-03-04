package com.huang.gamble;

import java.util.Random;
import java.util.Scanner;

/**
 * 摇骰子，猜大小
 * @author 13662
 *
 */

public class Gamble {
	
	
	
	public void StartGamble(User u) {
		System.out.println("***************");
		System.out.println("*摇骰子, 猜大小*");
		System.out.println("***************");
		System.out.println("游戏规则：1~3为小，4~6为大");
		System.out.println("赔率：2");
//		System.out.println("现在骰子已经摇好了");
//		int num = (int)(Math.random()*6 +1);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请问压大还是压小？d/x");
		String dx = scanner.nextLine();
		
		while(true) {
		System.out.println("请输入您压的金额：");
		
		int money = scanner.nextInt();
		if(money<=u.getMoney()) {
			System.out.println("现在骰子已经摇好了");
			int num = (int)(Math.random()*6 +1);
//		}
		
		System.out.println("骰子点数为："+num);
		
		if(num<=3) {
			if(dx.equals("x")) {
				System.out.println("恭喜你猜对了,获得了"+money+"金币");
				u.setMoney(u.getMoney()+money);
			}else {
				System.out.println("猜错,失去"+money+"金币");
				u.setMoney(u.getMoney()-money);
			}
		}else {
			if(dx.equals("d")) {
				System.out.println("恭喜你猜对了,获得了"+money+"金币");
				u.setMoney(u.getMoney()+money);
			}else {
				System.out.println("猜错,失去"+money+"金币");
				u.setMoney(u.getMoney()-money);
			}
		}
		break;
		}else {
			System.out.println("余额不足，您的余额为："+u.getMoney());
			System.out.println("请重新输入！！！");
		}
		}
		
	}

}
