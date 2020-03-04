package com.tarena.shoot;

import java.util.Random;

//敌机：飞行物+敌人
public class Airplane extends FlyingObject implements Enemy{
	
	private int speed = 2; //移动的步幅
	
	/** 初始化实例变量 */
	public Airplane() {
		image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH-this.width+1);
		y = -this.height;
	}
	
	//  *必须*重写接口的方法
	/** 获取分数5 */
	public int getScore() {
		return 5;
	}
	
	/** 重写走步 */
	public void step() {
		y+=speed;
	}
	
	public boolean outOfBounds() {
		return this.y>=ShootGame.HEIGHT;
	}

}
