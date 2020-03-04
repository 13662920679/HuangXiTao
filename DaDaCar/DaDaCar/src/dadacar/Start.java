package dadacar;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			
		System.out.println("欢迎使用答答租车系统："); 
		System.out.println("您是否要租车：1是 0否");
		Scanner input=new Scanner(System.in);
		if(input.nextInt()==1) {
			CarRent cr=new CarRent();
			cr.initial();
			cr.showCar();
			System.out.println("请输入您要租汽车的数量：");
			Scanner in1=new Scanner(System.in);
			cr.rentCar(in1.nextInt());
		}
		System.out.println("谢谢使用！");
		}
	
	}
}
