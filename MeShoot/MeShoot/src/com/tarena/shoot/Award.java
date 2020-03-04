package com.tarena.shoot;

//奖励
public interface Award {
	
	public int DOUBLE_FIRE = 0;
	public int LIFE = 1;
	
	//获取奖励类型
	public int getType();

}
