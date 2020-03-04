package com.huang.game;

import java.util.Scanner;

public class GuessNumberGame {
	
	// 无参构造私有
    private GuessNumberGame() {
    }

    //静态功能
    public static void start(){
    	
    	System.out.println("***游戏开始***");
    	System.out.println("系统将会随机生成一个1~100的整数");
    	System.out.println("现在请你踩出这个整数");
    	
        //产生一个随机数
        int number = (int) (Math.random()*100 +1) ;

        //定义一个统计变量
        int count = 0 ;
        //多次循环
        while(true){
            //创建键盘录入对象
            Scanner sc = new Scanner(System.in) ;
            System.out.println("请你输入一个数:");
            int guessNumber = sc.nextInt() ;

            //统计变量++
            count ++ ;

            if(guessNumber>number){
                System.out.println("你要猜的数据"+guessNumber+"大了");

            }else if(guessNumber <number){
                System.out.println("你要猜的数据"+guessNumber+"小了");
            }else{
                System.out.println("恭喜您"+count+"次猜中了");
                break ;
            }
        }


    }

}
