package com.tarena.shoot;
import java.awt.image.*;
import java.util.Random;

//英雄机：飞行物
public class Hero extends FlyingObject {
	
	private int life;
	private int doubleFire;
	
	private BufferedImage[] images;//图片数组
	private int index;//协助图片切换
	
	public Hero() {
		image = ShootGame.hero0;
		width = image.getWidth();
		height = image.getHeight();
		x = 150;//初始坐标x
		y = 400;//初始坐标y
		
		life = 3;//初始生命值
		doubleFire = 0;//活力值为零，即单倍活力
		
		images = new BufferedImage[] {ShootGame.hero0,ShootGame.hero1};
		index = 0;
	}
	
	/** 重写走步 */
	public void step() {//切图片
		//step()方法被调用10次，换一次图片
		//100毫秒切一次图片
		image = images[index++/10%images.length];
		
		/**
			index++;
			int a = index/10;
			int b = a%2;
			image = images[b];
		 */
	}
	
	/** 子弹发射 */
	public Bullet[] shoot() {
		int xStep = this.width/4;
		int yStep = 20;
		if(doubleFire>0) {//双倍火力
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x+1*xStep,this.y-yStep);
			bs[1] = new Bullet(this.x+3*xStep, this.y-yStep);
			doubleFire -= 2;
			return bs;
		}else {//单倍火力
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x+2*xStep, this.y-yStep);
			return bs;
		}
	}
	
	/** 移动 x:鼠标的x坐标  y:鼠标的y坐标 */
	public void moveTo(int x,int y) {
		this.x = x-this.width/2;
		this.y = y-this.height/2;
	}
	
	public boolean outOfBounds() {
		return false;
	}
	
	/** 英雄机增命 */
	public void addLife() {
		life++;
	}
	
	/** 获取命 */
	public int getLife() {
		return life;
	}
	
	/** 减命 */
	public void subtractLife() {
		life--;
	}
	
	/** 英雄机增火力 */
	public void addDoubleFire() {
		doubleFire+=40;//火力值加40
	}
	
	/** 清空火力 */
	public void  clearDoubleFire() {
		doubleFire = 0;
	}
	
	/** 英雄机撞敌人 */
	public boolean hit(FlyingObject obj) {
		int x1 = obj.x-this.width/2;
		int x2 = obj.x+obj.width+this.width/2;
		int y1 = obj.y-this.height/2;
		int y2 = obj.y+obj.height+this.height/2;
		
		//英雄机中心点
		int x = this.x+this.width/2;
		int y = this.y+this.height/2;
		
		return x>x1 && x<x2
				&&
			   y>y1 && y<y2;
	}


}
