package com.tarena.shoot;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Fidelity;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ShootGame extends JPanel{
	
	public static final int WIDTH = 400;//����
	public static final int HEIGHT = 700;//����
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START; //��ʼ��״̬
	
	
	private Hero hero =new Hero();        //Ӣ�ۻ�����
	private FlyingObject[] flyings = {};  //�������飨�л���С�۷䣩
	private Bullet[] bullets = {};        //�ӵ�����
	
	static {//��ʼ����̬��Դ��ͼƬ��
		//�����쳣
		try {
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/** ������ɵ���(�л����۷�) */
	//��������:��������һ��Ϊstatic��
	public FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type < 3) {
			return new Bee();
		}else {
			return new Airplane();
		}
	}
	
	/** ������(�л���С�۷�)�볡 */
	int flyEnteredIndex = 0;//�������볡����
	/** ������(�л���С�۷�)�볡 */
	//���´��룬ÿ400��������һ���л���С�۷�
	//��װ��������
	public void enterAction() {//ÿ10������һ��
		flyEnteredIndex++; //��һ��index��1
		if(flyEnteredIndex%30==0) {//��30�Σ�%30Ϊ0----300����
			FlyingObject one = nextOne();//�������һ������
			flyings = Arrays.copyOf(flyings, flyings.length+1);//����
			flyings[flyings.length-1] = one;//������װ��������������һλ
		}
	}
	
	/** �������߲� */
	public void stepAction() {
		//Ӣ�ۻ��߲�----��ͼƬ
		hero.step();
		//����(�л���С�۷�)�߲�
		for(int i=0;i<flyings.length;i++) {//������������
			flyings[i].step();
		}
		//�ӵ��߲�
		for(int i=0;i<bullets.length;i++) {
			bullets[i].step();
		}
	}
	
	int shootIndex = 0;//�������Ƶ��
	/** ���---�ӵ��볡 */
	public void shootAction() {
		shootIndex++;
		if(shootIndex%40==0) {//400���뷢һ��
			Bullet[] bs = hero.shoot();//Ӣ�ۻ����������
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);//����
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);//׷��
		}
	}
	
	/** ɾ��Խ����� */
	public void outOfBoundsAction() {
		int index = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		for(int i=0;i<flyings.length;i++) {//������������
			FlyingObject f = flyings[i];
			if(!f.outOfBounds()) {
				flyingLives[index] =f;
				index++;
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);
		
		index = 0;
		Bullet[] bulletLives = new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++) {//�����ӵ�����
			Bullet b = bullets[i];
			if(!b.outOfBounds()) {
				bulletLives[index] = b;
				index++;
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);
	}
	
	/** �����ӵ������е���(�л���С�۷�)����ײ */
	public void bangAction() {
		for(int i=0;i<bullets.length;i++) {
			Bullet b = bullets[i];//��ȡÿһ���ӵ�
			bang(b);
		}
	}
	
	int score = 0;//�÷�
	/** 1���ӵ������е��˵���ײ */
	public void bang(Bullet b) {
		int index = -1;//�洢��ײ���˵��±�
		for(int i=0;i<flyings.length;i++) {
			FlyingObject f = flyings[i];
			if(f.shootBy(b)) {//ײ����
				index = i;
				break;
			}
		}
		if(index!=-1) {//ײ����
			FlyingObject one = flyings[index];//��ȡ��ײ�ĵ���
			if(one instanceof Enemy) {//����
				Enemy e = (Enemy)one;//��oneǿתΪ����
				score += e.getScore();
			}
			if(one instanceof Award) {//����
				Award a = (Award)one;//ǿתΪ����
				int type = a.getType();//��ȡ��������
				switch(type) {
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}
			}
			//����ײ�������������һ��Ԫ�ؽ���
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			//���ݣ�ȥ�����һ��Ԫ�أ�����ײ��
			flyings = Arrays.copyOf(flyings, flyings.length-1);
		}
	}
	
	/** �����Ϸ�Ƿ����  ����Ҫ�ɵ��� */
	public void checkGameOverAction() {
		if(isGameOver()) {//��Ϸ����
			state = GAME_OVER;
		}
	}
	
	/** �ж���Ϸ�Ƿ����  ����true����� */
	public boolean isGameOver() {
		for(int i=0;i<flyings.length;i++) {
			FlyingObject f = flyings[i];
			if(hero.hit(f)) {//ײ����
				hero.subtractLife();//Ӣ�ۻ�����
				hero.clearDoubleFire();//��ջ���
				//����ײ�������������һ��Ԫ�ؽ���
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				//����
				flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife()<=0;
	}
	
	
	/** ����ִ�ж����� */
	public void action() {
		//����¼�������
		MouseAdapter l = new MouseAdapter() {
			/** ��дmouseMoved(����ƶ�)���� */
			public void mouseMoved(MouseEvent e) {
				if(state==RUNNING) {//����״̬��					
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x,y);
				}
			}
			/** ��д������¼� */
			public void mouseClicked(MouseEvent e) {
				switch(state) {
				case START:
					state = RUNNING;
					break;
				case GAME_OVER:
					score = 0;
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			/** ��д����Ƴ��¼� */
			public void mouseExited(MouseEvent e) {
				if(state==RUNNING) {
					state = PAUSE;
				}
			}
			/** ��д��������¼� */
			public void mouseEntered(MouseEvent e) {
				if(state==PAUSE) {
					state = RUNNING;
				}
			}
		};
		this.addMouseListener(l);
		//����ǰ��������껬������
		this.addMouseMotionListener(l);
		
		Timer timer = new Timer();//������ʱ������
		int intervel = 10;//ʱ���������룩
		
		//���´��룬ÿ��10����ִ��һ��run()����
		timer.schedule(new TimerTask() {//��ʱ����
			//��дrun����
			public void run() {//��ʱִ�еķ���
				if(state==RUNNING) {					
					enterAction();//�������볡---new����
					stepAction();//�������߲�
					shootAction();//���(�ӵ��볡)
					outOfBoundsAction();//ɾ��Խ�����
					bangAction();//�ӵ������(�л���С�۷�)����ײ
					checkGameOverAction();//�����Ϸ�Ƿ����
				}
				repaint();//�ػ�--����paint()
			}
		},intervel,intervel);
	}
	
	
	/** ��дpaint()   g:���� */
	public void paint(Graphics g) {//gΪ����
		g.drawImage(background, 0, 0, null);//��ͼƬ
		paintHero(g);//��Ӣ�ۻ�
		paintFlyingObjects(g);//�����ˣ��л���С�۷䣩
		paintBullets(g);//���ӵ�
		paintScoreAndLife(g);//���ֺ���
		paintState(g);//��״̬
	}
	/** ��Ӣ�ۻ� */
	public void paintHero(Graphics g) {
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	/** ������ */
	public void paintFlyingObjects(Graphics g) {//����
		for(int i=0;i<flyings.length;i++) {//������������
			FlyingObject f = flyings[i];
			g.drawImage(f.image,f.x,f.y,null); 
		}
	}
	/** ���ӵ� */ 
	public void paintBullets(Graphics g) {
		for(int i=0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			g.drawImage(b.image,b.x,b.y,null);
		}
	}
	/** ���������� */
	public void paintScoreAndLife(Graphics g) {
		g.setColor(new Color(0xFF0000));
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		g.drawString("SCORE:"+score, 10, 25);
		g.drawString("LIFE:"+hero.getLife(), 10, 45);
	}
	/** ��״̬ */
	public void paintState(Graphics g) {
		switch(state) {
		case START:
			g.drawImage(start,0,0,null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Fly");//����--����
		ShootGame game = new ShootGame();//������   **Ĭ��ִ�У���̬��ʼ����  ==>  ��ʼ����  ==>  ���캯��
		frame.add(game);//�����ӵ�������
		
		/** ���ô������� */
		frame.setSize(WIDTH, HEIGHT);//���
		frame.setAlwaysOnTop(true);//�ö�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������
		frame.setLocationRelativeTo(null);//��ʼλ��   nullĬ�Ͼ���
		frame.setVisible(true);//1.��ʾ����   2.ϵͳֱ�ӵ���paint()����
		
		game.action();//���������ִ��
		
	}
}
