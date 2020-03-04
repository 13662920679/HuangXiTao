package com.tarena.shoot;

import java.util.Random;

//子弹:飞行物
public class Bullet extends FlyingObject {
	
	private int speed = 3;//步幅
	
	/** 初始化实例变量 */
	//子弹的x，y根据英雄机的位置决定的
	public Bullet(int x,int y) {
		image = ShootGame.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;
		this.y = y;
		
	}
	
	/** 重写走步 */
	public void step() {
		y-=speed;
	}
	
	public boolean outOfBounds() {
		return this.y<=-this.height;
	}


}
