package dadacar;

import java.util.Scanner;

public class CarRent {
	 Car[] car=new Car[6];
	
	void initial() {
		car[0]=new personCar(1,"�µ�A4",500,4);
		car[1]=new personCar(2,"���Դ�6",400,4);
		car[2]=new pikaCar(3,"Ƥ��ѩ6",450,4,2);
		car[3]=new personCar(4,"����",800,20);
		car[4]=new goodsCar(5,"�ɻ���",400,4);
		car[5]=new goodsCar(6,"��ά��",1000,20);
	}
	
	void showCar(){
		System.out.println("�����⳵�����ͼ����Ŀ��");
		System.out.println("���\t��������\t���\t����");
		for(Car c:car)
			System.out.println(c);	
	}
	
	void getMoney(int day,int[] nums) {
		int money=0;
		for(int i=0;i<nums.length;i++) {
			money=car[nums[i]].money;
		}
		System.out.println("***�⳵�۸�"+(money*day)+"Ԫ");
	}
	
	void rentCar(int numble){
		int[] nums=new int[numble];
		for(int i=0;i<numble;i++) {
			System.out.println("�������"+(i+1)+"��������ţ�");
			Scanner in2=new Scanner(System.in);
			nums[i]=(in2.nextInt()-1);
	
			System.out.println("�������⳵������");
			Scanner in3=new Scanner(System.in);
			int day=in3.nextInt();
		
			System.out.println("�����˵���");
			getMoney(day,nums);	
		}
	}

}
