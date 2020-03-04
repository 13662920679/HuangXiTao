package com.tarena.shoot;

import java.util.Random;

//�ӵ�:������
public class Bullet extends FlyingObject {
	
	private int speed = 3;//����
	
	/** ��ʼ��ʵ������ */
	//�ӵ���x��y����Ӣ�ۻ���λ�þ�����
	public Bullet(int x,int y) {
		image = ShootGame.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;
		this.y = y;
		
	}
	
	/** ��д�߲� */
	public void step() {
		y-=speed;
	}
	
	public boolean outOfBounds() {
		return this.y<=-this.height;
	}


}
