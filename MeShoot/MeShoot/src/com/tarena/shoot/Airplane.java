package com.tarena.shoot;

import java.util.Random;

//�л���������+����
public class Airplane extends FlyingObject implements Enemy{
	
	private int speed = 2; //�ƶ��Ĳ���
	
	/** ��ʼ��ʵ������ */
	public Airplane() {
		image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH-this.width+1);
		y = -this.height;
	}
	
	//  *����*��д�ӿڵķ���
	/** ��ȡ����5 */
	public int getScore() {
		return 5;
	}
	
	/** ��д�߲� */
	public void step() {
		y+=speed;
	}
	
	public boolean outOfBounds() {
		return this.y>=ShootGame.HEIGHT;
	}

}
