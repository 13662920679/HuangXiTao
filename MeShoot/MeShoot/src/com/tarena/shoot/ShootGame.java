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
	
	public static final int WIDTH = 400;//面板宽
	public static final int HEIGHT = 700;//面板高
	
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
	private int state = START; //初始化状态
	
	
	private Hero hero =new Hero();        //英雄机对象
	private FlyingObject[] flyings = {};  //敌人数组（敌机和小蜜蜂）
	private Bullet[] bullets = {};        //子弹数组
	
	static {//初始化静态资源（图片）
		//处理异常
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
	
	/** 随机生成敌人(敌机，蜜蜂) */
	//工厂方法:生产对象，一般为static的
	public FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type < 3) {
			return new Bee();
		}else {
			return new Airplane();
		}
	}
	
	/** 飞行物(敌机和小蜜蜂)入场 */
	int flyEnteredIndex = 0;//飞行物入场计数
	/** 飞行物(敌机和小蜜蜂)入场 */
	//如下代码，每400毫秒生成一个敌机或小蜜蜂
	//并装到数组中
	public void enterAction() {//每10毫秒走一步
		flyEnteredIndex++; //走一步index增1
		if(flyEnteredIndex%30==0) {//走30次，%30为0----300毫秒
			FlyingObject one = nextOne();//随机生成一个对象
			flyings = Arrays.copyOf(flyings, flyings.length+1);//扩容
			flyings[flyings.length-1] = one;//将敌人装到敌人数组的最后一位
		}
	}
	
	/** 飞行物走步 */
	public void stepAction() {
		//英雄机走步----换图片
		hero.step();
		//敌人(敌机和小蜜蜂)走步
		for(int i=0;i<flyings.length;i++) {//遍历敌人数组
			flyings[i].step();
		}
		//子弹走步
		for(int i=0;i<bullets.length;i++) {
			bullets[i].step();
		}
	}
	
	int shootIndex = 0;//控制射击频率
	/** 射击---子弹入场 */
	public void shootAction() {
		shootIndex++;
		if(shootIndex%40==0) {//400毫秒发一次
			Bullet[] bs = hero.shoot();//英雄机发射出来的
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);//扩容
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);//追加
		}
	}
	
	/** 删除越界对象 */
	public void outOfBoundsAction() {
		int index = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		for(int i=0;i<flyings.length;i++) {//遍历敌人数组
			FlyingObject f = flyings[i];
			if(!f.outOfBounds()) {
				flyingLives[index] =f;
				index++;
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);
		
		index = 0;
		Bullet[] bulletLives = new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++) {//遍历子弹数组
			Bullet b = bullets[i];
			if(!b.outOfBounds()) {
				bulletLives[index] = b;
				index++;
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);
	}
	
	/** 所有子弹与所有敌人(敌机和小蜜蜂)的碰撞 */
	public void bangAction() {
		for(int i=0;i<bullets.length;i++) {
			Bullet b = bullets[i];//获取每一个子弹
			bang(b);
		}
	}
	
	int score = 0;//得分
	/** 1个子弹与所有敌人的碰撞 */
	public void bang(Bullet b) {
		int index = -1;//存储被撞敌人的下标
		for(int i=0;i<flyings.length;i++) {
			FlyingObject f = flyings[i];
			if(f.shootBy(b)) {//撞上了
				index = i;
				break;
			}
		}
		if(index!=-1) {//撞上了
			FlyingObject one = flyings[index];//获取被撞的敌人
			if(one instanceof Enemy) {//敌人
				Enemy e = (Enemy)one;//将one强转为敌人
				score += e.getScore();
			}
			if(one instanceof Award) {//奖励
				Award a = (Award)one;//强转为奖励
				int type = a.getType();//获取奖励类型
				switch(type) {
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}
			}
			//将被撞敌人与数组最后一个元素交换
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			//缩容（去掉最后一个元素，即被撞）
			flyings = Arrays.copyOf(flyings, flyings.length-1);
		}
	}
	
	/** 检查游戏是否结束  结束要干的事 */
	public void checkGameOverAction() {
		if(isGameOver()) {//游戏结束
			state = GAME_OVER;
		}
	}
	
	/** 判断游戏是否结束  返回true则结束 */
	public boolean isGameOver() {
		for(int i=0;i<flyings.length;i++) {
			FlyingObject f = flyings[i];
			if(hero.hit(f)) {//撞上了
				hero.subtractLife();//英雄机减命
				hero.clearDoubleFire();//清空火力
				//将被撞敌人与数组最后一个元素交换
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				//缩容
				flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife()<=0;
	}
	
	
	/** 启动执行动操作 */
	public void action() {
		//鼠标事件适配器
		MouseAdapter l = new MouseAdapter() {
			/** 重写mouseMoved(鼠标移动)方法 */
			public void mouseMoved(MouseEvent e) {
				if(state==RUNNING) {//运行状态下					
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x,y);
				}
			}
			/** 重写鼠标点击事件 */
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
			/** 重写鼠标移出事件 */
			public void mouseExited(MouseEvent e) {
				if(state==RUNNING) {
					state = PAUSE;
				}
			}
			/** 重写鼠标移入事件 */
			public void mouseEntered(MouseEvent e) {
				if(state==PAUSE) {
					state = RUNNING;
				}
			}
		};
		this.addMouseListener(l);
		//给当前面板添加鼠标滑动侦听
		this.addMouseMotionListener(l);
		
		Timer timer = new Timer();//创建定时器对象
		int intervel = 10;//时间间隔（毫秒）
		
		//如下代码，每隔10毫秒执行一次run()方法
		timer.schedule(new TimerTask() {//定时触发
			//重写run方法
			public void run() {//定时执行的方法
				if(state==RUNNING) {					
					enterAction();//飞行物入场---new对象
					stepAction();//飞行物走步
					shootAction();//射击(子弹入场)
					outOfBoundsAction();//删除越界对象
					bangAction();//子弹与敌人(敌机和小蜜蜂)的碰撞
					checkGameOverAction();//检查游戏是否结束
				}
				repaint();//重画--调用paint()
			}
		},intervel,intervel);
	}
	
	
	/** 重写paint()   g:画笔 */
	public void paint(Graphics g) {//g为画笔
		g.drawImage(background, 0, 0, null);//画图片
		paintHero(g);//画英雄机
		paintFlyingObjects(g);//画敌人（敌机和小蜜蜂）
		paintBullets(g);//画子弹
		paintScoreAndLife(g);//画分和命
		paintState(g);//画状态
	}
	/** 画英雄机 */
	public void paintHero(Graphics g) {
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	/** 画敌人 */
	public void paintFlyingObjects(Graphics g) {//敌人
		for(int i=0;i<flyings.length;i++) {//遍历敌人数组
			FlyingObject f = flyings[i];
			g.drawImage(f.image,f.x,f.y,null); 
		}
	}
	/** 画子弹 */ 
	public void paintBullets(Graphics g) {
		for(int i=0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			g.drawImage(b.image,b.x,b.y,null);
		}
	}
	/** 画分数和命 */
	public void paintScoreAndLife(Graphics g) {
		g.setColor(new Color(0xFF0000));
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		g.drawString("SCORE:"+score, 10, 25);
		g.drawString("LIFE:"+hero.getLife(), 10, 45);
	}
	/** 画状态 */
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
		
		JFrame frame = new JFrame("Fly");//窗口--画框
		ShootGame game = new ShootGame();//面板对象   **默认执行：静态初始化块  ==>  初始化块  ==>  构造函数
		frame.add(game);//将面板加到窗口中
		
		/** 设置窗口数据 */
		frame.setSize(WIDTH, HEIGHT);//宽高
		frame.setAlwaysOnTop(true);//置顶
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//结束程序
		frame.setLocationRelativeTo(null);//初始位置   null默认居中
		frame.setVisible(true);//1.显示窗口   2.系统直接调用paint()方法
		
		game.action();//启动程序的执行
		
	}
}
