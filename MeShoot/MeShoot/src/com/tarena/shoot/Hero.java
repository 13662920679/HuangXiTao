package com.tarena.shoot;
import java.awt.image.*;
import java.util.Random;

//Ӣ�ۻ���������
public class Hero extends FlyingObject {
	
	private int life;
	private int doubleFire;
	
	private BufferedImage[] images;//ͼƬ����
	private int index;//Э��ͼƬ�л�
	
	public Hero() {
		image = ShootGame.hero0;
		width = image.getWidth();
		height = image.getHeight();
		x = 150;//��ʼ����x
		y = 400;//��ʼ����y
		
		life = 3;//��ʼ����ֵ
		doubleFire = 0;//����ֵΪ�㣬����������
		
		images = new BufferedImage[] {ShootGame.hero0,ShootGame.hero1};
		index = 0;
	}
	
	/** ��д�߲� */
	public void step() {//��ͼƬ
		//step()����������10�Σ���һ��ͼƬ
		//100������һ��ͼƬ
		image = images[index++/10%images.length];
		
		/**
			index++;
			int a = index/10;
			int b = a%2;
			image = images[b];
		 */
	}
	
	/** �ӵ����� */
	public Bullet[] shoot() {
		int xStep = this.width/4;
		int yStep = 20;
		if(doubleFire>0) {//˫������
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x+1*xStep,this.y-yStep);
			bs[1] = new Bullet(this.x+3*xStep, this.y-yStep);
			doubleFire -= 2;
			return bs;
		}else {//��������
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x+2*xStep, this.y-yStep);
			return bs;
		}
	}
	
	/** �ƶ� x:����x����  y:����y���� */
	public void moveTo(int x,int y) {
		this.x = x-this.width/2;
		this.y = y-this.height/2;
	}
	
	public boolean outOfBounds() {
		return false;
	}
	
	/** Ӣ�ۻ����� */
	public void addLife() {
		life++;
	}
	
	/** ��ȡ�� */
	public int getLife() {
		return life;
	}
	
	/** ���� */
	public void subtractLife() {
		life--;
	}
	
	/** Ӣ�ۻ������� */
	public void addDoubleFire() {
		doubleFire+=40;//����ֵ��40
	}
	
	/** ��ջ��� */
	public void  clearDoubleFire() {
		doubleFire = 0;
	}
	
	/** Ӣ�ۻ�ײ���� */
	public boolean hit(FlyingObject obj) {
		int x1 = obj.x-this.width/2;
		int x2 = obj.x+obj.width+this.width/2;
		int y1 = obj.y-this.height/2;
		int y2 = obj.y+obj.height+this.height/2;
		
		//Ӣ�ۻ����ĵ�
		int x = this.x+this.width/2;
		int y = this.y+this.height/2;
		
		return x>x1 && x<x2
				&&
			   y>y1 && y<y2;
	}


}
