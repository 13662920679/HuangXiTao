package com.tarena.shoot;

import java.util.Random;

//�۷䣺������+����
public class Bee extends FlyingObject implements Award{
	
	private int xSpeed = 1;  //����
	private int ySpeed = 2;
	
	private int awardType;//��������(0/1)
	
	/** ��ʼ��ʵ������ */
	public Bee() {
		image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH-this.width+1);
		y = -this.height;
		awardType = rand.nextInt(2);//0-1֮����������
	}
	
	/** ��ȡ���� */
	public int getType() {
		return awardType;
	}
	
	/** ��д�߲� */
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
