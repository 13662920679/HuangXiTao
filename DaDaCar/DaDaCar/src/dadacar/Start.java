package dadacar;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			
		System.out.println("��ӭʹ�ô���⳵ϵͳ��"); 
		System.out.println("���Ƿ�Ҫ�⳵��1�� 0��");
		Scanner input=new Scanner(System.in);
		if(input.nextInt()==1) {
			CarRent cr=new CarRent();
			cr.initial();
			cr.showCar();
			System.out.println("��������Ҫ��������������");
			Scanner in1=new Scanner(System.in);
			cr.rentCar(in1.nextInt());
		}
		System.out.println("ллʹ�ã�");
		}
	
	}
}
