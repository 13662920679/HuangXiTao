package com.huang.game;

import java.util.Scanner;

public class GuessNumberGame {
	
	// �޲ι���˽��
    private GuessNumberGame() {
    }

    //��̬����
    public static void start(){
    	
    	System.out.println("***��Ϸ��ʼ***");
    	System.out.println("ϵͳ�����������һ��1~100������");
    	System.out.println("��������ȳ��������");
    	
        //����һ�������
        int number = (int) (Math.random()*100 +1) ;

        //����һ��ͳ�Ʊ���
        int count = 0 ;
        //���ѭ��
        while(true){
            //��������¼�����
            Scanner sc = new Scanner(System.in) ;
            System.out.println("��������һ����:");
            int guessNumber = sc.nextInt() ;

            //ͳ�Ʊ���++
            count ++ ;

            if(guessNumber>number){
                System.out.println("��Ҫ�µ�����"+guessNumber+"����");

            }else if(guessNumber <number){
                System.out.println("��Ҫ�µ�����"+guessNumber+"С��");
            }else{
                System.out.println("��ϲ��"+count+"�β�����");
                break ;
            }
        }


    }

}
