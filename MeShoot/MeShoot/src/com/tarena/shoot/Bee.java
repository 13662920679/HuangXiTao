package com.tarena.shoot;

import java.util.Random;

//蜜蜂：飞行物+奖励
public class Bee extends FlyingObject implements Award{
	
	private int xSpeed = 1;  //步幅
	private int ySpeed = 2;
	
	private int awardType;//奖励类型(0/1)
	
	/** 初始化实例变量 */
	public Bee() {
		image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH-this.width+1);
		y = -this.height;
		awardType = rand.nextInt(2);//0-1之间的随机整数
	}
	
	/** 获取奖励 */
	public int getType() {
		return awardType;
	}
	
	/** 重写走步 */
	public void step() {
		x+=xSpeed;
		y+=ySpeed;
		if(x>=ShootGame.WIDTH-this.width) {
			xSpeed =-1;
		}
		if(x<=0) {
			xSpeed = 1;  
		}
		
	}
	
	public boolean outOfBounds() {
		return this.y>=ShootGame.HEIGHT;
	}


}
