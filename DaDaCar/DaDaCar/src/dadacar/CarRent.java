package dadacar;

import java.util.Scanner;

public class CarRent {
	 Car[] car=new Car[6];
	
	void initial() {
		car[0]=new personCar(1,"奥迪A4",500,4);
		car[1]=new personCar(2,"马自达6",400,4);
		car[2]=new pikaCar(3,"皮卡雪6",450,4,2);
		car[3]=new personCar(4,"金龙",800,20);
		car[4]=new goodsCar(5,"松花江",400,4);
		car[5]=new goodsCar(6,"依维柯",1000,20);
	}
	
	void showCar(){
		System.out.println("您可租车的类型及其价目表：");
		System.out.println("序号\t汽车名称\t租金\t容量");
		for(Car c:car)
			System.out.println(c);	
	}
	
	void getMoney(int day,int[] nums) {
		int money=0;
		for(int i=0;i<nums.length;i++) {
			money=car[nums[i]].money;
		}
		System.out.println("***租车价格："+(money*day)+"元");
	}
	
	void rentCar(int numble){
		int[] nums=new int[numble];
		for(int i=0;i<numble;i++) {
			System.out.println("请输入第"+(i+1)+"辆车的序号：");
			Scanner in2=new Scanner(System.in);
			nums[i]=(in2.nextInt()-1);
	
			System.out.println("请输入租车天数：");
			Scanner in3=new Scanner(System.in);
			int day=in3.nextInt();
		
			System.out.println("您的账单：");
			getMoney(day,nums);	
		}
	}

}
